public class MaximumProductSubarray {
    // Utility functions to get
    // minimum of two integers
    static int min(int x, int y) {
        return x < y ? x : y;
    }

    // Utility functions to get
    // maximum of two integers
    static int max(int x, int y) {
        return x > y ? x : y;
    }

    static int maxProd(int arr[], int n) {
        int max_ending_here = 1, max_so_far = 1;
        for (int i = 0; i < n; i++) {
            max_ending_here = max_ending_here * arr[i];
            max_ending_here = Math.abs(max_ending_here);
            if (max_ending_here > max_so_far)
                max_so_far = max_ending_here;
            if (max_ending_here == 0)
                max_ending_here = 1;
        }
        return max_so_far;
    }

    static int maxProd2(int arr[]) {
        int n = arr.length;
        int max_ending_here = 1;
        int min_ending_here = 1;
        int max_so_far = 1;
        int flag = 0;
        for (int i = 0; i < n; i++) {
            /**
             * * If this element is positive, update max_ending_here. Update min_ending_here
             * only if min_ending_here is negative
             */

            if (arr[i] > 0) {
                max_ending_here = max_ending_here * arr[i];
                min_ending_here = min(min_ending_here * arr[i], 1);
                flag = 1;
            }
            /*
             * If this element is 0, then the maximum product cannot end here, make both
             * max_ending_here and min_ending _here 0 Assumption: Output is alway greater
             * than or equal to 1.
             */
            else if (arr[i] == 0) {
                max_ending_here = 1;
                max_so_far = 1;
            }
            /*
             * If element is negative. This is tricky max_ending_here can either be 1 or
             * positive. min_ending_here can either be 1 or negative. next min_ending_here
             * will always be prev. max_ending_here * arr[i] next max_ending_here will be 1
             * if prev min_ending_here is 1, otherwise next max_ending_here will be prev
             * min_ending_here * arr[i]
             */
            else {
                int temp = max_ending_here;
                max_ending_here = max(min_ending_here * arr[i], 1);
                min_ending_here = temp * arr[i];
            }
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;

        }
        if (flag == 0 && max_so_far == 0)
            return 0;
        return max_so_far;
    }

    public static void main(String[] args) {

        // int arr[] = { 1, -2, -3, 0, 7, -8, -2 };
        // int arr[] = {6, -3, -10, 0, 2};
        // int arr[] = {-1, -3, -10, 0, 60};
        int arr[] = { -2, -40, 0, -2, -3 };
        System.out.println("Maximum Sub array product is " + maxProd(arr, arr.length));
    }
}
