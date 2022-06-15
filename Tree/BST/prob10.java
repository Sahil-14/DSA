/**
 * 
 * Flatten BST to sorted list | Increasing order
 * Given a binary search tree, the task is to flatten it to a sorted list.
 * Precisely, the value of each node must be lesser than the values of all the
 * nodes at its right, and its left node must be NULL after flattening. We must
 * do it in O(H) extra space where ‘H’ is the height of BST.
 * 
 * 
 * Input:
 * 5
 * / \
 * 3 7
 * / \ / \
 * 2 4 6 8
 * Output: 2 3 4 5 6 7 8
 * 
 * 
 * 
 */

public class prob10 {
  static class node {
    int data;
    node left;
    node right;

    node(int data) {
      this.data = data;
      left = null;
      right = null;
    }
  };

  static void print(node parent) {
    node curr = parent;
    while (curr != null) {
      System.out.print(curr.data + " ");
      curr = curr.right;
    }
  }

  static node prev;

  static void Inorder(node curr) {
    if (curr == null) {
      return;
    }
    Inorder(curr.left);
    prev.left = null;
    prev.right = curr;
    prev = curr;
    Inorder(curr.right);
  }

  static node flatten(node parent) {
    node dummy = new node(-1);
    prev = dummy;
    Inorder(parent);
    prev.left = null;
    prev.right = null;
    node ret = dummy.right;
    return ret;
  }

  // Driver code
  public static void main(String[] args) {
    node root = new node(5);
    root.left = new node(3);
    root.right = new node(7);
    root.left.left = new node(2);
    root.left.right = new node(4);
    root.right.left = new node(6);
    root.right.right = new node(8);

    // Calling required function
    print(flatten(root));
  }

}
