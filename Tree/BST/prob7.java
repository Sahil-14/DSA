
/**
 * inorder Tree Traversal without recursion and without stack!
 * Using Morris Traversal, we can traverse the tree without using stack and
 * recursion. The idea of Morris Traversal is based on Threaded Binary Tree. In
 * this traversal, we first create links to Inorder successor and print the data
 * using these links, and finally revert the changes to restore original tree.
 * 
 * 
 */
public class prob7 {
  static class tNode {
    int data;
    tNode left, right;

    tNode(int item) {
      data = item;
      left = right = null;
    }
  }

  tNode root;

  void MorrisTraversal(tNode root) {
    tNode current, pre;

    if (root == null) {
      return;
    }

    current = root;
    while (current != null) {
      if (current.left == null) {
        System.out.print(current.data + " ");
        current = current.right;
      } else {
        pre = current.left;
        while (pre.right != null && pre.right != current) {
          pre = pre.right;
        }
        /*
         * Make current as right
         * child of its
         * inorder predecessor
         */
        if (pre.right == null) {
          pre.right = current;
          current = current.left;
        } else {
          pre.right = null;
          System.out.print(current.data + " ");
          current = current.right;

        }
      }
    }
  }

  public static void main(String args[]) {
    /*
     * Constructed binary tree is
     * 1
     * / \
     * 2 3
     * / \
     * 4 5
     */
    prob7 tree = new prob7();
    tree.root = new tNode(1);
    tree.root.left = new tNode(2);
    tree.root.right = new tNode(3);
    tree.root.left.left = new tNode(4);
    tree.root.left.right = new tNode(5);

    tree.MorrisTraversal(tree.root);
  }

}
