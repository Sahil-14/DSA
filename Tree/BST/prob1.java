/**
 * lca of bst
 * 
 * 
 * Time Complexity: O(h).
 * The time Complexity of the above solution is O(h), where h is the height of
 * the tree.
 * Space Complexity: O(h).
 * If recursive stack space is ignored, the space complexity of the above
 * solution is constant.
 */

public class prob1 {
  static class Node {
    int data;
    Node left, right;

    Node(int item) {
      data = item;
      left = right = null;
    }
  }

  Node root;

  Node lca(Node node, int n1, int n2) {
    if (node == null) {
      return null;
    }

    if (node.data > n1 && node.data > n2) {
      return lca(node.left, n1, n2);
    }

    if (node.data < n1 && node.data < n2) {
      return lca(node.right, n1, n2);
    }
    return node;
  }

  // method :2
  static Node lcaIte(Node root, int n1, int n2) {
    while (root != null) {
      if (root.data > n1 && root.data > n2) {
        root = root.left;
      } else if (root.data < n1 && root.data < n2) {
        root = root.right;
      } else
        break;
    }
    return root;

  }

  public static void main(String args[]) {
    // Let us construct the BST shown in the above figure
    prob1 tree = new prob1();
    tree.root = new Node(20);
    tree.root.left = new Node(8);
    tree.root.right = new Node(22);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(12);
    tree.root.left.right.left = new Node(10);
    tree.root.left.right.right = new Node(14);

    int n1 = 10, n2 = 14;
    Node t = tree.lca(tree.root, n1, n2);
    System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

    n1 = 14;
    n2 = 8;
    t = tree.lca(tree.root, n1, n2);
    System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

    n1 = 10;
    n2 = 22;
    t = tree.lca(tree.root, n1, n2);
    System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

  }
}
