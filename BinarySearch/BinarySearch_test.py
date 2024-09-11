import unittest
from BinarySearch import BinarySearchRecursive

class TestBinarySearch(unittest.TestCase):
    
    def test_binary_search_from_file(self):
        binary_search = BinarySearchRecursive()
        
        with open('BinarySearchData.txt', 'r') as file:
            for line in file:
                parts = line.strip().split('|')
                
                arr = list(map(int, parts[0].strip().split(',')))
                
                key = int(parts[1].strip())
                expected_result = int(parts[2].strip())
                
                actual_result = binary_search.binary_search(arr, key, 0, len(arr) - 1)
                
                self.assertEqual(expected_result, actual_result, f"Binary search failed for input: {arr} and key: {key}")

if __name__ == "__main__":
    unittest.main()
