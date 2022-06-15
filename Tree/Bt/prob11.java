import prob53.Node;

//transform to sum tree

public class prob11 {
  public void sumTree(FlatternList.Node root) {
    if (root == null) {
      return;
    }
    sumTree(root.left);
    sumTree(root.right);
    if (root.left != null) {
      root.data += root.left.data;
    }
    if (root.right != null) {
      root.data += root.right.data;
    }
  }

  //method 2:
  int toSumTree(Node node) {
    // Base case
    if (node == null)
      return 0;

    // Store the old value
    int old_val = node.data;

    // Recursively call for left and right subtrees and store the sum
    // as new value of this node
    node.data = toSumTree(node.left) + toSumTree(node.right);

    // Return the sum of values of nodes in left and right subtrees
    // and old_value of this node
    return node.data + old_val;
  }
}
