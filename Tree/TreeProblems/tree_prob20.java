//check if 2 bst are identical
public class tree_prob20 {
  class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    boolean isBSTIdentical(Node root1, Node root2) {
      if (root1 == null && root2 == null) {
        return true;
      }

      else if (root1 != null || root2 != null) {
        return false;
      } else {
        boolean condition = root1.data == root2.data;
        boolean left = isBSTIdentical(root1.left, root2.left);
        boolean right = isBSTIdentical(root1.right, root2.right);
        return condition && left && right;
      }
    }
}
