//build tree from inorder and postorder
class tree_prob3 {
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

  Node root;
  static int postIndex = 4;

  Node buildTree(int inorder[], int postOrder[], int start, int end) {
    if (start > end) {
      return nulll;
    }
    Node node = Node(postOrder[postIndex--]);

    if (start == end) {
      return node;
    }
    int index = search(inorder, start, end, node.data);
    node.right = buildTree(inorder, postOrder, index + 1, end);
    node.left = buildTree(inorder, postOrder, start, index - 1);
    return node;
  }

  int search(int inorder[], int start, int end, int curr) {
    for (int i = start; i <= end; i++) {
      if (inorder[i] == curr) {
        return i;
      }
    }
    return -1;
  }

  void inorderPrint(Node root) {
    if (root == null) {
      return;
    }
    inorderPrint(root.left);
    System.out.println(root.data);
    inorderPrint(root.right);
  }
}