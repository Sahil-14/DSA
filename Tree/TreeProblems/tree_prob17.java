public class tree_prob17 {
  class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = this.right = null;
    }
  }

  class PreorderIndex {
    int preorderIdx = 0;
  }

  Node constructBSTFromPreorder(int preorder[], PreorderIndex preorderIndex, int key, int min, int max, int n) {
    if (preorderIndex.preorderIdx >= n) {
      return null;
    }

    Node root = null;

    if (key > min && key < max) {
      root = new Node(key);
      preorderIndex.preorderIdx = preorderIndex.preorderIdx + 1;

      if (preorderIndex.preorderIdx < n) {
        root.left = constructBSTFromPreorder(preorder, preorderIndex, preorder[preorderIndex.preorderIdx], min, key, n);
      }

      if (preorderIndex.preorderIdx < n) {
        root.right = constructBSTFromPreorder(preorder, preorderIndex, preorder[preorderIndex.preorderIdx], key, max,
            n);
      }
    }
    return root;
  }

  void preorder(Node root) {
    if (root == null) {
      return;
    }
    System.out.println(root.data);
    preorder(root.left);
    preorder(root.right);
  }

  public static void main(String[] args) {
    tree_prob17 bst = new tree_prob17();
    int preorder[] = { 10, 2, 1, 13, 11 };
    int n = 5;
    PreorderIndex preorderIdx = bst.new PreorderIndex();
    Node root = bst.constructBSTFromPreorder(preorder, preorderIdx, preorder[0], Integer.MIN_VALUE, Integer.MAX_VALUE,
        5);
    bst.preorder(root);
  }
}
