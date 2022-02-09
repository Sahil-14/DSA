// like a shuffeling cards
//insert an element from an unsorted array to its correct position
//
public class InsertionSort {
    void sort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while( j >= 0 && arr[j] >current) {
               
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
    }
    void printArray(int arr[]){
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
    public static void main(String arg[]){
        InsertionSort is = new InsertionSort();
        // int A[] = { 11, 19, 0, -1, 5, 6, 16, -3, 6, 0, 14, 18, 7, 21, 18, -6, -8 };
        int A[] = { 11, 9, 0, 4, 6, -1, 13 };
        is.sort(A);
        is.printArray(A);
    }
}
