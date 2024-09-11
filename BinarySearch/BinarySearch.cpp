#include <iostream>

using namespace std;

int binarySearch(int arr[], int target, int low, int high) {
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

int main() {
    int arr[]= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int target = 8;

    int result = binarySearch(arr, target, 0, sizeof(arr)/sizeof(int) - 1);
    cout << result << std::endl;

    return 0;
}
