import java.util.ArrayList;

/**
 * Merge Two Balanced Binary Search Trees
 * 
 */
public class prob16 {
  // A binary tree node
  static class Node {

    int data;
    Node left, right;

    Node(int d) {
      data = d;
      left = right = null;
    }
  }

  // Root of BST
  Node root;

  // Constructor
  prob16() {
    root = null;
  }

  // Inorder traversal of the tree
  void inorder() {
    inorderUtil(this.root);
  }

  void inorderUtil(Node node) {
    if (node == null) {
      return;
    }
    inorderUtil(node.left);
    System.out.print(node.data + " ");
    inorderUtil(node.right);
  }

  public ArrayList<Integer> storeInorderUtil(Node node, ArrayList<Integer> list) {
    if (node == null) {
      return list;
    }
    storeInorderUtil(node.left, list);
    list.add(node.data);
    storeInorderUtil(node.right, list);
    return list;
  }

  // Method that stores inorder traversal of a tree
  ArrayList<Integer> storeInorder(Node node) {
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = storeInorderUtil(node, list1);
    return list2;
  }

  ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2, int m, int n) {
    ArrayList<Integer> list3 = new ArrayList<>();
    int i = 0;
    int j = 0;
    while (i < m && j < n) {
      if (list1.get(i) < list2.get(j)) {
        list3.add(list1.get(i));
        i++;
      } else {
        list3.add(list2.get(j));
        j++;
      }
    }
    // Adds the remaining elements of list1 into list3
    while (i < m) {
      list3.add(list1.get(i));
      i++;
    }

    // Adds the remaining elements of list2 into list3
    while (j < n) {
      list3.add(list2.get(j));
      j++;
    }
    return list3;
  }

  Node ALtoBST(ArrayList<Integer> list, int start, int end) {
    if (start > end) {
      return null;
    }

    int mid = (start + end) / 2;
    Node node = new Node(list.get(mid));
    node.left = ALtoBST(list, start, mid - 1);
    node.right = ALtoBST(list, mid + 1, end);
    return node;

  }

  // Method that merges two trees into a single one.
  Node mergeTrees(Node node1, Node node2) {
    // Stores Inorder of tree1 to list1
    ArrayList<Integer> list1 = storeInorder(node1);

    // Stores Inorder of tree2 to list2
    ArrayList<Integer> list2 = storeInorder(node2);

    // Merges both list1 and list2 into list3
    ArrayList<Integer> list3 = merge(list1, list2, list1.size(), list2.size());

    // Eventually converts the merged list into resultant BST
    Node node = ALtoBST(list3, 0, list3.size() - 1);
    return node;
  }

  // Driver function
  public static void main(String[] args) {

    /*
     * Creating following tree as First balanced BST
     * 100
     * / \
     * 50 300
     * / \
     * 20 70
     */

    prob16 tree1 = new prob16();
    tree1.root = new Node(100);
    tree1.root.left = new Node(50);
    tree1.root.right = new Node(300);
    tree1.root.left.left = new Node(20);
    tree1.root.left.right = new Node(70);

    /*
     * Creating following tree as second balanced BST
     * 80
     * / \
     * 40 120
     */

    prob16 tree2 = new prob16();
    tree2.root = new Node(80);
    tree2.root.left = new Node(40);
    tree2.root.right = new Node(120);

    prob16 tree = new prob16();
    tree.root = tree.mergeTrees(tree1.root, tree2.root);
    System.out.println("The Inorder traversal of the merged BST is: ");
    tree.inorder();
  }

}
