/**
 * Find median of BST in O(n) time and O(1) space
 * Given a Binary Search Tree, find median of it.
 * If no. of nodes are even: then median = ((n/2th node + ((n)/2th+1) node) /2
 * If no. of nodes are odd : then median = (n+1)/2th node.
 * For example, median of below BST is 12.
 * 
 * 
 * Given BST(with odd no. of nodes) is :
 * 6
 * / \
 * 3 8
 * / \ / \
 * 1 4 7 9
 * 
 * Inorder of Given BST will be : 1, 3, 4, 6, 7, 8, 9
 * So, here median will 6.
 * 
 * Given BST(with even no. of nodes) is :
 * 6
 * / \
 * 3 8
 * / \ /
 * 1 4 7
 * 
 * Inorder of Given BST will be : 1, 3, 4, 6, 7, 8
 * So, here median will (4+6)/2 = 5.
 * 
 * 
 */
public class prob17 {
  static class Node {
    int data;
    Node left, right;
  }

  // A utility function to create a new BST node
  static Node newNode(int item) {
    Node temp = new Node();
    temp.data = item;
    temp.left = null;
    temp.right = null;
    return temp;
  }

  /*
   * A utility function to insert a new node with
   * given key in BST
   */
  static Node insert(Node node, int key) {
    /* If the tree is empty, return a new node */
    if (node == null)
      return newNode(key);

    /* Otherwise, recur down the tree */
    if (key < node.data)
      node.left = insert(node.left, key);
    else if (key > node.data)
      node.right = insert(node.right, key);

    /* return the (unchanged) node pointer */
    return node;
  }

  static int countNodes(Node root) {
    Node current, pre;
    int count = 0;

    if (root == null) {
      return count;
    }

    current = root;

    while (current != null) {
      if (current.left == null) {
        count++;
        current = current.right;
      } else {
        pre = current.left;
        while (pre.right != null && pre.right != current) {
          pre = pre.right;
        }

        if (pre.right == null) {
          pre.right = current;
          current = current.left;
        } else {
          pre.right = null;
          count++;
          current = current.right;
        }
      }

    }

    return count;

  }

  static int findMedian(Node root) {
    if (root == null)
      return 0;

    int count = countNodes(root);
    int currCount = 0;
    Node current = root, pre = null, prev = null;

    while (current != null) {
      if (current.left == null) {
        // count current node
        currCount++;

        // check if current node is the median
        // Odd case
        if (count % 2 != 0 && currCount == (count + 1) / 2)
          return prev.data;

        // Even case
        else if (count % 2 == 0 && currCount == (count / 2) + 1)
          return (prev.data + current.data) / 2;

        // Update prev for even no. of nodes
        prev = current;

        // Move to the right
        current = current.right;
      } else {
        /* Find the inorder predecessor of current */
        pre = current.left;
        while (pre.right != null && pre.right != current)
          pre = pre.right;

        /* Make current as right child of its inorder predecessor */
        if (pre.right == null) {
          pre.right = current;
          current = current.left;
        }

        /*
         * Revert the changes made in if part to restore the original
         * tree i.e., fix the right child of predecessor
         */
        else {
          pre.right = null;

          prev = pre;

          // Count current node
          currCount++;

          // Check if the current node is the median
          if (count % 2 != 0 && currCount == (count + 1) / 2)
            return current.data;

          else if (count % 2 == 0 && currCount == (count / 2) + 1)
            return (prev.data + current.data) / 2;

          // update prev node for the case of even
          // no. of nodes
          prev = current;
          current = current.right;

        } /* End of if condition pre->right == NULL */
      } /* End of if condition current->left == NULL */
    } /* End of while */
    return -1;
  }

  /* Driver code */
  public static void main(String[] args) {

    /*
     * Let us create following BST
     * 50
     * / \
     * 30 70
     * / \ / \
     * 20 40 60 80
     */
    Node root = null;
    root = insert(root, 50);
    insert(root, 30);
    insert(root, 20);
    insert(root, 40);
    insert(root, 70);
    insert(root, 60);
    insert(root, 80);

    System.out.println("Median of BST is " + findMedian(root));
  }
}
