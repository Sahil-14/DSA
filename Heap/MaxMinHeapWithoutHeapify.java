// Time complexity = nlogn

/**
 *   Up
 *    ^
 *    |
 * Bottom
 */
public class MaxMinHeapWithoutHeapify {
    public static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    static int findMin(int arr[]){
            return arr[0];
    }
    static int findMax(int arr[]){
        return arr[0];
    }
    public static void printArray(int arr[], int n) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void maxHeap(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            int current = i;
            int parent = (i - 1) / 2;
            while (current > 0 && arr[current] > arr[parent]) {
                swap(arr, current, parent);
                current = parent;
                parent = (current - 1) / 2;
            }

        }
    }

    public static void minHeap(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            int current = i;
            int parent = (i - 1) / 2;
            while (current > 0 && arr[current] < arr[parent]) {
                swap(arr, current, parent);
                current = parent;
                parent = (current - 1) / 2;
            }
        }
    }

    public static void main(String arg[]) {
        // int arr[] ={4, 10, 3, 5, 1};
        int arr[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
        int n = arr.length;
        maxHeap(arr, n);
        printArray(arr, n);
        minHeap(arr, n);
        printArray(arr, n);
    }
}