package SelectionSort;
import java.util.Random;
import java.util.Scanner;

public class SelectionSort {

    public static int[] sort(int[] arr) {
        int counter = 0;
        int size = arr.length -1;

        while(counter <= size){
            
            int min = findMinimium(arr, counter);
            swap(arr, counter, min);
            counter++;
        }
        return arr;
    }

    public static int findMinimium(int arr[], int counter){
        int min = arr[counter];
        int k = counter;

        for(int i=counter; i<arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
                k = i;
            }
        }
        return k;
    }

    public static void swap(int[] arr, int counter, int min){
        int temp = arr[counter];
        arr[counter] = arr[min];
        arr[min] = temp;
    }

    public static int[] generateRawData(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("(Selection Sort)Хэдэн тоогоор теслэхээ оруулна уу: ");
        int n = scanner.nextInt();

        System.out.println("Хэдээс хэдийн хооронд тестлэх вэ?");
        System.out.print("Эхний утга: ");
        int valueOne = scanner.nextInt();

        System.out.print("Хоёрдахь утга: ");
        int valueTwo = scanner.nextInt();

        int[] rawData = new int[n];
        
        for (int i = 0; i < n; i++) {
            rawData[i] = (random.nextInt() % (valueOne-valueTwo+1)) + valueOne;
        }
        scanner.close();

        return rawData;
    }

    public static void printArray(int[] arr){
        for(int item : arr){
            System.out.print(item + " ");
        }
    }
    public static void main(String args[]){
        int[] arr = generateRawData();

        System.out.println("\nRawData:");
        printArray(arr);

        System.out.println();

        int[] sortedArr = sort(arr);
        System.out.println("Sorted Data");
        printArray(sortedArr);
    }
}