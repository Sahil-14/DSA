
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
