
//kth largest element in array
import java.util.*;

public class array_prob11 {
  public int kthSmallest(int arr[], int k) {
    Arrays.sort(arr);
    return arr[k - 1];
  }

  public int kthSmallestHeap(int arr[], int k, int size) {
    if (arr.length == 0) {
      return -1;
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < size; i++) {
      pq.add(arr[i]);
    }
    int l = k - 1;
    while (l > 0) {
      pq.poll();
      l--;
    }
    return pq.peek();
  }

  public static int kthLargest(int[] arr, int K) {
    // Collections.sort(arr, Collections.reverseOrder());
    Integer[] a = Arrays.stream(arr).boxed().toArray(Integer[]::new);
    Arrays.sort(a, Collections.reverseOrder());
    return a[K - 1];

  }

  public int kthLargestHeap(ArrayList<Integer> arr, int size, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < size; i++) {
      pq.add(arr.get(i));
    }

    int l = k - 1;
    while (l > 0) {
      pq.poll();
      l--;
    }

    return pq.peek();
  }

  public static void main(String[] args) {
    int[] arr = { 3, 2, 1, 5, 6, 4 };
    System.out.println(kthLargest(arr, 1));

  }
}
