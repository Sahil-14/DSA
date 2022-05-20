
/**
 * Sliding Window Maximum (Maximum of all subarrays of size k)
 * Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
 * Output: 3 3 4 5 5 5 6
 * Explanation:
 * Maximum of 1, 2, 3 is 3
 * Maximum of 2, 3, 1 is 3
 * Maximum of 3, 1, 4 is 4
 * Maximum of 1, 4, 5 is 5
 * Maximum of 4, 5, 2 is 5
 * Maximum of 5, 2, 3 is 5
 * Maximum of 2, 3, 6 is 6
 * 
 * Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4
 * Output: 10 10 10 15 15 90 90
 * 
 * 
 */
import java.util.*;

public class prob6 {
  // A Dequeue (Double ended queue)
  // based method for printing
  // maximum element of
  // all subarrays of size k
  static void printMax(int arr[], int n, int k) {
    // Create a Double Ended Queue, Qi
    // that will store indexes of array elements
    // The queue will store indexes of
    // useful elements in every window and it will
    // maintain decreasing order of values
    // from front to rear in Qi, i.e.,
    // arr[Qi.front[]] to arr[Qi.rear()]
    // are sorted in decreasing order
    Deque<Integer> q = new LinkedList<Integer>();
    int i;
    for (i = 0; i < k; i++) {
      while (!q.isEmpty() && arr[i] >= arr[q.peekLast()]) {
        q.removeLast();
      }
      q.addLast(i);
    }

    for (; i < n; ++i) {
      // The element at the front of the
      // queue is the largest element of
      // previous window, so print it
      System.out.print(arr[q.peek()] + " ");

      // Remove the elements which
      // are out of this window
      while ((!q.isEmpty()) && (q.peek() <= i - k)) {
        q.removeFirst();
      }

      // Remove all elements smaller
      // than the currently
      // being added element (remove
      // useless elements)
      while ((!q.isEmpty()) && (arr[i] > arr[q.peekLast()])) {
        q.removeLast();
      }
      q.addLast(i);
    }

    System.out.print(arr[q.peek()]);

  }

  public static void main(String[] args) {
    int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
    int k = 3;
    printMax(arr, arr.length, k);
  }
}
