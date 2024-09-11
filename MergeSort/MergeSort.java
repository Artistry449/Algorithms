package MergeSort;

public class MergeSort {

    public static int[] Merge_Sort(int[] arr, int start, int end){
        if(start >= end) return new int[] {};
        int mid = (start + end) / 2;

        Merge_Sort(arr, start, mid);
        Merge_Sort(arr, mid+1, end);

        return Merge(arr, start, mid, end);
    }

    public static int[] Merge(int[] arr, int start, int mid, int end){
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int left[] = new int[n1];
        int right[] = new int[n2];

        for(int i=0; i<n1; i++){
            left[i] = arr[i + 1];
        }
        for(int i=mid; i<n2; i++){
            right[i] = arr[i];
        }

        int i=0;
        int j=0;

        
    }

    public static void main(String[] args) {
        int[] arr = { 9,8,7,6,5,4,3,2,1 };

        for(int item: arr){
            System.out.print(item + " ");
        }
        System.out.println();

        Merge_Sort(arr, 0, arr.length);
    }
}
