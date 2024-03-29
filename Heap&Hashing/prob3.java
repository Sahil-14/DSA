// K’th Smallest/Largest Element in Unsorted Array|Set 1

import java.util.PriorityQueue;

public class prob3 {
  // Time Complexity: O(N log N)
  // Auxiliary Space: O(1)
  // public static int kthSmallest(Integer[] arr, int K) {
  // // Sort the given array
  // Arrays.sort(arr);

  // // Return K'th element in
  // // the sorted array
  // return arr[K - 1];
  // }
  public static int kthSmallest(int arr[], int n, int k) {
    if (k > n) {
      return -1;
    }
    // maxHeap
    PriorityQueue<Integer> heap1 = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);

    for (int i = 0; i < n; i++) {
      heap1.add(arr[i]);
      if (heap1.size() > k) {
        heap1.remove();
      }
    }
    return heap1.peek();

  }
  
  /**
   * Time Complexity: O(K + (N-K) * Log K)
   * Auxiliary Space: O(K)
   * 
   */

  public int kthLargest(int arr[], int n, int k) {
    if (k > n) {
      return -1;
    }
    // minheap
    PriorityQueue<Integer> heap1 = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

    for (int i = 0; i < n; i++) {
      heap1.add(arr[i]);
      if (heap1.size() > k) {
        heap1.remove();
      }
    }

    return heap1.peek();

  }

  public static void main(String[] args) {
    // Given array
    int[] vec = { 2, 1, 3, 5, 4, 6 };

    // Size of array
    int N = vec.length;

    // Given K
    int K = 6;

    // Function Call
    System.out.println("Kth Smallest Element: " + kthSmallest(vec, N, K));
  }
}
