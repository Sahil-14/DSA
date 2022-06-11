
/**
 * 
 * Count triplets with sum smaller than a given value
 */
import java.util.*;

public class prob8 {
  static int arr[] = new int[] { 5, 1, 3, 4, 7 };

  static int countTriplets1(int n, int sum) {
    int ans = 0;
    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++) {
          if (arr[i] + arr[j] + arr[k] < sum)
            ans++;
        }
      }
    }
    return ans;
  }

  static int countTriplets2(int n, int sum) {
    Arrays.sort(arr);
    // Initialize result
    int ans = 0;
    for (int i = 0; i < n - 2; i++) {
      int j = i + 1;
      int k = n - 1;
      while (j < k) {
        if (arr[i] + arr[j] + arr[k] >= sum)
          k--;
        else {
          ans += (k - j);
          j++;
        }
      }
    }
    return ans;

  }

  public static void main(String[] args) {

    int sum = 12;
    System.out.println(countTriplets2(arr.length, sum));
  }
}
