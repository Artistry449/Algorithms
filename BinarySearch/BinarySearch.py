class BinarySearchRecursive:
    def binary_search(self, arr, target, low, high):
        if low <= high:
            mid = (low + high) // 2
            guess = arr[mid]

            if guess == target:
                return mid
            elif guess < target:
                return self.binary_search(arr, target, mid + 1, high)
            else:
                return self.binary_search(arr, target, low, mid - 1)
        return -1

if __name__ == "__main__":
    binary_search = BinarySearchRecursive()
    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    target = 8

    print(binary_search.binary_search(arr, target, 0, len(arr) - 1))