// for a given array and integers k and x find the maximum sum subarray of size k and having sum less than x
// sliding window
// calculate sum  of first k elements
// initialize ans with th sum
//iterate over the rest of the arr keep adding one elemets in sum and removing one from start compare new sum with ans in each iteration

public class sw_prob1 {
  public static int maxSumSubarryX(int arr[], int n, int k, int x) {
    if (n < k) {
      return -1;
    }
    int maxSum = 0;
    int sum = 0;
    for (int i = 0; i < k; i++) {
      sum += arr[i];
    }
    if (sum < x && maxSum < sum) {
      maxSum = sum;
    }

    for (int i = k; i < n; i++) {
      sum = sum + arr[i] - arr[i - k];
      if (sum < x && maxSum < sum) {
        maxSum = sum;
      }
    }
    return maxSum;
  }

  public static void main(String[] args) {
    int arr[] = { 7, 5, 4, 6, 8, 9 };
    int k = 3;
    System.out.println(maxSumSubarryX(arr, arr.length, k, 20));
  }

}
