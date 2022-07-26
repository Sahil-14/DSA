
/**
 * 
 * We have to paint n boards of length {A1, A2…An}. There are k painters
 * available and each takes 1 unit time to paint 1 unit of board. The problem is
 * to find the minimum time to get
 * this job done under the constraints that any painter will only paint
 * continuous sections of boards, say board {2, 3, 4} or only board {1} or
 * nothing but not board {2, 4, 5}
 * 
 */



public class bs_prob3 {
  static int getMax(int arr[], int n) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++)
      if (arr[i] > max)
        max = arr[i];
    return max;
  }

  // return the sum of the elements in the array
  static int getSum(int arr[], int n) {
    int total = 0;
    for (int i = 0; i < n; i++)
      total += arr[i];
    return total;
  }

  static int numberOfPainters(int arr[], int n, int maxLen) {
    int totol = 0, numPainter = 1;
    for (int i = 0; i < n; i++) {
      totol += arr[i];
      if (totol > maxLen) {
        numPainter++;
        totol = arr[i];
      }
    }
    return numPainter;
  }

  static int partition(int arr[], int n, int k) {
    int lo = getMax(arr, n);
    int hi = getSum(arr, n);

    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      int requiredPainters = numberOfPainters(arr, n, mid);
      if (requiredPainters <= k) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    return lo;
  }

  public static void main(String args[]) {
    int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    // Calculate size of array.
    int n = arr.length;
    int k = 3;
    System.out.println(partition(arr, n, k));
  }
}
