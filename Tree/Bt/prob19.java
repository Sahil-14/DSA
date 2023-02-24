//boundary traversal

public class prob19 {
  static class Node {
    int data;
    Node left, right;

    Node(int item) {
      data = item;
      left = right = null;
    }
  }

  Node root;

  private boolean isLeaf(Node node) {
    if (node.left == null && node.right == null) {
      return true;
    }
    return false;
  }

  private void addLeftBound(Node root,
      ArrayList<Integer> ans) {
    root = root.left;
    while (root != null) {
      if (!isLeaf(root)) {
        ans.add(root.data);
      }
      if (root.left != null) {
        root = root.left;
      } else {
        root = root.right;
      }
    }
  }

  private void addRightBound(Node root,
      ArrayList<Integer> ans) {
    root = root.right;
    Stack<Integer> st = new Stack<>();
    while (root != null) {
      if (!isLeaf(root)) {
        ans.add(root.data);
      }
      if (root.right != null) {
        root = root.right;
      } else {
        root = root.left;
      }
    }

    while (!st.isEmpty()) {
      ans.add(stk.peek());
      stk.pop();
    }
  }

  // its kind of inorder
  private void addLeaves(Node root,
      ArrayList<Integer> ans) {
    if (root == null) {
      return;
    }

    if (isLeaf(root)) {
      ans.add(root.data); // just store leaf nodes
      return;
    }

    addLeaves(root.left, ans);
    addLeaves(root.right, ans);
  }

  ArrayList<Integer> boundary(Node root) {
    ArrayList<Integer> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }

    if (!isLeaf(root)) {
      ans.add(root.data); // if leaf then its done by
                          // addLeaves
    }

    addLeftBound(root, ans);
    addLeaves(root, ans);
    addRightBound(root, ans);
    return ans;
  }

  // Driver program to test above functions
  public static void main(String[] args) {
    // Let us construct the tree given in the above
    // diagram
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(20);
    tree.root.left = new Node(8);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(12);
    tree.root.left.right.left = new Node(10);
    tree.root.left.right.right = new Node(14);
    tree.root.right = new Node(22);
    tree.root.right.right = new Node(25);

    ArrayList<Integer> ans = tree.boundary(tree.root);

    for (int i = 0; i < ans.size(); i++) {
      System.out.print(ans.get(i) + " ");
    }
    System.out.println();
  }
}
