
// Chocolate Distribution Problem
/**
 * 
 * Given an array of n integers where each value represents the number of
 * chocolates in a packet. Each packet can have a variable number of chocolates.
 * There are m students, the task is to distribute chocolate packets such that
 * 1.Each student gets one packet
 * 2.The difference between the number of chocolates in the packet with maximum
 * chocolates and packet with minimum chocolates given to the students is
 * minimum
 */
import java.util.*;

public class array_prob5 {
  static int findMinDiff(int arr[], int n, int m) {
    if (n == 0 || m == 0) {
      return 0;
    }
    if (n < m) {
      return -1;
    }
    Arrays.sort(arr);
    int min_diff = Integer.MAX_VALUE;

    for (int i = 0; i + m - 1 < n; i++) {
      if (arr[i + m - 1] - arr[i] < min_diff) {
        min_diff = arr[i + m - 1] - arr[i];
      }
    }
    return min_diff;
  }

  public static void main(String[] args) {
    int arr[] = { 12, 4, 7, 9, 2, 23,
        25, 41, 30, 40, 28,
        42, 30, 44, 48, 43,
        50 };

    int m = 7; // Number of students

    int n = arr.length;
    System.out.println("Minimum difference is "
        + findMinDiff(arr, n, m));

  }
}
