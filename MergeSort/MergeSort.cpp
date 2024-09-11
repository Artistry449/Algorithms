#include <iostream>
#include <sstream>
#include <fstream>
#include <vector>
#include <cassert>

using namespace std;

void arr_negtgeh(int arr[], int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;

    int L[n1], R[n2];

    for (int i = 0; i < n1; ++i) {
        L[i] = arr[l + i];
    }

    for (int i = 0; i < n2; ++i) {
        R[i] = arr[m + 1 + i];
    }

    int i = 0, j = 0, k = l;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}

void sort(int arr[], int l, int r) {
    if (l < r) {
        int m = l + (r - l) / 2;

        sort(arr, l, m);
        sort(arr, m + 1, r);

        arr_negtgeh(arr, l, m, r);
    }
}

vector<vector<int> > readFile(const string& filename) {
    vector<vector<int> > arrays;
    ifstream file(filename);
    string line;

    if (!file.is_open()) {
        cerr << "Файлыг нээх явцад алдаа гарлаа! " << filename << endl;
        exit(1);
    }

    while (getline(file, line)) {
        vector<int> numbers;
        istringstream iss(line);
        int num;
        while (iss >> num) {
            numbers.push_back(num);
        }
        arrays.push_back(numbers);
    }

    file.close();
    return arrays;
}

void testMergeSortFromFile() {

    vector<vector<int> > inputArrays = readFile("/Users/enkhbayarganbold/Desktop/Algorithm-Analysis/lab2/SortAlgorithmInput.txt");
    vector<vector<int> > expectedSortedArrays = readFile("/Users/enkhbayarganbold/Desktop/Algorithm-Analysis/lab2/SortAlgorithmOutput.txt");

    for (int i = 0; i < inputArrays.size(); i++) {

        cout << "Массив[" << i << "]:"<< endl;
        vector<int> inputArray = inputArrays[i];
        vector<int> expectedArray = expectedSortedArrays[i];

        cout << "Оролт: ";
        for(int j=0; j<inputArray.size(); j++){
            cout << inputArray[j] << " ";
        }
        cout<<endl;

        cout << "Гаралт: ";
        for(int j=0; j<expectedArray.size(); j++){
            cout << expectedArray[j] << " ";
        }

        sort(inputArray.data(), 0, inputArray.size() - 1);

        assert(inputArray == expectedArray);

        cout<<"\n                                --passed\n";
    }

    cout << "all passed" << endl;
}

int main(){
    testMergeSortFromFile();
}