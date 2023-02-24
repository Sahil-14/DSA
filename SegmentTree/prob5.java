import java.util.*;

public class prob5 {
  private static class Node implements Comparable<Node> {
    private int x;
    private int height;

    public Node(int x, int height) {
      this.x = x;
      this.height = height;
    }

    public int compareTo(Node n) {
      if (this.x != n.x) {
        return this.x - n.x;
      } else {
        return n.height - this.height;
      }
    }
  }

  public static List<int[]> getSkyline(int[][] buildings) {
    List<int[]> result = new LinkedList<int[]>();
    if (buildings == null || buildings.length == 0) {
      return result;
    }
    List<Node> bds = new LinkedList<Node>();
    for (int i = 0; i < buildings.length; i++) {
      bds.add(new Node(buildings[i][0], buildings[i][2]));
      bds.add(new Node(buildings[i][1], -buildings[i][2]));
    }
    Collections.sort(bds);
    for (Node temp : bds) {
      System.out.println("[" + temp.x + "," + temp.height + "]");
    }
    PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
    q.add(0);
    int preHeight = 0;
    for (Node w : bds) {
      if (w.height > 0) {
        q.add(w.height);
      } else {
        q.remove((Integer) (-w.height));
      }
      int maxHeight = q.peek();
      if (preHeight != maxHeight) {
        result.add(new int[] { w.x, maxHeight });
      }
      preHeight = maxHeight;
    }
    return result;
  }

  public static void main(String arg[]) {
    int arr[][] = { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };
    getSkyline(arr);
  }
}
