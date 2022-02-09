import java.util.*;

// 1.subarray
public class prob9 {

    // o(n^3)
    static void subarrayPrint(int a[]) {
        int n = a.length;
        // int maxsum = Integer.MIN
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // int sum = 0;
                for (int k = i; k <= j; k++) {
                    System.out.print(a[k] + " ");
                    // sum+=a[k];
                }
                // maxsum = max(maxsum,sum);
                System.out.println();
            }

        }
    }

    // Maximum subarray sum problem using cumulative sum approch
    // O(n^2)
    static int maxSubarraySumCumulative(int n) {
        int a[] = new int[n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int currsum[] = new int[n + 1];
        currsum[0] = 0;
        // It stores the sum of subarray from 0 to i;
        for (int i = 1; i < n; i++) {
            currsum[i] = currsum[i - 1] + a[i - 1];
        }
        int maxsum = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum = currsum[i] - currsum[j];
                maxsum = Math.max(sum, maxsum);
            }
        }
        return maxsum;
    }

    // Kadanes algorithm
    // O(n)
    static int kadanesAlgo(int a[]) {
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
        for (int i = 0; i < a.length; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_ending_here > max_so_far) {
                max_so_far = max_ending_here;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        return max_so_far;
    }

    static int kadanes2(int a[], int n) {
        int currsum = 0;
        int maxsum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            currsum += a[i];
            if (currsum < 0) {
                currsum = 0;
            }
            maxsum = Math.max(maxsum, currsum);
        }

        return maxsum;
    }

    // weapsum = totalsum - sum of non-contributing elements
    // We can get sum of non-contributing elements by inverting the sign of an array
    // elements and finding it max subarray sum
    static int circularSubarraySum(int a[], int n) {
        int wrapsum;
        int nonwrapsum;

        nonwrapsum = kadanes2(a, n);
        int totalsum = 0;
        for (int i = 0; i < n; i++) {
            totalsum += a[i];
            a[i] = -a[i];
        }

        wrapsum = totalsum + kadanes2(a, n);
        return Math.max(wrapsum, nonwrapsum);

    }

    // Pairsum check whether 2 elements in an array sums to the given value of not
    static boolean pairsumBF(int a[], int k) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] + a[j] == k) {
                    System.out.println(i + " " + j);
                    return true;
                }
            }
        }
        return false;
    }

    // it require sorting
    static boolean pairsum(int a[], int n, int k) {

        Arrays.sort(a);
        int low = 0;
        int high = n - 1;
        for (int i : a) {
            System.out.println(i);
        }
        boolean flag = false;
        while (low < high) {
            if ((a[low] + a[high]) == k) {
                return true;
            } else if ((a[low] + a[high]) > k) {
                high--;
            } else {
                low++;
            }
        }
        return false;
    }

    public static void main(String arg[]) {
        // int[] a = { 4,-4,6,-6,10,-10,12 };
        // int a[] = {2,4,7,11,14,16,20,21};
        int a[] = { 1, 4, 45, 6, 10, 8 };
        // System.out.println(kadanesAlgo(a));
        // System.out.println(circularSubarraySum(a, a.length));

        System.out.println(pairsum(a, 6, 16));

    }
}