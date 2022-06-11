import java.util.PriorityQueue;

/**
 * Connect n ropes with minimum cost
 * 
 * 
 * 
 */

public class prob17 {
  public static int connectRopes(int len[], int n) {
    if (n == 0) {
      return -1;
    }

    if (n == 1) {
      return len[0];
    }
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int cost = 0;
    for (int i : len) {
      minHeap.add(i);
    }

    while (minHeap.size() != 1) {
      int firstSmall = minHeap.poll();
      int secondSmall = minHeap.poll();

      cost += (firstSmall + secondSmall);
      minHeap.add(firstSmall + secondSmall);
    }

    return cost;

  }

  public static void main(String args[]) {
    int len[] = { 4, 3, 2, 6 };
    int size = len.length;

    System.out.println("Total cost for connecting ropes is " + connectRopes(len, size));
  }
}
