import java.util.*;

public class tree_prob7 {
  class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  
  public void leftview(Node root) {
    if (root == null) {
      return;
    }
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int n = q.size();

      for (int i = 1; i <= n; i++) {
        Node temp = q.poll();
        if (i == 1) {
          System.out.println(temp.data);
        }
        if (temp.left != null) {
          q.add(temp.left);
        }
        if (temp.right != null) {
          q.add(temp.right);
        }
      }
    }
  }

  public void rightView(Node root) {
    if (root == null) {
      return;
    }
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int n = q.size();
      for (int i = 1; i <= n; i++) {
        Node temp = q.peek();
        q.poll();
        if (i == n) {
          System.out.println(temp.data);
        }
        if (temp.left != null) {
          q.add(temp.left);
        }
        if (temp.right != null) {
          q.add(temp.right);
        }
      }
    }
  }

  public static void main(String[] args) {
    tree_prob7 bt = new tree_prob7();
    Node root = bt.new Node(1);
    root.left = bt.new Node(2);
    root.right = bt.new Node(3);
    root.left.left = bt.new Node(4);
    root.left.right = bt.new Node(5);
    root.right.left = bt.new Node(6);
    // root.right.left = bt.new Node(6);
    root.right.right = bt.new Node(7);

    // bt.leftview(root);
    bt.rightView(root);

  }
}
