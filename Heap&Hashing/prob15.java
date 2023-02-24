/**
 * Given an array arr[] of size ‘n’ and a positive integer k. Consider series of
 * natural numbers and remove arr[0], arr[1], arr[2], …, arr[n-1] from it. Now
 * the task is to find k-th smallest number in the remaining set of natural
 * numbers.
 * 
 * 
 */

public class prob15 {

  // smallest element.
  static int ksmallest(int arr[],
      int n, int k) {
    for (int i = 0; i < n; i++) {
      if (arr[i] <= k)
        k++;
      else
        break;
    }
    return k;
  }

  // Driver Code
  public static void main(String args[]) {
    int k = 4;
    int arr[] = { 1, 2,5,6,7,8 };
    int n = arr.length;
    System.out.println(ksmallest(arr, n, k));
  }

}
