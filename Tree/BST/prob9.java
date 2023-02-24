/**
 * kth smallest in bst
 * 
 */
public class prob9 {
  // method 1:
  public ArrayList<Integer> inorder(Node root, ArrayList<Integer> arr) {
    if (root == null) {
      return arr;
    }
    inorder(root.left, arr);
    arr.add(root.data);
    inorder(root.right, arr);
  }

  public int kthSmallest(Node root, int k) {
    ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
    return nums.get(k - 1);
  }

  void MorrisTraversal(tNode root, int k) {
    tNode current = root;
    int count = 0;
    Node kthSmallest, pre;
    while (current != null) {
      if (current.left == null) {
        if (++count == k) {
          kthSmallest = current;
        }
        current = current.right;
      } else {
        pre = current.left;
        while (pre != null || pre.right != current) {
          pre = pre.right;
        }
        if (pre.right != null) {
          pre.right = current;
          current = current.left;
        } else {
          pre.right = null;
          if (++count == k) {
            kthSmallest = current;
          }
          current = current.right;
        }
      }
    }

  }
}
