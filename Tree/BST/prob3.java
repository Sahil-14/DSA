/**
 * inorder predecessor and predessoror
 * 
 */

public class prob3 {
  class Node {
    int data;
    Node left;
    Node right;

    Node() {
    };

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  Node pre = new Node(), suc = new Node();

  public void findPreSuc(Node root, int key) {
    if (root == null) {
      return;
    }

    if (root.data == key) {
      if (root.left != null) {
        Node temp = root.left;
        while (temp.right != null) {
          temp = temp.right;
        }
        pre = temp;
      }

      if (root.right != null) {
        Node temp = root.right;
        while (temp.left != null) {
          temp = temp.left;
        }
        suc = temp;
      }
      return;
    }
    if (key < root.data) {
      suc = root;
      findPreSuc(root.left, key);
    } else {
      pre = root;
      findPreSuc(root.right, key);
    }
  }

  public static void main(String[] args) {
    prob3 bst = new prob3();
    Node root = bst.new Node(50);
    root.left = bst.new Node(30);
    root.right = bst.new Node(70);
    root.left.left = bst.new Node(20);
    root.left.right = bst.new Node(40);
    root.right.left = bst.new Node(60);
    root.right.right = bst.new Node(80);
    bst.findPreSuc(root, 80);
    System.out.println("pre:" + bst.pre.data);
    System.out.println("suc:" + bst.suc.data);

  }
}
