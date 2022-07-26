
/**
 * Construct Binary Tree from Preorder and Inorder Traversal *
 * 
 */

import java.util.*;

public class prob14 {
  public static Node root;
  static HashMap<Character, Integer> mp = new HashMap<>();
  static int preIndex = 0;

  public static Node buildTree(char[] in, char[] pre, int inStrt, int inEnd) {
    if (inStrt > inEnd) {
      return null;
    }
    char curr = pre[preIndex++];
    Node tNode = new Node(curr);

    /* If this node has no children then return */
    if (inStrt == inEnd) {
      return tNode;
    }
    int inIndex = mp.get(curr);
    tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
    tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
    return tNode;

  }

  public static Node buldTreeWrap(char[] in, char[] pre, int len) {
    for (int i = 0; i < len; i++) {
      mp.put(in[i], i);
    }
    return buildTree(in, pre, 0, len - 1);
  }



  static void printInorder(Node node) {
    if (node == null) {
      return;
    }
    printInorder(node.left);
    System.out.print((char) node.data + " ");
    printInorder(node.right);

  }

  /* Driver code */
  public static void main(String[] args) {
    char[] in = { 'D', 'B', 'E', 'A', 'F', 'C' };
    char[] pre = { 'A', 'B', 'D', 'E', 'C', 'F' };
    int len = in.length;

    prob14.root = buldTreeWrap(in, pre, len);

    /*
     * Let us test the built tree by printing
     * Inorder traversal
     */
    System.out.println("Inorder traversal of the constructed tree is");
    printInorder(root);
  }
}
