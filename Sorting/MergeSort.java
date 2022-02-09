public class MergeSort {
    public void sort(int arr[]) {
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int arr[], int low, int high) {
        if (low >= high) {   // the most important condition in merge sort;
            return;
        }

        int mid = (low + high) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        sortedMerge(arr, low, high);
    }

    public void sortedMerge(int arr[], int low, int high) {
        int middle = (high + low) / 2;
        int temp[] = new int[high - low + 1];
        int i = low;
        int j = middle + 1;
        int r = 0;
        while (i <= middle && j <= high) {
            if (arr[i] < arr[j]) {
                temp[r++] = arr[i++];
            } else {
                temp[r++] = arr[j++];
            }
        }
        
        while (i <= middle) {
            temp[r++] = arr[i++];
        }

        while (j <= high) {
            temp[r++] = arr[j++];
        }

        i = low;
        // important we are not imcreamenting k here
        for (int k = 0; k < temp.length;) {
            arr[i++] = temp[k++];
        }
    }

    void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String arg[]) {
        int input1[] = { 1 };
        int input2[] = { 4, 2 };
        int input3[] = { 6, 2, 9 };
        int input4[] = { 6, -1, 10, 4, 11, 14, 19, 12, 18 };
        MergeSortLinkedList ms = new MergeSortLinkedList();
        ms.sort(input1);
        ms.sort(input2);
        ms.sort(input3);
        ms.sort(input4);
        ms.printArray(input1);
        ms.printArray(input2);
        ms.printArray(input3);
        ms.printArray(input4);

        
    }

}
