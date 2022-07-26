/**
 * Largest bst
 * 
 */

public class prob19 {
  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = this.right = null;
    }
  }

  static public class NodeInfo {
    int min;
    int max;
    boolean isBST;
    int size;

    NodeInfo() {
      min = Integer.MAX_VALUE;
      max = Integer.MIN_VALUE;
      isBST = true;
      size = 0;
    }
  }

  static public NodeInfo largest(Node root) {
    if (root == null) {
      return new NodeInfo();
    }

    NodeInfo left = largest(root.left);
    NodeInfo right = largest(root.right);
    NodeInfo current = new NodeInfo();
    if (left.isBST == false || right.isBST == false || (left.max > root.data) || (right.min < root.data)) {
      current.isBST = false;
      current.size = Math.max(right.size, left.size);
      return current;
    }

    current.isBST = true;
    current.size = left.size + right.size + 1;
    current.max = root.right != null ? right.max : root.data;
    current.min = root.left != null ? left.min : root.data;
    return current;
  }

  static public int largestBst(Node root) {
    NodeInfo m = largest(root);
    return m.size;
  }

  public static void main(String[] args) {

    Node node = new Node(15);
    node.left = new Node(20);
    node.right = new Node(30);
    node.left.left = new Node(5);
    int largest = largestBst(node);
    System.out.println(largest);

  }
}
