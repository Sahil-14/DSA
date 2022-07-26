/**
 * Construct BST from given preorder traversal | Set 1
 * 
 * 
 * 
 */

public class prob20 {
  class Node {

    int data;
    Node left, right;

    Node(int d) {
      data = d;
      left = right = null;
    }
  }

  class Index {

    int index = 0;
  }

  Index index = new Index();

  Node constructTreeUtil(int pre[], Index preIndex,
      int key, int min, int max,
      int size) {
    // Base case
    if (preIndex.index >= size) {
      return null;
    }
    Node root = null;
    if (key > min && key < max) {
      root = new Node(key);
      preIndex.index = preIndex.index + 1;
      if (preIndex.index < size) {
        root.left = constructTreeUtil(
            pre, preIndex, pre[preIndex.index], min,
            key, size);
      }

      if (preIndex.index < size) {
        // All nodes which are in range {key..max}
        // will go in right subtree, and first such
        // node will be root of right subtree.
        root.right = constructTreeUtil(
            pre, preIndex, pre[preIndex.index], key,
            max, size);
      }

    }
    return root;

  }

  // The main function to construct BST from given
  // preorder traversal. This function mainly uses
  // constructTreeUtil()
  Node constructTree(int pre[], int size) {
    int preIndex = 0;
    return constructTreeUtil(pre, index, pre[0],
        Integer.MIN_VALUE,
        Integer.MAX_VALUE, size);
  }

  // A utility function to print inorder traversal of a
  // Binary Tree
  void printInorder(Node node) {
    if (node == null) {
      return;
    }
    printInorder(node.left);
    System.out.print(node.data + " ");
    printInorder(node.right);
  }

  // Driver code
  public static void main(String[] args) {
    prob20 tree = new prob20();
    int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
    int size = pre.length;

    // Function call
    Node root = tree.constructTree(pre, size);
    System.out.println(
        "Inorder traversal of the constructed tree is ");
    tree.printInorder(root);
  }
}
