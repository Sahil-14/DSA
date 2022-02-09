/**
 * find the count of every distinct elements in array calculate the position of
 * each element in the sorted array
 * 
 * conunt of every distint element in an array
 * calculate position of each element in sorted array
 * 
 * algo -
 * make count array to store count of distint element
 * modify count array by count[i] = count[i]+count[i-1]
 * 
 * 
 */
public class CountSort {
    void sort(int arr[]) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int[] count = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {

            count[arr[i]]++;
        }
        // modify count array

        for (int j = 1; j < count.length; j++) {
            count[j] += count[j - 1];
        }
        int[] arr2 = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            // int current = arr[i];
            // int index = --count[arr[i]];
            arr2[--count[arr[i]]] = arr[i];

        }
        printArray(arr2);
    }

    void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public void selectionSort(int arr[], int n) {
        // sorted array
        for (int i = 0; i < n - 1; i++) {
            // unsorted array
            int min_ind = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[min_ind] > arr[j])
                    min_ind = j;
            }
            int temp = arr[i];
            arr[i] = arr[min_ind];
            arr[min_ind] = temp;
        }
    }

    public void insertionSort(int arr[], int n) {
        // select current
        for (int i = 1; i < n; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    public static void main(String arg[]) {
        CountSort cs = new CountSort();
        int A[] = { 11, 19, 0, 1, 5, 6, 16, 3, 6, 0, 14, 18, 7, 21, 18, 6, 8 };
        // int A[] = {2,4,3,5,6,2,3,4};

        cs.sort(A);

    }
}
