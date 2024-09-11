package InsertionSort;
class InsertionSort{

    public int[] sort(int[] arr){

        for(int i=1; i<arr.length; i++){
            for(int j=i-1; j>=0; j--){
                if(arr[i] < arr[j] ){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    i = j;
                }
            }
        }

        return arr;
    }
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] arr = { 23, 1, 10, 5, 2,10,1,1,2,3,999,-100 };

        for(int item: arr){
            System.out.print(item + " ");
        }
        System.out.println();

        int[] arr2 = insertionSort.sort(arr);

        for(int item: arr2){
            System.out.print(item + " ");
        }

    }
}