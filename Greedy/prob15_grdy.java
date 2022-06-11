/**
 * Lexicographically smallest array after at-most K consecutive swaps
 * Given an array arr[], find the lexicographically smallest array that can be
 * obtained after performing at maximum of k consecutive swaps.
 * 
 * 
 * 
 * Input: arr[] = {7, 6, 9, 2, 1}
 * k = 3
 * Output: arr[] = {2, 7, 6, 9, 1}
 * Explanation: Array is: 7, 6, 9, 2, 1
 * Swap 1: 7, 6, 2, 9, 1
 * Swap 2: 7, 2, 6, 9, 1
 * Swap 3: 2, 7, 6, 9, 1
 * So Our final array after k = 3 swaps :
 * 2, 7, 6, 9, 1
 * 
 * Input: arr[] = {7, 6, 9, 2, 1}
 * k = 1
 * Output: arr[] = {6, 7, 9, 2, 1}
 * 
 * 
 * 
 * We strongly recommend that you click here and practice it, before moving on
 * to the solution.
 * Naive approach is to generate all the permutation of array and pick the
 * smallest one which satisfy the condition of at-most k swaps. Time complexity
 * of this approach is Ω(n!), which will definitely time out for large value of
 * n.
 * An Efficient approach is to think greedily. We first pick the smallest
 * element from array a1, a2, a3…(ak or an) [We consider ak when k is smaller,
 * else n]. We place the smallest element to the a0 position after shifting all
 * these elements by 1 position right. We subtract number of swaps (number of
 * swaps is number of shifts minus 1) from k. If still we are left with k > 0
 * then we apply the same procedure from the very next starting position i.e.,
 * a2, a3,…(ak or an) and then place it to the a1 position. So we keep applying
 * the same process until k becomes 0.
 * 
 */

public class prob15_grdy {
  static void minimizeWithKSwaps(int arr[], int n, int k) {

    for (int i = 0; i < n - 1 && k > 0; ++i) {
      // Set the position where we want
      // to put the smallest integer
      int pos = i;
      for (int j = i + 1; j < n; ++j) {
        // If we exceed the Max swaps
        // then terminate the loop
        if (j - i > k)
          break;
        // Find the minimum value from i+1 to
        // max k or n
        if (arr[j] < arr[pos])
          pos = j;
      }

      // Swap the elements from Minimum position
      // we found till now to the i index
      int temp;
      for (int j = pos; j > i; --j) {
        temp = arr[j];
        arr[j] = arr[j - 1];
        arr[j - 1] = temp;
      }
      // Set the final value after swapping pos-i
      // elements
      k -= pos - i;
    }

  }

  // Driver method
  public static void main(String[] args) {

    int arr[] = { 7, 6, 9, 2, 1 };
    int n = arr.length;
    int k = 3;

    minimizeWithKSwaps(arr, n, k);

    // Print the final Array
    for (int i = 0; i < n; ++i)
      System.out.print(arr[i] + " ");
  }

}
