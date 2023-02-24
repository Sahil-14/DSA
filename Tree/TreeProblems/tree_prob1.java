import java.util.Stack;

import NextGreater.stack;

public class tree_prob1 {
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

  void inorder(Node node) {
    if (node == null) {
      return;
    }
    inorder(node.left);
    System.out.print(node.data);
    inorder(node.right);
  }

  void inorderIterative(Node root) {
    Stacl<Node> stack = new Stack<>();
    Node node = root;
    while (true) {
      if (node != null) {
        stack.push(node);
        node = node.left;
      } else {
        if (stack.isEmpty) {
          break;
        }
        Node temp = stack.pop();
        System.out.println(temp.data);
        node = node.right;
      }
    }
  }

  void preorder(Node node) {
    if (node == null) {
      return;
    }
    System.out.println(node.data);
    preorder(node.left);
    preorder(node.right);
  }

  void preOrderIterative(Node root) {
    Stack<Node> stack = new Stack<>();
    Node node = root;
    if (node != null) {
      stack.push(node);
    }

    while (!stack.isEmpty) {
      Node temp = stack.pop();
      System.out.println(temp.data);
      if (node.left != null) {
        stack.push(node.left);
      }

      if (node.right != null) {
        stack.push(node.right);
      }
    }
  }


  void postorder(Node node) {
    if (node == null) {
      return;
    }
    postorder(node.left);
    postorder(node.right);
    System.out.println(node.data);
  }

  public void postorderIterative(Node root) {
    Stack<Node> stack1 = new Stack<>();
    Stack<Node> stack2 = new Stack<>();
    Node node = root;
    stack1.push(node);
    while (!stack1.isEmpty()) {
      Node temp = stack1.pop();
      if (temp.left != null) {
        stack1.push(node.left);
      } 

      if (temp.right != null) {
        stack1.push(node.right);
      } 
      stack2.push(temp);
    }

    while (!stack2.isEmpty()) {
      System.out.println(stack2.pop().data);
    }
  }
}
