import java.util.Stack;
//zigzag traversal
public class tree_prob19 {
  class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = this.right = null;
    }
  }

  public void zigzagTraverse(Node root) {
    if (root == null) {
      return;
    }
    Stack<Node> s1 = new Stack<>();
    Stack<Node> s2 = new Stack<>();
    s1.push(root);
    while (!s1.isEmpty() || !s2.isEmpty()) {
      while (!s1.isEmpty()) {
        root = s1.pop();
        System.out.println(root.data);
        if (root.left != null) {
          s2.push(root.left);
        }
        if (root.right != null) {
          s2.push(root.right);
        }
      }

      while (!s2.isEmpty()) {
        root = s2.pop();
        System.out.println(root.data);
        if (root.right != null) {
          s1.push(root.right);
        }
        if (root.left != null) {
          s1.push(root.left);
        }

      }
    }
  }
}
