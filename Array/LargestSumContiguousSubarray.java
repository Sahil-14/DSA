/**
 * Write an efficient program to find the sum of contiguous subarray within a
 * one-dimensional array of numbers that has the largest sum.
 * 
 */

public class LargestSumContiguousSubarray {
    static int kadanesAlgo(int arr[], int n) {
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
        for (int i = 0; i < n; i++) {
            max_ending_here = max_ending_here + arr[i];
            if (max_ending_here > max_so_far)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    static int maxSubArraySumDp(int arr[]) {
        int max_so_far = arr[0];
        int current_max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            current_max = Math.max(arr[i], current_max + arr[i]);
            max_so_far = Math.max(max_so_far, current_max);
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println("Maximum contiguous sum is " + kadanesAlgo(a, a.length));
    }
}
