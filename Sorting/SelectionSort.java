// find the minimum element in the unsorted array and swap it with the begining element
public class SelectionSort {
    void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[min_idx])
                    min_idx = j;
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
    }

    void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String arg[]) {
        SelectionSort ss = new SelectionSort();
        int A[] = { 11, 19, 0, -1, 5, 6, 16, -3, 6, 0, 14, 18, 7, 21, 18, -6, -8 };
        // int A[] = { 11, 9, 0, 4, 6, -1, 13 };
        ss.sort(A);
        ss.printArray(A);
    }
}
