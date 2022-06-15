
//check if tree is balanced or not
class Height {
  int height = 0;
}

public class prob10 {
  public boolean isBalanced(Node root, Height height) {
    if (root == null) {
      height.height = 0;
      return true;
    }
    Height leftHeight = new Height(), rightHeight = new Height();
    boolean l = isBalanced(root.left, leftHeight);
    boolean r = isBalanced(root.right, rightHeight);
    int lHeight = leftHeight.height;
    int rHeight = rightHeight.height;
    height.height = Math.abs(lHeight - rHeight);
    if (Math.abs(lHeight - rHeight) >= 2) {
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
