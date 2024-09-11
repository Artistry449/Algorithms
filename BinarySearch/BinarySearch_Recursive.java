package BinarySearch;
public class BinarySearch_Recursive{
    public int binarySearch(int[] arr, int target, int low, int high){

        if(low <= high){
        int mid = (low + high) / 2;
        int guess = arr[mid];

        if(guess == target) return mid;
        else if(guess < target){
            return binarySearch(arr, target, mid+1, high);
        }
        else if(guess > target){
            return binarySearch(arr, target, low, mid - 1);
        }
        }
        return -1;
    }
    
    public static void main(String args[]){
        BinarySearch_Recursive binarySearch = new BinarySearch_Recursive();
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int target = 8;

        System.out.println(binarySearch.binarySearch(arr, target, 0, arr.length - 1));
    }
}