
/**
 * Print Nodes in Top View of Binary Tree
 * 
 * Top view of a binary tree is the set of nodes visible when the tree is viewed
 * from the top. Given a binary tree, print the top view of it. The output nodes
 * can be printed in any order.
 * 
 * A node x is there in output if x is the topmost node at its horizontal
 * distance. Horizontal distance of left child of a node x is equal to
 * horizontal distance of x minus 1, and that of right child is horizontal
 * distance of x plus 1.
 * 
 * 
 * 
 */
import java.util.*;

public class prob16 {
  Node root;

  public prob16() {
    root = null;
  }

  class QueueObj {
    Node node;
    int hd;

    QueueObj(Node node, int hd) {
      this.node = node;
      this.hd = hd;
    }
  }

  private void TopView(Node root) {
    Queue<QueueObj> q = new LinkedList<QueueObj>();
    Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>();

    if (root == null) {
      return;
    } else {
      q.add(new QueueObj(root, 0));
    }

    System.out.println(
        "The top view of the tree is : ");

    // count function returns 1 if the container
    // contains an element whose key is equivalent
    // to hd, or returns zero otherwise.
    while (!q.isEmpty()) {
      QueueObj tmpNode = q.poll();
      if (!topViewMap.containsKey(tmpNode.hd)) {
        topViewMap.put(tmpNode.hd, tmpNode.node);
      }

      if (tmpNode.node.left != null) {
        q.add(new QueueObj(tmpNode.node.left,
            tmpNode.hd - 1));
      }
      if (tmpNode.node.right != null) {
        q.add(new QueueObj(tmpNode.node.right,
            tmpNode.hd + 1));
      }
    }
    for (Map.Entry<Integer, Node> entry : topViewMap.entrySet()) {
      System.out.print(entry.getValue().data + " ");
    }
  }

  public static void main(String[] args) {
    /*
     * Create following Binary Tree
     * 1
     * / \
     * 2 3
     * \
     * 4
     * \
     * 5
     * \
     * 6
     */
    prob16 tree = new prob16();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.right = new Node(4);
    tree.root.left.right.right = new Node(5);
    tree.root.left.right.right.right = new Node(6);
    System.out.println(
        "Following are nodes in top view of Binary Tree");
    tree.TopView(tree.root);
  }

}
