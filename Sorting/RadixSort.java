public class RadixSort {
    public void radixSort(int arr[]) {
        int n = getMax(arr);
        for (int exp = 1; (n / exp) > 0; exp = exp * 10) {
            countSort(arr, exp);
        }
    }

    public void countSort(int arr[], int exp) {

        // make counting array
        int[] count = new int[10];
        for (int i = 0; i < arr.length; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        // modify counting array
        for (int i = 1; i < 10; i++) {
            count[i] = count[i] + count[i - 1];
        }

        int[] output = new int[arr.length];
        System.out.println(output.length);
        for (int i = arr.length - 1; i >= 0; --i) {

            output[--count[(arr[i] / exp) % 10]] = arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    public int getMax(int arr[]) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String arg[]) {
        RadixSort rs = new RadixSort();
        int A[] = { 11, 19, 0, 1, 5, 6, 16, 3, 6, 0, 14, 18, 7, 21, 18, 6, 8 };
        rs.radixSort(A);
        // rs.printArray(A);
        // for (int e = 1; 345 / e > 0; e = e * 10) {
        // System.out.println(345 % e);
        // }
    }
}

// it does not changes original order