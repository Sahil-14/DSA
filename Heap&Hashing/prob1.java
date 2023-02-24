
/**
 * Choose k array elements such that difference of maximum and minimum is
 * minimized
 * 
 * 
 * Input : arr[] = {10, 100, 300, 200, 1000, 20, 30}
 * k = 3
 * Output : 20
 * 20 is the minimum possible difference between any
 * maximum and minimum of any k numbers.
 * Given k = 3, we get the result 20 by selecting
 * integers {10, 20, 30}.
 * max(10, 20, 30) - min(10, 20, 30) = 30 - 10 = 20.
 * 
 * Input : arr[] = {1, 2, 3, 4, 10, 20, 30, 40,
 * 100, 200}.
 * k = 4
 * Output : 3
 * 
 */
import java.util.*;

public class prob1 {
  static int minDiff(int arr[], int n, int k) {
    if (n <= 1) {
      return 0;
    }
    if (k > n) {
      return -1;
    }

    int result = Integer.MAX_VALUE;
    Arrays.sort(arr);

    for (int i = 0; i <= n - k; i++) {
      result = Math.min(result, arr[i + k - 1] - arr[i]);
    }
    return result;
  }

  // Driver code
  public static void main(String[] args) {
    int arr[] = { 10, 100, 300, 200, 1000, 20, 30 };
    int n = arr.length;
    int k = 3;

    System.out.println(minDiff(arr, n, k));
  }
}
