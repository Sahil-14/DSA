/**
 * Convert a given Binary Tree to Doubly Linked List
 * 
 * 
 */

public class prob28 {
  // A binary tree node has data, left pointers and right pointers
  class Node {
    int data;
    Node left, right;

    public Node(int data) {
      this.data = data;
      left = right = null;
    }
  }

  Node root;

  // head --> Pointer to head node of created doubly linked list
  Node head;

  static Node prev = null;

  void BinaryTree2DoubleLinkedList(Node root) {
    if (root == null) {
      return;
    }

    BinaryTree2DoubleLinkedList(root.left);
    if (prev == null) {
      head = root;
    } else {
      root.left = prev;
      prev.right = root;
    }
    prev = root;
    BinaryTree2DoubleLinkedList(root.right);

  }

  /* Function to print nodes in a given doubly linked list */
  void printList(Node node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.right;
    }
  }

  // Driver program to test above functions
  public static void main(String[] args) {
    // Let us create the tree as shown in above diagram
    prob28 tree = new prob28();
    tree.root = tree.new Node(10);
    tree.root.left = tree.new Node(12);
    tree.root.right = tree.new Node(15);
    tree.root.left.left = tree.new Node(25);
    tree.root.left.right = tree.new Node(30);
    tree.root.right.left = tree.new Node(36);

    // convert to DLL
    tree.BinaryTree2DoubleLinkedList(tree.root);

    // Print the converted List
    tree.printList(tree.head);

  }

}
