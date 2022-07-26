import java.util.ArrayList;
import java.util.*;

/**
 * Minimum swap required to convert binary tree to binary search tree
 * 
 * Given the array representation of Complete Binary Tree i.e, if index i is the
 * parent, index 2*i + 1 is the left child and index 2*i + 2 is the right child.
 * The task is to find the minimum number of swap required to convert it into
 * Binary Search Tree.
 * 
 * 
 */

public class prob29 {
  // Pair class
  static class Pair {
    int first, second;

    Pair(int a, int b) {
      first = a;
      second = b;
    }
  }

  static void inorder(int a[], Vector<Integer> v, int n, int index) {
    // if index is greater or equal to vector size
    if (index >= n)
      return;
    inorder(a, v, n, 2 * index + 1);
    v.add(a[index]);
    inorder(a, v, n, 2 * index + 2);
  }

  public static int minSwaps(Vector<Integer> arr) {
    int n = arr.size();

    ArrayList<Pair> arrpos = new ArrayList<Pair>();
    for (int i = 0; i < n; i++) {
      arrpos.add(new Pair(arr.get(i), i));
    }

    // Sort the array by array element values to
    // get right position of every element as the
    // elements of second array.

    arrpos.sort(new Comparator<Pair>() {
      @Override
      public int compare(Pair o1, Pair o2) {
        return o1.first - o2.first;
      }
    });

    // To keep track of visited elements. Initialize
    // all elements as not visited or false.
    Boolean[] vis = new Boolean[n];
    Arrays.fill(vis, false);
    int ans = 0;
    for (int i = 0; i < n; i++) {
      // already swapped and corrected or
      // already present at correct pos
      if (vis[i] || arrpos.get(i).second == i)
        continue;
      // find out the number of node in
      // this cycle and add in ans
      int cycle_size = 0;
      int j = i;

      while (!vis[j]) {
        vis[j] = true;

        j = arrpos.get(j).second;
        cycle_size++;

      }

      // Update answer by adding current cycle.
      if (cycle_size > 0) {
        ans += (cycle_size - 1);
      }

    }

    return ans;

  }

  // method 2 :
  public static int minSwaps(int[] nums) {
    int len = nums.length;
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < len; i++)
      map.put(nums[i], i);

    Arrays.sort(nums);

    // To keep track of visited elements. Initialize
    // all elements as not visited or false.
    boolean[] visited = new boolean[len];
    Arrays.fill(visited, false);

    // Initialize result
    int ans = 0;
    for (int i = 0; i < len; i++) {

      // already swapped and corrected or
      // already present at correct pos
      if (visited[i] || map.get(nums[i]) == i)
        continue;

      int j = i, cycle_size = 0;
      while (!visited[j]) {
        visited[j] = true;

        // move to next node
        j = map.get(nums[j]);
        cycle_size++;
      }

      // Update answer by adding current cycle.
      if (cycle_size > 0) {
        ans += (cycle_size - 1);
      }
    }
    return ans;
  }

  // Driver code
  public static void main(String args[]) {
    int a[] = { 5, 6, 7, 8, 9, 10, 11 };
    int n = a.length;

    Vector<Integer> v = new Vector<Integer>();

    inorder(a, v, n, 0);

    System.out.println(minSwaps(v));
  }

}
