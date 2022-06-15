import java.util.Stack;

import FindDuplicatesInUnsorted.Node;

//zigzag traversal

public class prob8 {
  public void zigzag(Node root) {
    if (root == null) {
      return;
    }
    Stack<Node> s1 = new Stack<>();
    Stack<Node> s2 = new Stack<>();

    s1.push(root);

    while (!s1.isEmpty() || !s2.empty()) {
      while (!s1.isEmpty()) {
        Node temp = s1.pop();
        System.out.println(temp.data);
        if (temp.left != null) {
          s2.push(temp.left);
        }
        if (temp.right != null) {
          s2.push(temp.right);
        }
      }
      while (!s2.isEmpty()) {
        Node temp = s2.pop();
        System.out.println(temp.data);
        if (temp.right != null) {
          s1.push(temp.right);
        }
        if (temp.left != null) {
          s1.push(temp.left);
        }
      }
    }

  }
}
