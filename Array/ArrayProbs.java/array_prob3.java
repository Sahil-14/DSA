//kadans algo
//Largest Sum Contiguous Subarray

public class array_prob3 {
  static int maxSubArraySum(int arr[], int n) {
    int max_so_far = Integer.MIN_VALUE;
    int max_ending_here = 0;
    for (int i = 0; i < n; i++) {
      max_ending_here += arr[i];
      if (max_ending_here > max_so_far) {
        max_so_far = max_ending_here;
      }
      if (max_ending_here < 0) {
        max_ending_here = 0;
      }
    }
    return max_so_far;
  }

  public static void main(String[] args) {
    int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
    System.out.println("Maximum contiguous sum is " +
        maxSubArraySum(a, a.length));
  }
}
