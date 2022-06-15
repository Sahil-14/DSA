
/**
 * ]
 * Find postorder traversal of BST from preorder traversal
 * Input : 40 30 35 80 100
 * Output : 35 30 100 80 40
 * 
 * Input : 40 30 32 35 80 90 100 120
 * Output : 35 32 30 120 100 90 80 40
 */
import java.util.*;

public class prob11 {
  static class INT {
    int data;

    INT(int d) {
      data = d;
    }
  }

  static void findPostOrderUtil(int pre[], int n,
      int minval, int maxval,
      INT preIndex) {

    if (preIndex.data == n)
      return;

    if (pre[preIndex.data] < minval
        || pre[preIndex.data] > maxval) {
      return;
    }

    int val = pre[preIndex.data];
    preIndex.data++;

    // All elements with value between minval and val
    // lie in left subtree.
    findPostOrderUtil(pre, n, minval, val, preIndex);
    // All elements with value between val and maxval
    // lie in right subtree.
    findPostOrderUtil(pre, n, val, maxval, preIndex);
    System.out.print(val + " ");

  }

  // Function to find postorder traversal.
  static void findPostOrder(int pre[], int n) {

    // To store index of element to be
    // traversed next in preorder array.
    // This is passed by reference to
    // utility function.
    INT preIndex = new INT(0);

    findPostOrderUtil(pre, n, Integer.MIN_VALUE,
        Integer.MAX_VALUE, preIndex);
  }

  // Driver code
  public static void main(String args[]) {
    int pre[] = { 40, 30, 35, 80, 100 };

    int n = pre.length;

    // Calling function
    findPostOrder(pre, n);
  }
}
