import java.util.*;
import java.awt.Point;

// for a given arary and  an interger k,check if any subarray of size k exist in the 
// aray such that elements in the subaray form anumber divisible by 3

public class sw_prob3 {
  public int maxSubarrayDivisibleBy3(Vector<Integer> arr, int k, int n) {
    Point ans = new Point(0, 0);
    int sum = 0;
    int found = false;
    for (int i = 0; i < k; i++) {
      sum += arr.get(i);
    }
    if (sum % 3 == 0) {
      found = true;
      ans = new Point(0, k - 1);
    }

    for (int i = k; i < n; i++) {
      if (found) {
        break;
      }

      sum += arr.get(i) - arr.get(i - k);
      if (sum % 3 == 0) {
        ans = new Point(i - k + 1, i);
        found = true;
      }

      if (found) {
        ans = new Point(0, -1);
        System.out.println("Subarray exist");
      } else {
        System.out.println("Subarray does not  exist");
      }

      System.out.println(ans);
    }
  }

  public static void main(String[] args) {

    // Given array and K
    Vector<Integer> arr = new Vector<Integer>();
    arr.add(84);
    arr.add(23);
    arr.add(45);
    arr.add(12);
    arr.add(56);
    arr.add(82);

    int K = 3;

    // Function call
    maxSubarrayDivisibleBy3(arr, K);
  }
}
