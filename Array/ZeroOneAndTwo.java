public class ZeroOneAndTwo {
    static void sort012(int a[]) {
        int lo = 0;
        int hi = a.length - 1;
        int temp;
        int mid = 0;

        while (mid <= hi) {
            switch (a[mid]) {
                case 0: {
                    temp = a[lo];
                    a[lo] = a[mid];
                    a[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }

                case 2: {
                    temp = a[hi];
                    a[hi] = a[mid];
                    a[mid] = temp;
                    hi--;
                    break;
                }

            }
        }
    }

    static void sort012usingCounter(int a[]) {
        int i, c0 = 0, c1 = 0, c2 = 0;
       int n = a.length;
        // Count the number of 0s, 1s and 2s in the array
        for (i = 0; i < n; i++) {
            switch (a[i]) {
            case 0:
                c0++;
                break;
            case 1:
                c1++;
                break;
            case 2:
                c2++;
                break;
            }
        }

      i = 0;
        while (c0 > 0) {
            a[i++] = 0;
            c0--;
        }
        while (c1 > 0) {
            a[i++] = 1;
            c1--;
        }
        while (c2 > 0) {
            a[i++] = 2;
            c2--;
        }
    }

    static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };

        // sort012(arr);
        sort012usingCounter(arr);
        // // byUsingTwoPointer(arr);
        printArray(arr);

    }
}
