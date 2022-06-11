//find maxsum path in binary tree

public class tree_prob13 {
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

  class Res {
    public int val;
  }

  int findMaxUtil(Node root, Res res) {
    if (root == null) {
      return 0;
    }

    // find all posible combination in single path ,node.data , node.data + left &
    // node.data + right;

    int l = findMaxUtil(root.left, res);
    int r = findMaxUtil(root.right, res);

    int max_single = Math.max(root.data, root.data + Math.max(l, r));

    // compare single path with full path
    int max_top = Math.max(max_single, l + r + root.data);
    res.val = Math.max(res.val, max_top);
    return max_single;
  }

  public int findmaxsum(Node root) {
    Res res = new Res();
    res.val = Integer.MIN_VALUE;
    findMaxUtil(root, res);
    return res.val;
  }

  public static void main(String[] args) {
    tree_prob13 bt = new tree_prob13();
    Node root = bt.new Node(10);
    root.left = bt.new Node(2);
    root.right = bt.new Node(10);
    root.left.left = bt.new Node(20);
    root.left.right = bt.new Node(1);
    root.right.right = bt.new Node(-25);
    root.right.right.left = bt.new Node(3);
    root.right.right.right = bt.new Node(4);
    System.out.println(bt.findmaxsum(root));
  }
}
