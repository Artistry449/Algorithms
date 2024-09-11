package MaxNumber;

import java.util.Arrays;

public class MaxNumber {

    public int searchMaxNumber(int[] arr){

        if(arr.length == 0){
            return -1;
        }
        else if(arr.length == 1){
            return arr[0];
        }
        else if(arr.length == 2){
            return arr[0] > arr[1] ? arr[0] : arr[1];
        }
        else{
            int left = searchMaxNumber(Arrays.copyOfRange(arr, 0, arr.length / 2));
            int right = searchMaxNumber(Arrays.copyOfRange(arr, arr.length / 2, arr.length));

            return left > right ? left : right;
        }
    }
    public static void main(String[] args) {
        MaxNumber maxNumber = new MaxNumber();

        int[] arr = { 1,2,3, -100000, 10000, 22, 0 };

        for(int item: arr){
            System.err.print(item + " ");
        }
        System.out.println();

        System.out.println(maxNumber.searchMaxNumber(arr));
    }
}
