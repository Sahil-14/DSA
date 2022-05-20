import java.util.PriorityQueue;

// K’th largest element in a stream

public class prob8 {
  static int[] kthLargest(int k, int arr[], int n) {
    int[] ans = new int[n];
    PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
    for (int i = 0; i < n; i++) {
      if (q.size() < k) {
        q.add(arr[i]);
      } else {
        if (arr[i] > q.peek()) {
          q.remove();
          q.add(arr[i]);
        }
      }

      if (q.size() < k) {
        ans[i] = -1;
      } else
        ans[i] = q.peek();
    }

    return ans;

  }

  // Driver Code
  public static void main(String[] args) {
    int n = 6;
    int arr[] = { 1, 2, 3, 4, 5, 6 };
    int k = 4;

    // Function call
    int[] v = kthLargest(k, arr, n);
    for (int it : v)
      System.out.print(it + " ");
  }
}
