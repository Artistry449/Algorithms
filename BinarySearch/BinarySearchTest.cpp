#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <string>

using namespace std;

int binarySearch(const vector<int>& arr, int target, int low, int high) {
    if (low <= high) {
        int mid = low + (high - low) / 2;
        int guess = arr[mid];

        if (guess == target) return mid;
        else if (guess < target) {
            return binarySearch(arr, target, mid + 1, high);
        }
        else {
            return binarySearch(arr, target, low, mid - 1);
        }
    }
    return -1;
}


void runTests() {
    ifstream file("/Users/enkhbayarganbold/Desktop/Algorithm-Analysis/lab2/BinarySearchData.txt");
    if (!file.is_open()) {
        cout << "Файлыг онгойлгоход алдаа гарлаа!" << endl;
        return;
    }

    string line;
    while (getline(file, line)) {
        stringstream ss(line);
        string arrStr, keyStr, expectedStr;

        getline(ss, arrStr, '|');
        getline(ss, keyStr, '|');
        getline(ss, expectedStr, '|');

        vector<int> arr;
        stringstream arrStream(arrStr);
        string number;
        while (getline(arrStream, number, ',')) {
            arr.push_back(stoi(number));
        }

        int key = stoi(keyStr);
        int expectedResult = stoi(expectedStr);

        int actualResult = binarySearch(arr, key, 0, arr.size() - 1);

        if (expectedResult != actualResult) {
            cout << "Алдаа: ";

            for (int num : arr) {
                cout << num << " " << endl;
            }
        } 
        else {
            cout << "PASS: ";

            for (int num : arr) {
                cout << num << " ";
            }    
            cout << endl;
        }
    }

    file.close();
}

int main() {
    runTests();
    return 0;
}
