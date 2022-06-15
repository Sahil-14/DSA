import prob53.Node;

//check if 2 trees are same

public class prob12 {
  public boolean areIdentical(Node root1, Node root2) {
    if (root1 == null && root2 == null) {
      return true;
    }

    if (root1 != null || root2 != null) {
      return false;
    }
    int l = areIdentical(root1.left, root2.left);
    int r = areIdentical(root1.right, root2.right);

    return (root1.data == root2.data) && l && r;

  }
}
