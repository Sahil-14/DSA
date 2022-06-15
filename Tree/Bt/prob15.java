//Diameter of a Binary Tree
/**
 * 
 * 
 */
public class prob15 {
  class Height {
    int h;
  }

  // method 1

  int diameter(Node root) {
    // base case if tree is empty
    if (root == null)
      return 0;

    // get the height of left and right sub-trees
    int lheight = height(root.left);
    int rheight = height(root.right);

    // get the diameter of left and right sub-trees
    int ldiameter = diameter(root.left);
    int rdiameter = diameter(root.right);
    /*
     * Return max of following three
     * 1) Diameter of left subtree
     * 2) Diameter of right subtree
     * 3) Height of left subtree + height of right subtree + 1
     */
    return 1 + Math.max(lheight + rheight, Math.max(ldiameter, rdiameter));
  }

  static int height(Node node) {
    // base case tree is empty
    if (node == null)
      return 0;

    // If tree is not empty then height = 1 + max of
    // left height and right heights
    return (1
        + Math.max(height(node.left),
            height(node.right)));
  }

  // method 2
  int diameterOpt(Node root, Height height) {
    // lh --> Height of left subtree
    // rh --> Height of right subtree
    Height lh = new Height(), rh = new Height();

    if (root == null) {
      height.h = 0;
      return 0; // diameter is also 0
    }
    /*
     * ldiameter --> diameter of left subtree
     * rdiameter --> Diameter of right subtree
     * Get the heights of left and right subtrees in lh and rh.
     * And store the returned values in ldiameter and ldiameter
     */
    int ldiameter = diameterOpt(root.left, lh);
    int rdiameter = diameterOpt(root.right, rh);

    // Height of current node is max of heights of left
    // and right subtrees plus 1
    height.h = Math.max(lh.h, rh.h) + 1;

    return Math.max(lh.h + rh.h,
        Math.max(ldiameter, rdiameter));
  }
}
