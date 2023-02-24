import prob53.Node;

//Invert binary tree || mirror tree

public class prob4 {
  public Node InvertTree(Node root) {
    if (root == null) {
      return null;
    }
    Node right = InvertTree(root.right);
    Node left = InvertTree(root.left);

    root.left = right;
    root.right = left;
    return root;
  }

  /**
   * Time & Space Complexities: Worst-case Time complexity is O(n) and for space
   * complexity, If we don’t consider the size of the recursive stack for function
   * calls then O(1) otherwise O(h) where h is the height of the tree
   * 
   */

  // method 2:
  public TreeNode invertTree(TreeNode root) {
    if (root == null)
      return null;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode current = queue.poll();
      TreeNode temp = current.left;
      current.left = current.right;
      current.right = temp;
      if (current.left != null)
        queue.add(current.left);
      if (current.right != null)
        queue.add(current.right);
    }
    return root;
  }
}
