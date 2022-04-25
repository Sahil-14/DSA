import java.util.*;

//find the sum of  all node at kth level  in binary tree level start from 0

public class tree_prob6 {
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

  public int sumAtKthLevelNode(Node root, int k) {
    if (root == null) {
      return -1;
    }
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    q.add(null);
    int level = 0;
    int sum = 0;
    while (!q.isEmpty()) {
      Node node = q.poll();
      if (node != null) {
        if (level == k) {
          sum += node.data;
        }
        if (node.left != null) {
          q.add(node.left);
        }
        if (node.right != null) {
          q.add(node.right);
        }
      } else if (!q.isEmpty()) {
        q.add(null);
        level++;
      }
    }

    return sum;
  }

  public static void main(String[] args) {
    tree_prob6 bt = new tree_prob6();
    Node root = bt.new Node(1);
    root.left = bt.new Node(2);
    root.right = bt.new Node(3);
    root.left.left = bt.new Node(4);
    root.left.right = bt.new Node(5);
    root.right.left = bt.new Node(6);
    root.right.right = bt.new Node(7);
    System.out.println(bt.sumAtKthLevelNode(root, 1));
    // System.out.println(bt.sumAtK(root, 2));
  }
}
 