
/**
 * Sum of minimum and maximum elements of all subarrays of size k.
 * Input : arr[] = {2, 5, -1, 7, -3, -1, -2}
 * K = 4
 * Output : 18
 * Explanation : Subarrays of size 4 are :
 * {2, 5, -1, 7}, min + max = -1 + 7 = 6
 * {5, -1, 7, -3}, min + max = -3 + 7 = 4
 * {-1, 7, -3, -1}, min + max = -3 + 7 = 4
 * {7, -3, -1, -2}, min + max = -3 + 7 = 4
 * Sum of all min & max = 6 + 4 + 4 + 4
 * = 18
 * 
 * 
 */
import java.util.Deque;
import java.util.LinkedList;

public class prob7 {
  public static int SumOfKsubArray(int arr[], int k) {
    int sum = 0; // Initialize result

    // The queue will store indexes of useful elements
    // in every window
    // In deque 'G' we maintain decreasing order of
    // values from front to rear
    // In deque 'S' we maintain increasing order of
    // values from front to rear
    Deque<Integer> s = new LinkedList<>(), g = new LinkedList<>();
    // Process first window of size K
    int i = 0;
    for (i = 0; i < k; i++) {
      while (!s.isEmpty() && arr[s.peekLast()] >= arr[i])
        s.removeLast(); // Remove from rear

      while (!g.isEmpty() && arr[g.peekLast()] <= arr[i]) {
        g.removeLast();
      }
      g.addLast(i);
      s.addLast(i);
    }

    for (; i < arr.length; i++) {
      sum += arr[s.peekFirst()] + arr[g.peekFirst()];
      // Remove all elements which are out of this
      // window
      while (!s.isEmpty() && s.peekFirst() <= i - k)
        s.removeFirst();
      while (!g.isEmpty() && g.peekFirst() <= i - k)
        g.removeFirst();

      while (!s.isEmpty() && arr[s.peekLast()] >= arr[i]) {
        s.removeLast();
      }

      while (!g.isEmpty() && arr[g.peekLast()] <= arr[i]) {
        g.removeLast();
      }

      g.addLast(i);
      s.addLast(i);

    }
    sum += arr[s.peekFirst()] + arr[g.peekFirst()];
    return sum;

  }

  public static void main(String args[]) {
    int arr[] = { 2, 5, -1, 7, -3, -1, -2 };
    int k = 3;
    System.out.println(SumOfKsubArray(arr, k));
  }
}
