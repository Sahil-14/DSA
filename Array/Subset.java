import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Subset {
    // Method :1 using hashset
    static boolean isSubset1(int arr1[], int arr2[], int m, int n) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < m; i++) {
            if (!hs.contains(arr1[i]))
                hs.add(arr1[i]);
        }

        for (int i = 0; i < n; i++) {
            if (!hs.contains(arr2[i]))
                return false;
        }
        return true;
    }

    // Method 2: using set.
    static boolean isSubset2(int arr1[], int arr2[], int m, int n) {

        Set<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < m; i++) {
            s.add(arr1[i]);
        }
        int p = s.size();
        for (int i = 0; i < n; i++) {
            s.add(arr2[i]);
        }
        int q = s.size();
        if (p == q)
            return true;
        return false;
    }

    // method 3: using frequency table
    static boolean isSubset3(int arr1[], int arr2[], int m, int n) {
        HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        for (int i = 0; i < m; i++) {
            frequency.put(arr1[i], frequency.getOrDefault(arr1[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (frequency.getOrDefault(arr2[i], 0) > 0)
                frequency.put(arr2[i], frequency.get(arr2[i]) - 1);
            else
                return false;
        }
        
        return true;
    }

    // Method 4: sorting and merging
    static boolean isSubset4(int arr1[], int arr2[], int m, int n) {
        int i = 0;
        int j = 0;
        if (m < n)
            return false;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        while (i < m && j < n) {
            if (arr1[i] < arr2[j])
                i++;
            else if (arr1[i] == arr2[j]) {
                i++;
                j++;
            } else if (arr1[i] > arr2[j])
                j++;
        }
        if (j < n)
            return false;
        else
            return true;
    }

    // Method 5: sorting and binary search
    static boolean isSubset5(int arr1[], int arr2[], int m, int n) {
        int i = 0;

        sort(arr1, 0, m - 1);
        for (i = 0; i < n; i++) {
            if (binarySearch(arr1, 0, m - 1, arr2[i]) == -1)
                return false;
        }

        /*
         * If we reach here then all elements of arr2[] are present in arr1[]
         */
        return true;
    }

    static int binarySearch(int arr[], int l, int h, int x) {
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x) {
                return arr[mid];
            } else if (x > arr[mid]) {
                return binarySearch(arr, mid + 1, h, x);
            } else {
                return binarySearch(arr, l, mid - 1, x);
            }
        }
        return -1;
    }

    static int partition(int arr[], int l, int h) {
        int pivot = arr[h];
        int i = l - 1, j;
        for (j = l; j < h; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[j];
        arr[j] = temp;
        return i + 1;
    }

    static void sort(int arr[], int l, int h) {
        if (l < h) {
            int partition = partition(arr, l, h);
            sort(arr, l, partition - 1);
            sort(arr, partition + 1, h);
        }
    }

    // method 6 : 2 for loop
    static boolean isSubset6(int arr1[], int arr2[], int m, int n) {
        int i = 0;
        int j = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++)
                if (arr2[i] == arr1[j])
                    break;

            /*
             * If the above inner loop was not broken at all then arr2[i] is not present in
             * arr1[]
             */
            if (j == m)
                return false;
        }

        /*
         * If we reach here then all elements of arr2[] are present in arr1[]
         */
        return true;
    }

    public static void main(String arg[]) {
        int arr1[] = { 11, 1, 13, 21, 3, 7 };
        int arr2[] = { 11, 3, 7, 1 };

        int m = arr1.length;
        int n = arr2.length;
        // if (isSubset1(arr1, arr2, m, n))
        // System.out.println("arr2 is a subset of arr1");
        // else
        // System.out.println("arr2 is not a subset of arr1");
        // if (isSubset2(arr1, arr2, m, n))
        // System.out.println("arr2 is a subset of arr1");
        // else
        // System.out.println("arr2 is not a subset of arr1");
        // if (isSubset3(arr1, arr2, m, n))
        // System.out.println("arr2 is a subset of arr1");
        // else
        // System.out.println("arr2 is not a subset of arr1");
        if (isSubset4(arr1, arr2, m, n))
            System.out.println("arr2 is a subset of arr1");
        else
            System.out.println("arr2 is not a subset of arr1");
    }
}
