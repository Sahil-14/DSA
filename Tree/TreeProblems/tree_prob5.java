import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class tree_prob5 {
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

  public void levelOrder(Node root) {
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      Node node = q.poll();
      System.out.println(node.data);
      if (node.left != null) {
        q.add(node.left);
      }
      if (node.right != null) {
        q.add(node.right);
      }
    }
  }

  public void reverseLevelOrder(Node root) {
    Queue<Node> q = new LinkedList<>();
    Stack<Node> s = new Stack<>();
    q.add(root);

    while (!q.isEmpty()) {
      Node node = q.poll();
      s.push(node);
      if (node.right != null) {
        q.add(node.right);
      }
      if (node.left != null) {
        q.add(node.left);
      }

    }

    while (!s.isEmpty()) {
      System.out.println(s.pop().data);
    }
  }

  public static void main(String[] args) {
    tree_prob5 bt = new tree_prob5();
    Node root = bt.new Node(1);
    root.left = bt.new Node(2);
    root.right = bt.new Node(3);
    root.left.left = bt.new Node(4);
    root.left.right = bt.new Node(5);
    root.right.left = bt.new Node(6);
    root.right.right = bt.new Node(7);
    bt.reverseLevelOrder(root);
    // System.out.println(bt.sumAtK(root, 2));
  }
}
