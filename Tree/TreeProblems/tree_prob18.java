public class tree_prob18 {
  class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = this.right = null;
    }
  }

  Node sortedArrayToBst(int arr[], int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = (start + end) / 2;
    Node root = new Node(arr[mid]);
    root.left = sortedArrayToBst(arr, start, mid - 1);
    root.right = sortedArrayToBst(arr, mid + 1, end);
    return root;
  }

  void inorder(Node root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    System.out.println(root.data);

    inorder(root.right);
  }

  public static void main(String[] args) {
    tree_prob18 bst = new tree_prob18();
    int arr[] = { 10, 20, 30, 40, 50 };
    Node root = bst.sortedArrayToBst(arr, 0, arr.length - 1);
    bst.inorder(root);
  }
}
