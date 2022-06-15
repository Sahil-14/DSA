//build tree from inorder and preoder sequence

public class tree_prob2 {
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

  int preIndex = 0;
  Node root = null;

  Node buildTree(int inorder[], int preorder[], int start, int end) {
    if (start > end) {
      return null;
    }

    Node node = new Node(preorder[preIndex]++);
    if (start == end) {
      return node;
    }

    int index = search(inorder, start, end, node.data);
    node.left = buildTree(inorder, preorder, start, index - 1);
    node.right = buildTree(inorder, preorder, index + 1, end);

    return node;
  }

  public int search(int inorder[], int start, int end, int data) {

    for (int i = start; i <= end; i++) {
      if (inorder[i] == data) {
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

  public static void main(String[] args) {
    tree_prob2 ob = new tree_prob2();
    int preorder[] = { 1, 2, 4, 3, 5 };
    int inorder[] = { 4, 2, 1, 5, 3 };
    Node root = ob.buildTree(inorder, preorder, 0, 4);
    ob.inorderPrint(root);

  }
}
