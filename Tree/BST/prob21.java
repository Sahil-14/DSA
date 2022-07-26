/**
 * Replace every element with the least greater element on its right
 * 
 */

public class prob21 {
  // method 1: using bst
  /**
   * A tricky solution would be to use Binary Search Trees. We start scanning the
   * array from right to left and insert each element into the BST. For each
   * inserted element, we replace it in the array by its inorder successor in BST.
   * If the element inserted is the maximum so far (i.e. its inorder successor
   * doesn’t exist), we replace it by -1.
   * 
   */

  class Node {
    int data;
    Node left, right;

    Node(int d) {
      data = d;
      left = right = null;
    }
  }

  // Root of BST
  static Node root;
  static Node succ;

  // Constructor
  prob21() {
    root = null;
    succ = null;
  }

  // A utility function to insert a new node with
  // given data in BST and find its successor
  Node insert(Node node, int data) {
    if (node == null) {
      node = new Node(data);
    }

    if (data < node.data) {
      succ = node;
      node.left = insert(node.left, data);
    } else if (data > node.data) {
      node.right = insert(node.right, data);

    }

    return node;
  }

  static void replace(int arr[], int n) {
    prob21 tree = new prob21();

    for (int i = n - 1; i >= 0; i--) {
      succ = null;
      root = tree.insert(root, arr[i]);

      if (succ != null)
        arr[i] = succ.data;
      // No inorder successor
      else
        arr[i] = -1;
    }
  }

  public static void main(String[] args) {
    int arr[] = new int[] { 8, 58, 71, 18, 31,
        32, 63, 92, 43, 3,
        91, 93, 25, 80, 28 };
    int n = arr.length;

    replace(arr, n);

    for (int i = 0; i < n; i++)
      System.out.print(arr[i] + " ");
  }

  // method 2 using stack
  static int[] nextGreaterIndex(ArrayList<int[]> temp) {
    int n = temp.size();
    Arrays.fill(res, -1);
    Stack<Integer> stack = new Stack<Integer>();
    for (int i = 0; i < n; i++) {
      if (stack.empty()
          || temp.get(i)[1] < stack.peek())
        stack.push(temp.get(
            i)[1]);

      else {
        while (!stack.empty()
            && temp.get(i)[1] > stack.peek()) {
          res[stack.peek()] = temp.get(i)[1];
          stack.pop();
        }
        // after that push the current index to the
        // stack
        stack.push(temp.get(i)[1]);
      }
    }

    return res;

  }

  static int[] replaceByLeastGreaterUsingStack(int arr[],
      int n) {
    ArrayList<int[]> temp = new ArrayList<int[]>();
    for (int i = 0; i < n; i++) {
      temp.add(new int[] { arr[i], i });
    }

    Collections.sort(temp, (a, b) -> {
      if (a[0] == b[0])
        return a[1] - b[1];
      return a[0] - b[0];
    });

    // now indexes vector will store the next greater
    // index for each temp[i].second index
    int[] indexes = nextGreaterIndex(temp);
    // we initialize a result vector with all -1
    int[] res = new int[n];
    Arrays.fill(res, -1);
    for (int i = 0; i < n; i++) {
      // now if there is no next greater index after
      // the index temp[i].second the result will be
      // -1 otherwise the result will be the element
      // of the array arr at index
      // indexes[temp[i].second]
      if (indexes[temp.get(i)[1]] != -1)
        res[temp.get(i)[1]] = arr[indexes[temp.get(i)[1]]];
    }
    // return the res which will store the least greater
    // element of each and every element in the array at
    // its right side
    return res;

  }

  public static void main(String[] args) {
    int arr[] = { 8, 58, 71, 18, 31, 32, 63, 92,
        43, 3, 91, 93, 25, 80, 28 };
    int n = arr.length;
    int[] res = replaceByLeastGreaterUsingStack(arr, n);
    System.out.println(
        "Least Greater elements on the right side are ");
    for (int i : res)
      System.out.print(i + " ");
    System.out.println();
  }

}
