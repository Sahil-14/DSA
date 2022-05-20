public class tree_prob21 {
  class Node {
    int data;
    Node left, right;

    public Node(final int d) {
      data = d;
    }
  }
  static int MAX = Integer.MAX_VALUE;
  static int MIN = Integer.MIN_VALUE;
 
  class NodeInfo {
    int size;
    int min;
    int max;
    boolean isBST;

    NodeInfo() {

    }

    NodeInfo(int size, int min, int max, boolean isBST) {
      this.size = size;
      this.min = min;
      this.max = max;
      this.isBST = isBST;
    }
  }
  
  static NodeInfo largestBST(Node root) {
    if (root == null) {
      return new NodeInfo(0, MIN, MAX, true);
    }

    if (root.left == null && root.right == null) {
      return new NodeInfo(1, root.data, root.data, true);
    }

    NodeInfo left = largestBST(root.left);
    NodeInfo right = largestBST(root.right);

    NodeInfo returnInfo = new NodeInfo();
  
    if (left.isBST && right.isBST && left.max < root.data && right.min > root.data) {
       returnInfo.min = Math.min(Math.min(left.min, right.min), root.data);
      returnInfo.max = Math.max(Math.max(left.max, right.max), root.data);
      returnInfo.size = left.size + 1 + right.size;
      returnInfo.isBST = true;
    }
    returnInfo.size = Math.max(left.size, right.size);
      returnInfo.isBST = false;
    return returnInfo;
  }
}
