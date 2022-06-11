/**
 * Find maximum of minimum for every window size in a given array
 * 
 * Input: arr[] = {10, 20, 30, 50, 10, 70, 30}
 * Output: 70, 30, 20, 10, 10, 10, 10
 * The first element in the output indicates the maximum of minimums of all
 * windows of size 1.
 * Minimums of windows of size 1 are {10}, {20}, {30}, {50}, {10},
 * {70} and {30}. Maximum of these minimums is 70
 * The second element in the output indicates the maximum of minimums of all
 * windows of size 2.
 * Minimums of windows of size 2 are {10}, {20}, {30}, {10}, {10},
 * and {30}. Maximum of these minimums is 30
 * The third element in the output indicates the maximum of minimums of all
 * windows of size 3.
 * Minimums of windows of size 3 are {10}, {20}, {10}, {10} and {10}.
 * Maximum of these minimums is 20
 * Similarly, other elements of output are computed.
 */
public class SQ16 {
  static int arr[] = { 10, 20, 30, 50, 10, 70, 30 };

  // method 1
  static void printMaxOfMin(int n) {
    for (int k = 1; k <= n; k++) {
      int maxOfMin = Integer.MIN_VALUE;
      for (int i = 0; i <= n - k; i++) {
        int min = arr[i];
        for (int j = 1; j < k; j++) {
          if (arr[i + j] < min) {
            min = arr[i + j];
          }
        }
        // Update maxOfMin if required
        if (min > maxOfMin)
          maxOfMin = min;
      }
      System.out.print(maxOfMin + " ");
    }
  }

  // method
  // https://www.geeksforgeeks.org/find-the-maximum-of-minimums-for-every-window-size-in-a-given-array/
  static void printMaxOfMin2(int n) {
    Stack<Integer> s = new Stack<>();
    // Arrays to store previous and next smaller
    int left[] = new int[n + 1];
    int right[] = new int[n + 1];

    for (int i = 0; i < n; i++) {
      left[i] = -1;
      right[i] = n;
    }
    // Fill elements of left[] using logic discussed on
    // https://www.geeksforgeeks.org/next-greater-element/
    for (int i = 0; i < n; i++) {
      while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
        s.pop();
      }

      if (!s.empty())
        left[i] = s.peek();

      s.push(i);
    }

    // Empty the stack as stack is
    // going to be used for right[]
    // Fill elements of right[] using same logic
    for (int i = n - 1; i >= 0; i--) {

      while (!s.empty() && arr[s.peek()] >= arr[i])
        s.pop();

      if (!s.empty())
        right[i] = s.peek();

      s.push(i);
    }

    // Create and initialize answer array
    int ans[] = new int[n + 1];

    for (int i = 0; i <= n; i++)
      ans[i] = 0;

    // Fill answer array by comparing minimums of all
    // lengths computed using left[] and right[]
    for (int i = 0; i < n; i++) {
      // length of the interval
      int len = right[i] - left[i] - 1;
      // arr[i] is a possible answer for this length
      // 'len' interval, check if arr[i] is more than
      // max for 'len'
      ans[len] = Math.max(ans[len], arr[i]);
    }

    // Some entries in ans[] may not be filled yet. Fill
    // them by taking values from right side of ans[]
    for (int i = n - 1; i >= 1; i--)
      ans[i] = Math.max(ans[i], ans[i + 1]);

    // Print the result
    for (int i = 1; i <= n; i++)
      System.out.print(ans[i] + " ");

  }

  // Driver method
  public static void main(String[] args) {
    printMaxOfMin(arr.length);
  }
}
