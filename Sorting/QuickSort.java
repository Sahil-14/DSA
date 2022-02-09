/* dicide on pivot element and arrange elements in a such way that all element at right of pivot are less than pivot and elements at 
right of pivot is greater than it

*/
public class QuickSort {
    private void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // public int split(int arr[], int low, int high) {
    // int pivot = low;
    // int i = low + 1;
    // int j = high;
    // while (i > j) {
    // while (i <= j && arr[pivot] >= arr[i]) {
    // i++;
    // }
    // while (j >= i && arr[pivot] < arr[j]) {
    // j++;
    // }
    // if (i > j && arr[i] > arr[j]) {
    // swap(arr, i, j);
    // }
    // }
    // if (arr[pivot] > arr[j]) {
    // swap(arr, j, pivot);

    // }
    // return j;
    // }

    // private int split1(int A[], int low, int high) {

    // int pivot = low;
    // int i = low + 1;
    // int j = high;
    // while (i <= j) {

    // if (A[i] <= A[pivot]) {
    // i++;
    // continue;
    // }
    // if (A[j] > A[pivot]) {
    // j--;
    // continue;
    // }
    // swap(A, i++, j--);
    // }
    // if (A[pivot] > A[j]) {
    // swap(A, pivot, j);
    // return j;
    // }
    // return pivot;

    // }
    // notes
    /**
     * initialize i with l-1
     * here i will point at last number which is less than pivat
     * i+1 is greater than pivot hence if arr[j] < pivot swap i and j
     * after end of data
     * swap i+1 and r because i is last index where element is smaller than r
     */
    public int partition(int arr[], int l, int r) {

        int i = l - 1, j;
        int pivot = arr[r];
        for (j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    public void sort(int arr[], int low, int high) {
        if (low < high) {
            int pos = partition(arr, low, high);
            sort(arr, low, pos - 1);
            sort(arr, pos + 1, high);
        }

    }

    void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String arg[]) {
        QuickSort qs = new QuickSort();
        int A[] = { 11, 19, 0, -1, 5, 6, 16, -3, 6, 0, 14, 18, 7, 21, 18, -6, -8 };
        // int A[] = { 11, 9, 0, 4, 6, -1, 13 };
        qs.sort(A, 0, A.length - 1);
        qs.printArray(A);
    }
}
