
/**
 * Subsequence :- It is a sequence that can be derived an array by selecting
 * zero or more elements , without changing the order of the remaining elements;
 * Number of subsequence = 2^n
 * Subarray :=  Continuous part of the array.
 * Number of subarrays of an array with n elements = nC2 +n
 * 
 * Every subarray is a subsequence but evry subsequence is not a subarray
 * 
 */

import java.util.*;

public class prob8 {
    static void maxTillI(int a[]) {
        int mx = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            mx = Math.max(mx, a[i]);
            System.out.println(mx);
        }
    }

    // Subarray sum
    static void subarraySum(int a[]) {
        int n = a.length;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr = 0;
            for (int j = i; j < n; j++) {
                curr += a[j];
                System.out.println(curr);
            }
        }
    }

    // Longest arithmatic subarray length
    // difference between 2 number is same
    static int longestArithmaticSubarry(int a[]) {
        int ans = 2;
        int pd = a[1] - a[0];
        int j = 2;// while loop iterator
        int curr = 2;
        while (j < a.length) {
            if (pd == a[j] - a[j - 1]) {
                curr++;
            } else {
                pd = a[j] - a[j - 1];
                curr = 2;
            }
            ans = Math.max(ans, curr);
            j++;
        }
        return ans;
    }
    // A day is record-breaking if it satisfies both of the following conditions:

    // The number of visitors on the day is strictly larger than the number of
    // visitors on each of the previous days.
    // Either it is the last day, or the number of visitors on the day is strictly
    // larger than the number of visitors on the following day.

    // Record breaking day
    static int recordDays(int n) {
        int a[] = new int[n + 1];
        a[n] = Integer.MIN_VALUE;
        Scanner sc = new Scanner(System.in); // System.in is a standard input stream
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        if (n == 1) {
            return 1;
        }
        int ans = 0;
        int mx = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (a[i] > mx && a[i] > a[i + 1]) {
                ans++;
            }
            mx = Math.max(mx, a[i]);
        }
        return ans;
    }

    public static void main(String arg[]) {

        int a[] = { 10, 7, 4, 6, 8, 10, 11 };
        // maxTillI(a);
        // subarraySum(a);
        // System.out.println(longestArithmaticSubarry(a));
        System.out.println("No id record days are :" + recordDays(8));
    }
}
