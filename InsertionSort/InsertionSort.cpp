#include <iostream>
#include <fstream>
#include <sstream>
#include <cassert>

using namespace std;

void insertionSort(int arr[], int size) {
    for(int i=1; i<size; i++){
        for(int j=i-1; j>=0; j--){
            if(arr[i] < arr[j] ){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i = j;
            }
        }
    }
}

void printArray(const int arr[], int size) {
    for (int i = 0; i < size; ++i) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

void readFile(const string& filename, int arrays[][100], int sizes[], int& numArrays) {
    ifstream file(filename);
    string line;
    numArrays = 0;

    while (getline(file, line)) {
        istringstream iss(line);
        int number;
        int index = 0;
        while (iss >> number) {
            arrays[numArrays][index++] = number;
        }
        sizes[numArrays] = index;
        ++numArrays;
    }
}

int main() {
    const int MAX_ARRAYS = 100;
    const int MAX_SIZE = 100;
    int inputArrays[MAX_ARRAYS][MAX_SIZE];
    int expectedSortedArrays[MAX_ARRAYS][MAX_SIZE];
    int inputSizes[MAX_ARRAYS];
    int expectedSizes[MAX_ARRAYS];
    int numInputArrays, numExpectedArrays;

    readFile("/Users/enkhbayarganbold/Desktop/Algorithm-Analysis/lab2/SortAlgorithmInput.txt", inputArrays, inputSizes, numInputArrays);
    readFile("/Users/enkhbayarganbold/Desktop/Algorithm-Analysis/lab2/SortAlgorithmOutput.txt", expectedSortedArrays, expectedSizes, numExpectedArrays);

    for (int i = 0; i < numInputArrays; ++i) {
        int size = inputSizes[i];
        int* inputArray = inputArrays[i];
        int* expectedArray = expectedSortedArrays[i];

        cout << "arr: ";
        printArray(inputArray, size);
        cout << "ur dun: ";
        printArray(expectedArray, size);

        insertionSort(inputArray, size);

        bool passed = true;
        for (int j = 0; j < size; ++j) {
            if (inputArray[j] != expectedArray[j]) {
                passed = false;
                break;
            }
        }

        if (passed) {
            cout << "Result: ";
            printArray(inputArray, size);
            cout << "passed" << endl;
        } else {
            cout << "failed" << endl;
        }
    }

    return 0;
}
