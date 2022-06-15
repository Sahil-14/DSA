
/**
 * Check if a Binary Tree contains duplicate subtrees of size 2 or more
 * Given a Binary Tree, check whether the Binary tree contains a duplicate
 * sub-tree of size 2 or more.
 * Note : Two same leaf nodes are not considered as subtree size of a leaf node
 * is one.
 * 
 * 
 */
public class prob23 {
  static char MARKER = '$';

  public static String dupSubUtil(Node root, HashSet<String> subtrees) {
    String s = "";
    if (root == null) {
      return s + MARKER;
    }

    String lStr = dupSubUtil(root.left, subtrees);
    if (lStr.equals(s)) {
      return s;
    }

    String rStr = dupSubUtil(root.right, subtrees);
    if (rStr.equals(s))
      return s;

    s = s + root.data + lStr + rStr;
    if (s.length() > 3 && subtrees.contains(s))
      return "";

    subtrees.add(s);
    return s;

  }

  public static String dupSub(Node root) {
    HashSet<String> subtrees = new HashSet<>();
    return dupSubUtil(root, subtrees);
  }

  public static void main(String args[]) {
    Node root = new Node('A');
    root.left = new Node('B');
    root.right = new Node('C');
    root.left.left = new Node('D');
    root.left.right = new Node('E');
    root.right.right = new Node('B');
    root.right.right.right = new Node('E');
    root.right.right.left = new Node('D');
    String str = dupSub(root);
    if (str.equals(""))
      System.out.print(" Yes ");
    else
      System.out.print(" No ");
  }
}
