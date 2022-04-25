
//find size and depth/height of tree
public class tree_prob4 {
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
    int left = height(root.left);
    int right = height(root.right);
    return 1 + Math.max(left, right);
  }

  public int size(Node root) {
    if (root == null) {
      return 0;
    }
    int left = size(root.left);
    int right = size(root.right);
    return 1 + left + right;
  }

  public int sum(Node root) {
    if (root == null) {
      return 0;
    }
    int left = sum(root.left);
    int right = sum(root.right);
    return root.data + left + right;
  }

  public int diameter(Node root) {
    if (root == null) {
      return 0;
    }

    int leftHeight = height(root.left);
    int rightHeight = height(root.right);
    int currentDia = leftHeight + rightHeight + 1;
    int lDiameter = diameter(root.left);
    int rDiameter = diameter(root.right);
    return Math.max(currentDia, Math.max(lDiameter, rDiameter));
  }

  public static void main(String[] args) {

    tree_prob4 bt = new tree_prob4();
    Node root = bt.new Node(1);
    root.left = bt.new Node(2);
    root.right = bt.new Node(3);
    root.left.left = bt.new Node(4);
    root.left.right = bt.new Node(5);
    root.right.left = bt.new Node(6);
    root.right.right = bt.new Node(7);
    System.out.println(bt.size(root));
    System.out.println(bt.height(root));
    System.out.println(bt.sum(root));
    System.out.println(bt.diameter(root));

  }
}
