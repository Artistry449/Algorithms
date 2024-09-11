package BinarySearch;
public class BinarySearch_Iterative{

    public static int binarySearch(int[] arr, int item){
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            int guess = arr[mid];

            if(guess == item){
                return mid;
            }
            if(guess < item){
                low = mid + 1;
            }
            else if(guess > item){
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int target = 8;

        System.out.println(binarySearch(arr, target));
    }
}