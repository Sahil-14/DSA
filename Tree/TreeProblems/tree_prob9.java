//check if the tree is height balanced or not
//a tree is height balance if the at each node difference bet height of leftsubtree
//and right subtree is less than or equal to 1

class Height {
  int height = 0;
}

public class tree_prob9 {
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

  public int height(Node root) {
    if (root == null) {
      return 0;
    }
    return Math.max(height(root.left), height(root.right)) + 1;
  }

  public boolean isBalanced(Node root) {
    if (root == null) {
      return true;
    }

    if (!isBalanced(root.left)) {
      return false;
    }

    if (!isBalanced(root.right)) {
      return false;
    }

    int lHeight = height(root.left);
    int rHeight = height(root.right);
    int l = Math.abs(lHeight - rHeight);
    return l <= 1;

  }

  // space efficitn
  public boolean isBalanced2(Node root, Height height) {
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

    tree_prob9 bt = new tree_prob9();
    Node root = bt.new Node(1);
    root.left = bt.new Node(2);
    root.right = bt.new Node(3);
    root.left.left = bt.new Node(4);
    root.left.right = bt.new Node(5);
    root.right.left = bt.new Node(6);
    root.right.right = bt.new Node(7);
    root.right.right.right = bt.new Node(8);
    root.right.right.right.right = bt.new Node(9);
    root.right.right.right.right = bt.new Node(10);

    System.out.println(bt.isBalanced2(root, height));

  }

}
