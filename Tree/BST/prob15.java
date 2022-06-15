
/**
 * Convert a normal BST to Balanced BST
 * 
 */
import java.util.*;

public class prob15 {
  static class Node {
    int data;
    Node left, right;

    public Node(int data) {
      this.data = data;
      left = right = null;
    }
  }

  Node root;

  /*
   * This function traverse the skewed binary tree and
   * stores its nodes pointers in vector nodes[]
   */
  void storeBSTNodes(Node root, Vector<Node> nodes) {
    // Base case
    if (root == null)
      return;

    // Store nodes in Inorder (which is sorted
    // order for BST)
    storeBSTNodes(root.left, nodes);
    nodes.add(root);
    storeBSTNodes(root.right, nodes);
  }

  /* Recursive function to construct binary tree */
  Node buildTreeUtil(Vector<Node> nodes, int start,
      int end) {
    if (start > end)
      return null;

    int mid = (start + end) / 2;
    Node node = nodes.get(mid);
    node.left = buildTreeUtil(nodes, start, mid - 1);
    node.right = buildTreeUtil(nodes, mid + 1, end);
    return node;

  }

  // This functions converts an unbalanced BST to
  // a balanced BST
  Node buildTree(Node root) {
    Vector<Node> nodes = new Vector<Node>();
    storeBSTNodes(root, nodes);
    int n = nodes.size();
    return buildTreeUtil(nodes, 0, n - 1);

  }

  /* Function to do preorder traversal of tree */
  void preOrder(Node node) {
    if (node == null)
      return;
    System.out.print(node.data + " ");
    preOrder(node.left);
    preOrder(node.right);
  }

  // Driver program to test the above functions
  public static void main(String[] args) {
    /*
     * Constructed skewed binary tree is
     * 10
     * /
     * 8
     * /
     * 7
     * /
     * 6
     * /
     * 5
     */
    prob15 tree = new prob15();
    tree.root = new Node(10);
    tree.root.left = new Node(8);
    tree.root.left.left = new Node(7);
    tree.root.left.left.left = new Node(6);
    tree.root.left.left.left.left = new Node(5);

    tree.root = tree.buildTree(tree.root);
    System.out.println("Preorder traversal of balanced BST is :");
    tree.preOrder(tree.root);
  }
}
