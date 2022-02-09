import java.util.Arrays;

public class MaxMinHeightDifference {
    static int getMinDiff(int arr[], int n, int k) {
        if (n == 1) {
            return 0;
        }
        Arrays.sort(arr);
        int ans = arr[n - 1] - arr[0];
        int small = arr[0] + k;
        int big = arr[n - 1] - k;
        int temp = 0;

        if (small > big) {
            temp = small;
            small = big;
            big = temp;
        }

        // traverse middle elements
        for (int i = 1; i < n - 1; i++) {
            int subtract = arr[i] - k;
            int add = arr[i] + k;

            // If both subtraction and addition
            // do not change diff
            if (subtract >= small || add <= big)
                continue;

            // Either subtraction causes a smaller
            // number or addition causes a greater
            // number. Update small or big using
            // greedy approach (If big - subtract
            // causes smaller diff, update small
            // Else update big)
            if (big - subtract <= add - small) {
                small = subtract;
            } else {
                big = add;
            }
        }
        return Math.min(ans, big - small);
    }

    public static void main(String[] args) {
        // int arr[] = { 4, 6 };
        int arr[] = {1, 5, 15, 10} ;
        // int arr[] = {1, 10, 14, 14, 14, 15};
        // int arr[] = {1, 2, 3}
        int n = arr.length;
        int k = 3;
        System.out.println("Maximum difference is " + getMinDiff(arr, n, k));
    }
}
