import java.util.PriorityQueue;

/**
 * Given an array of digits (values are from 0 to 9), find the minimum possible
 * sum of two numbers formed from digits of the array. All digits of given array
 * must be used to form the two numbers.
 * 
 * 
 * 
 * Input: [6, 8, 4, 5, 2, 3]
 * Output: 604
 * The minimum sum is formed by numbers
 * 358 and 246
 * 
 * Input: [5, 3, 0, 7, 4]
 * Output: 82
 * The minimum sum is formed by numbers
 * 35 and 047
 * 
 */

public class prob3_grdy {
  public static long solve(int[] a) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    // to store the 2 numbers formed by array elements to
    // minimize the required sum
    StringBuilder num1 = new StringBuilder();
    StringBuilder num2 = new StringBuilder();
    for (int x : a) {
      pq.add(x);
    }

    while (!pq.isEmpty()) {
      num1.append(pq.poll() + "");
      if (!pq.isEmpty()) {
        num2.append(pq.poll() + "");
      }
    }

    long sum = Long.parseLong(num1.toString()) + Long.parseLong(num2.toString());
    return sum;
  }

  // method 2
  static int minSum(int a[], int n) {
    Arrays.sort(a);

    int n1 = 0;
    int n2 = 0;

    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) {
        n1 = n1 * 10 + a[i];
      } else {
        n2 = n2 * 10 + a[i];
      }
    }

    return n2 + n1;

  }

  public static void main(String[] args) {
    int arr[] = { 6, 8, 4, 5, 2, 3 };
    System.out.println("The required sum is " + solve(arr));
  }
}
