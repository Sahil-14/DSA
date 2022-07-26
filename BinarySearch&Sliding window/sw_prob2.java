// size of smallest subarray with sum < x
//use variable sum,add, start
// Iterate over array and start adding elemets to sum
// if sum > x remove from the start

public class sw_prob2 {
  public static int smallestSubarrayMaxSum(int arr[], int n, int k, int x) {
    int start = 0, end = 0;
    int sum = 0, maxlen = n + 1;

    while (end < n) {
      while (sum <= x && end < n) {
        sum += arr[end++];
      }
      while (sum > x && start < n) {
        if (end - start > maxlen) {
          maxlen = end - start ;
        }
        sum -= arr[start++];
      }
    }
  }
}
