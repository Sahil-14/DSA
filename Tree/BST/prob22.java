
//avl tree
/**
 * * Date 07/04/2014
 * 
 * @author tusroy
 *
 *         Video link - https://youtu.be/rbg7Qf8GkQ4
 *
 *         Write a program to insert into an AVL tree.
 * 
 *         AVL tree is self balancing binary tree. Difference of height of left
 *         or right subtree
 *         cannot be greater than one.
 * 
 *         There are four different use cases to insert into AVL tree
 *         left left - needs ones right rotation
 *         left right - needs one left and one right rotation
 *         right left - needs one right and one left rotation
 *         right right - needs one left rotation
 * 
 *         Follow rotation rules to keep tree balanced.
 * 
 *         At every node we will also keep height of the tree so that we don't
 *         have to recalculate values again.
 * 
 *         Runtime complexity to insert into AVL tree is O(logn).
 * 
 *         References
 *         http://en.wikipedia.org/wiki/AVL_tree
 *         http://www.geeksforgeeks.org/avl-tree-set-1-insertion/
 * 
 * 
 */

public class prob22 {

  class Node {
    int key, height;
    Node left, right;

    Node(int d) {
      key = d;
      height = 1;
    }
  }

  Node root;

  int height(Node N) {
    if (N == null)
      return 0;

    return N.height;
  }

  int max(int a, int b) {
    return (a > b) ? a : b;
  }

  Node rightRotate(Node y) {
    Node x = y.left;
    Node T2 = x.right;
    x.right = y;
    y.left = T2;

    y.height = max(height(y.left), height(y.right)) + 1;
    x.height = max(height(x.left), height(x.right)) + 1;
    return x;

  }

  Node leftRotate(Node x) {
    Node y = x.right;
    Node T2 = y.left;

    y.left = x;
    x.right = T2;

    // Update heights
    x.height = max(height(x.left), height(x.right)) + 1;
    y.height = max(height(y.left), height(y.right)) + 1;
    return y;

  }

  // Get Balance factor of node N
  int getBalance(Node N) {
    if (N == null)
      return 0;

    return height(N.left) - height(N.right);
  }

  // A utility function to print preorder traversal
  // of the tree.
  // The function also prints height of every node
  void preOrder(Node node) {
    if (node != null) {
      System.out.print(node.key + " ");
      preOrder(node.left);
      preOrder(node.right);
    }
  }

  Node insert(Node node, int key) {

    /* 1. Perform the normal BST insertion */
    if (node == null)
      return (new Node(key));

    if (key < node.key) {
      node.left = insert(node.left, key);
    } else if (key > node.key) {
      node.right = insert(node.right, key);
    } else // Duplicate keys not allowed
      return node;

    /* 2. Update height of this ancestor node */
    node.height = 1 + max(height(node.left),
        height(node.right));

    int balance = getBalance(node);

    // If this node becomes unbalanced, then there
    // are 4 cases Left Left Case
    if (balance > 1 && key < node.left.key)
      return rightRotate(node);
    // Left Right Case
    if (balance > 1 && key > node.left.key) {
      node.left = leftRotate(node.left);
      return rightRotate(node);
    }
    // Right Right Case
    if (balance < -1 && key > node.right.key)
      return leftRotate(node);

    // Right Left Case
    if (balance < -1 && key < node.right.key) {
      node.right = rightRotate(node.right);
      return leftRotate(node);
    }

    /* return the (unchanged) node pointer */
    return node;
  }

  public static void main(String[] args) {
    prob22 tree = new prob22();

    /* Constructing tree given in the above figure */
    tree.root = tree.insert(tree.root, 10);
    tree.root = tree.insert(tree.root, 20);
    tree.root = tree.insert(tree.root, 30);
    tree.root = tree.insert(tree.root, 40);
    tree.root = tree.insert(tree.root, 50);
    tree.root = tree.insert(tree.root, 25);

    /*
     * The constructed AVL Tree would be
     * 30
     * / \
     * 20 40
     * / \ \
     * 10 25 50
     */
    System.out.println("Preorder traversal" +
        " of constructed tree is : ");
    tree.preOrder(tree.root);
  }
}
