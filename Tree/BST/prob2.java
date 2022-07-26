public class prob2 {
  class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = this.right = null;
    }
  }

  int minValue(Node root) {
    Node temp = root;
    while (temp.left != null) {
      temp = temp.left;
    }
    return temp.data;
  }

  Node insertRec(Node root, int key) {
    if (root == null) {
      return new Node(key);
    }
    if (root.data > key) {
      root.left = insertRec(root.left, key);
    } else {
      root.right = insertRec(root.right, key);
    }
    return root;
  }

  Node deleteRec(Node root, int key) {
    if (root == null) {
      return root;
    }
    // if only one child is present
    if (key < root.data) {
      root.left = deleteRec(root.left, key);
    } else if (key > root.data) {
      root.right = deleteRec(root.right, key);
    }
    // if both child is presient
    else {
      if (root.left == null) {
        return root.right;
      }

      if (root.right = null) {
        return root.left;
      }

      root.key = minValue(root.right);
      root.right = deleteRec(root.right, root.key);
    }

    return root;
  }

  public void inorder(Node root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    System.out.println(root.data);
    inorder(root.right);
  }

  Node search(Node root, int key) {
    if (root == null) {
      return null;
    }

    if (root.data == key) {
      return root;
    } else if (root.data > key) {
      return search(root.left, key);
    } else {
      return search(root.right, key);
    }
  }

  public static void main(String[] args) {
    tree_prob14 bt = new tree_prob14();
    Node root = null;
    root = bt.insertRec(root, 50);
    root = bt.insertRec(root, 30);
    root = bt.insertRec(root, 20);
    root = bt.insertRec(root, 40);
    root = bt.insertRec(root, 70);
    root = bt.insertRec(root, 60);
    root = bt.insertRec(root, 80);

    bt.inorder(root);
    System.out.print(bt.search(root, 34));
  }
}
