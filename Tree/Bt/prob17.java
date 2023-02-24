
/**
 * bottom view
 * 
 * 
 */
import java.util.*;

public class prob17 {
  static class Node {
    int data; // data of the node
    int hd; // horizontal distance of the node
    Node left, right; // left and right references

    // Constructor of tree node
    public Node(int key) {
      data = key;
      hd = Integer.MAX_VALUE;
      left = right = null;
    }
  }

  Node root; // root node of tree

  public prob17() {
  }

  // Parameterized tree constructor
  public prob17(Node node) {
    root = node;
  }

  public void bottomView() {
    if (root == null)
      return;

    // Initialize a variable 'hd' with 0 for the root element.
    int hd = 0;
    Map<Integer, Integer> map = new TreeMap<>();
    Queue<Node> queue = new LinkedList<Node>();
    root.hd = hd;
    queue.add(root);

    while (!queue.isEmpty()) {
      Node temp = queue.remove();
      hd = temp.hd;
      map.put(hd, temp.data);
      if (temp.left != null) {
        temp.left.hd = hd - 1;
        queue.add(temp.left);
      }
      // queue with a horizontal distance hd+1.
      if (temp.right != null) {
        temp.right.hd = hd + 1;
        queue.add(temp.right);
      }
    }

    for (Map.Entry<Integer, Integer> hm : map.entrySet()) {
      System.out.println(hm.getValue());
    }
  }

  public void bottomView2() {
    if (root == null) {
      return;
    }
    root.hd = 0;
    int min = 0;
    int max = 0;

    Queue<Node> q = new LinkedList<>();
    Map<Integer, Integer> mp = new HashMap<>();

    q.add(root);

    while (!q.isEmpty()) {
      Node temp = q.poll();
      mp.put(temp.hd, temp.data);
      if (temp.left != null) {
        temp.left.hd = temp.hd - 1;
        q.add(temp.left);
        min = Math.min(min, temp.hd - 1);
      }

      if (temp.right != null) {
        temp.right.hd = temp.hd + 1;
        q.add(temp.right);
        max = Math.max(max, temp.hd + 1);
      }
    }

    for (; min <= max; min++) {
      System.out.print(mp.get(min) + " ");
    }

    System.out.println();

  }

  public static void main(String[] args) {
    Node root = new Node(20);
    root.left = new Node(8);
    root.right = new Node(22);
    root.left.left = new Node(5);
    root.left.right = new Node(3);
    root.right.left = new Node(4);
    root.right.right = new Node(25);
    root.left.right.left = new Node(10);
    root.left.right.right = new Node(14);
    prob17 tree = new prob17(root);
    System.out.println("Bottom view of the given binary tree:");
    tree.bottomView2();
  }

}
