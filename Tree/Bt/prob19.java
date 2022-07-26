//boundary traversal

public class prob19 {
  static class Node {
    int data;
    Node left, right;

    Node(int item) {
      data = item;
      left = right = null;
    }
  }

  Node root;

  void printLeaves(Node node) {
    if (node == null) {
      return;
    }
    printLeaves(node.left);
    if (node.left == null && node.right == null) {
      System.out.print(node.data + " ");
    }
    printLeaves(node.right);
  }

  void printBoundaryLeft(Node node) {
    if (node == null) {
      return;
    }

    if (node.left != null) {
      System.out.print(node.data + " ");
      printBoundaryLeft(node.left);
    } else if (node.right != null) {
      System.out.print(node.data + " ");
      printBoundaryLeft(node.right);
    }
  }

  void printBoundaryRight(Node node) {
    if (node == null)
      return;
    if (node.right != null) {
      // to ensure bottom up order, first call for right
      // subtree, then print this node
      printBoundaryRight(node.right);
      System.out.print(node.data);
    } else if (node.left != null) {
      printBoundaryRight(node.left);
      System.out.print(node.data + " ");
    }
    // do nothing if it is a leaf node, this way we avoid
    // duplicates in output
  }

  void printBoundary(Node node) {
    if (node == null)
      return;

    System.out.print(node.data + " ");

    printBoundaryLeft(node.left);
    // Print all leaf nodes
    printLeaves(node.left);
    printLeaves(node.right);

    // Print the right boundary in bottom-up manner
    printBoundaryRight(node.right);
  }

  // Driver program to test above functions
  public static void main(String args[]) {
    prob19 tree = new prob19();
    tree.root = new Node(20);
    tree.root.left = new Node(8);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(12);
    tree.root.left.right.left = new Node(10);
    tree.root.left.right.right = new Node(14);
    tree.root.right = new Node(22);
    tree.root.right.right = new Node(25);
    tree.printBoundary(tree.root);
  }
}
