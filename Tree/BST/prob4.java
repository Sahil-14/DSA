/**
 * Simple Recursive solution to check whether BST contains dead end
 * Given a Binary Search Tree that contains positive integer values greater than
 * 0. The task is to check whether the BST contains a dead end or not. Here Dead
 * End means, we are not able to insert any integer element after that node.
 * 
 * 
 * Input : 8
 * / \
 * 5 9
 * / \
 * 2 7
 * /
 * 1
 * Output : Yes
 * Explanation : Node "1" is the dead End because
 * after that we cant insert any element.
 * 
 * 
 */

public class prob4 {
  class Node {
    int data;
    Node left, right;

    public Node(int item) {
      data = item;
      left = right = null;
    }
  }

  Node root;

  prob4() {
    root = null;
  }

  // This method mainly calls insertRec()
  void insert(int data) {
    root = insertRec(root, data);
  }

  Node insertRec(Node root, int data) {
    if (root == null) {
      root = new Node(data);
      return root;
    }
    if (data < root.data) {
      root.left = insertRec(root.left, data);
    } else if (data > root.data) {
      root.right = insertRec(root.right, data);
    }

    return root;
  }

  boolean deadEnd(Node root, int min, int max) {
    // if the root is null or the recursion moves
    // after leaf node it will return false
    // i.e no dead end.
    if (root == null)
      return false;

    // if this occurs means dead end is present.
    if (min == max)
      return true;

    // heart of the recursion lies here.
    return deadEnd(root.left, min, root.data - 1) ||
        deadEnd(root.right, root.data + 1, max);
  }

  public static void main(String[] args) {
    prob4 tree = new prob4();

    /*
     * 8
     * / \
     * 5 11
     * / \
     * 2 7
     * \
     * 3
     * \
     * 4
     */
    tree.insert(8);
    tree.insert(5);
    tree.insert(2);
    tree.insert(3);
    tree.insert(7);
    tree.insert(11);
    tree.insert(4);

    if (tree.deadEnd(tree.root, 1,
        Integer.MAX_VALUE) == true)

      System.out.println("Yes ");
    else
      System.out.println("No ");
  }

}
