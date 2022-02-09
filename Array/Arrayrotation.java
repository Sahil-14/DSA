/**
 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 *  Method:1 (Using temp array) 
 * Time complexity : O(n) 
 * Auxiliary Space: O(d)
 *  Method:2 (Rotate one by one) 
 * use leftRotateByOne to rotate array to left by 1 position 
 * Time complexity : O(n * d) 
 * Auxiliary Space : O(1) 
 * Method :3
 * juggling alog
 * Method:4
 * Time Complexity : O(n) Reverse A to get ArB, where Ar is reverse of A.
 * Reverse B to get ArBr, where Br is reverse of B. Reverse all to get (ArBr) r
 * = BA. 
 * Method:5 Bolck swap
 */

public class Arrayrotation {
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    static void cyclicRotateByOne(int arr[]) {
        int n = arr.length;
        int temp = arr[n - 1];
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }

    static void leftRotateBytemp(int arr[], int d, int n) {
        int[] temp = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        for (int j = d; j < n; j++) {
            arr[j - d] = arr[j];
        }

        int c = 0;
        for (int i = n - d; i < n; i++) {
            arr[i] = temp[c++];
        }
    }

    static void leftRotateByOne(int arr[], int n) {
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = temp;
    }

    static void leftRotate(int arr[], int d, int n) {
        for (int i = 0; i < d; i++) {
            leftRotateByOne(arr, n);
        }
    }

    static void leftRotationByJugging(int arr[], int d, int n) {
        /* To handle if d >= n */
        d = d % n;
        int i, j, k, temp;
        int gcd = gcd(d, n);
        for (i = 0; i < gcd; i++) {
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n) {
                    k = k - n;
                }
                if (k == i) {
                    break;
                }
                arr[j] = arr[k];
                j = k;

            }
            arr[j] = temp;
        }
    }

    public static void reverse(int arr[], int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    public static void reverselAlgo(int arr[], int d, int n) {
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    public static void leftRotateBS(int arr[], int d, int n) {
        leftRotateBSRec(arr, 0, d, n);
    }
/*This function swaps d elements
starting at index fi with d elements
starting at index si */
public static void swap(int arr[], int fi,
                        int si, int d)
{
    int i, temp;
    for(i = 0; i < d; i++)
    {
        temp = arr[fi + i];
        arr[fi + i] = arr[si + i];
        arr[si + i] = temp;
    }
}
    public static void leftRotateBSRec(int arr[], int i, int d, int n) {
        /*
         * Return If number of elements to be rotated is zero or equal to array size
         */
        if (d == 0 || d == n)
            return;

        /*
         * If number of elements to be rotated is exactly half of array size
         */
        if (n - d == d) {
            swap(arr, i, n - d + i, d);
            return;
        }

        /* If A is shorter */
        if (d < n - d) {
            swap(arr, i, n - d + i, d);
            leftRotateBSRec(arr, i, d, n - d);
        } else /* If B is shorter */
        {
            swap(arr, i, d, n - d);
            leftRotateBSRec(arr, n - d + i, 2 * d - n, d); /* This is tricky */
        }
    }

    public static void main(String arg[]) {

        int arr[] = new int[] { 1, 2, 3, 4, 5 };
        int n = arr.length;
        // cyclicRotateByOne(arr);
        // leftRotateBytemp(arr, 4, n);
        // leftRotate(arr, 5, n);
        reverselAlgo(arr, 4, n);
        ArrayOperations.printArray(arr, n);
    }
}
