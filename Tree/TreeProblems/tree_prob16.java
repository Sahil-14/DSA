//check if tree is bst or not
public class tree_prob16 {
  class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = this.right = null;
    }
  }

  public void isBST(Node root) {
    isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public boolean isBSTUtil(Node root, int min, int max) {
    if (root == null) {
      return true;
    }

    if (root.data <= min || root.data > max) {
      return false;
    }

    return isBSTUtil(root.left, min, root.data) && isBSTUtil(root.right, root.data, max);

  }
}
