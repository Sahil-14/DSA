
/**
 * Print all the paths from root, with a specified sum in Binary tree
 * Given a Binary tree and a sum S, print all the paths, starting from root,
 * that sums upto the given sum.
 * Note that this problem is different from root to leaf paths. Here path
 * doesn’t need to end on a leaf node.
 * 
 * 
 * Input : sum = 38,
 * Root of tree
 * 10
 * / \
 * 28 13
 * / \
 * 14 15
 * / \ / \
 * 21 22 23 24
 * Output : Path found: 10 28
 * Path found: 10 13 15
 */
import java.util.*;

public class prob27 {
  static class Node {
    int key;
    Node left, right;
  };

  // Utility function to create a new node
  static Node newNode(int key) {
    Node temp = new Node();
    temp.key = key;
    temp.left = temp.right = null;
    return (temp);
  }

  static void printSumUtil(Node curr_node, int sum, int sum_so_far, ArrayList<Integer> path) {
    if (curr_node == null) {
      return;
    }

    sum_so_far += curr_node.key;
    path.add(curr_node.key);

    if (sum_so_far == sum) {
      System.out.print("Path found: ");
      for (int i = 0; i < path.size(); i++)
        System.out.print(path.get(i) + " ");

      System.out.println();
    }

    // If left child exists
    if (curr_node.left != null)
      printSumUtil(curr_node.left, sum,
          sum_so_far, path);

    // If right child exists
    if (curr_node.right != null)
      printSumUtil(curr_node.right, sum,
          sum_so_far, path);

    // Remove last element from path
    // and move back to parent
    path.remove(path.size() - 1);

  }

  static void printPaths(Node root, int sum) {
    ArrayList<Integer> path = new ArrayList<>();
    printSumUtil(root, sum, 0, path);
  }

  // Driver code
  public static void main(String[] args) {

    /*
     * 10
     * / \
     * 28 13
     * / \
     * 14 15
     * / \ / \
     * 21 22 23 24
     */
    Node root = newNode(10);
    root.left = newNode(28);
    root.right = newNode(13);

    root.right.left = newNode(14);
    root.right.right = newNode(15);

    root.right.left.left = newNode(21);
    root.right.left.right = newNode(22);
    root.right.right.left = newNode(23);
    root.right.right.right = newNode(24);

    int sum = 38;

    printPaths(root, sum);
  }
}
