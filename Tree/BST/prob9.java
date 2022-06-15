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

  //
}
