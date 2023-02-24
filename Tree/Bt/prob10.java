
//check if tree is balanced or not
class Height {
  int height = 0;
}


/**
 * for height based function
 * 
 * Time Complexity: O(n^2) in case of full binary tree.
Auxiliary Space: O(n) space for call stack since using recursion
 * 
 */

public class prob10 {
  public boolean isBalanced(Node root, Height height) {
    if (root == null) {
      height.height = 0;
      return true;
    }

    Height lHeight = new Height(), rHeight = new Height();
    boolean l = isBalanced2(root.left, lHeight);
    boolean r = isBalanced2(root.right, rHeight);

    int lh = lHeight.height;
    int rh = lHeight.height;

    height.height = Math.max(lh, rh) + 1;

    if (Math.abs(lh - rh) >= 2) {
      return false;
    } else {
      return l && r;
    }
  }

  public static void main(String[] args) {
    Height height = new Height();
    prob10 bt = new prob10();
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.right.right.right = new Node(8);
    root.right.right.right.right = new Node(9);
    root.right.right.right.right = new Node(10);

    System.out.println(bt.isBalanced(root, height));

  }
}

/**
 * Time Complexity: O(n)
 * 
 * 
 */
