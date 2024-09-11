#include <iostream>
#include <vector>
#include <fstream>
#include <sstream>
#include <string>
#include <cassert>

using namespace std;

int searchMaxNumber(const vector<int>& arr, int start, int end) {
    if (start > end) {
        return -1;
    }
    if (start == end) {
        return arr[start];
    }
    int mid = start + (end - start) / 2;
    int leftMax = searchMaxNumber(arr, start, mid);
    int rightMax = searchMaxNumber(arr, mid + 1, end);
    return max(leftMax, rightMax);
}

int searchMaxNumber(const vector<int>& arr) {
    if (arr.empty()) {
        return -1;
    }
    return searchMaxNumber(arr, 0, arr.size() - 1);
}

void runTests() {
    vector<int> emptyArray;
    assert(searchMaxNumber(emptyArray) == -1);

    vector<int> singleValueArray;
    singleValueArray.push_back(1);
    assert(searchMaxNumber(singleValueArray) == 1);

    vector<int> mixedArray;
    mixedArray.push_back(-100);
    mixedArray.push_back(0);
    mixedArray.push_back(200);
    mixedArray.push_back(-300);
    mixedArray.push_back(150);
    assert(searchMaxNumber(mixedArray) == 200);

    string testDataFilePath = "MaxNumberData.txt";
    ifstream file(testDataFilePath);
    string line;
    while (getline(file, line)) {
        istringstream ss(line);
        string arrayString;
        getline(ss, arrayString, '|');
        string expectedString;
        getline(ss, expectedString);
        
        vector<int> arr;
        istringstream arrayStream(arrayString);
        string numberString;
        while (getline(arrayStream, numberString, ',')) {
            arr.push_back(stoi(numberString));
        }
        
        int expectedResult = stoi(expectedString);
        assert(searchMaxNumber(arr) == expectedResult);
    }
}

int main() {
    runTests();

    cout << "Тест дууслаа";
    return 0;
}
