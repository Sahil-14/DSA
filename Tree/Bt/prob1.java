//Write a Program to Find the Maximum Depth or Height of a Tree
class prob1 {
  class Node {
    int data;
    Node left, right;

    Node(int item) {
      data = item;
      left = right = null;
    }
  }

  Node root;

  int maxDepth(Node node) {
    if (node == null) {
      return 0;
    }

    int left = maxDepth(node.left);
    int right = maxDepth(node.right);
    return 1 + Math.max(left, right);

  }

  // method2 : level order travelsal
  public static int height(Node root) {
    if (root == null) {
      return 0;
    }
    Queue<Integer> q = new LinkedList<>();
    int depth = 0;
    q.add(root);
    q.add(null);

    while (!q.isEmpty()) {
      Node top = q.poll();
      if (top != null) {
        if (top.left != null) {
          q.add(top.left);
        }
        if (top.right != null) {
          q.add(top.right);
        }
      } else if (!q.isEmpty) {
        q.add(null);
        depth++;
      }
    }

    return depth;

  }

  public static void main(String[] args) {
    prob1 tree = new prob1();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);

    System.out.println("Height of tree is : " +
        tree.maxDepth(tree.root));
  }
}
