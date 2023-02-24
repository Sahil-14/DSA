
import java.util.*;

/**
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * 
 * 
 * 
 */
public class array_prob34 {

  // O(n*n!).
  // Function for swapping two numbers
  static void swap(int nums[], int l, int i) {
    int temp = nums[l];
    nums[l] = nums[i];
    nums[i] = temp;
  }

  // Function to find the possible
  // permutations
  static void permutations(ArrayList<int[]> res,
      int[] nums, int l, int h) {
    // Base case
    // Add the array to result and return
    if (l == h) {
      res.add(Arrays.copyOf(nums, nums.length));
      return;
    }

    // Permutations made
    for (int i = l; i <= h; i++) {
      // Swapping
      swap(nums, l, i);

      // Calling permutations for
      // next greater value of l
      permutations(res, nums, l + 1, h);

      // Backtracking
      swap(nums, l, i);
    }
  }

  // ==============

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    boolean[] visited = new boolean[nums.length];
    dfs(nums, res, new LinkedList<>(), visited);
    return res;
  }

  private static void dfs(int[] nums, List<List<Integer>> res, List<Integer> curr, boolean[] visited) {
    // stopping codn;
    if (curr.size() == nums.length) {
      res.add(new LinkedList<Integer>(curr));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        curr.add(nums[i]);
        dfs(nums, res, curr, visited);
        curr.remove(curr.size() - 1);
        visited[i] = false;
      }
    }

  }

  // O(n!).

  // =============
  /**
   * 
   * Given a collection of numbers that might contain duplicates, return all
   * possible unique permutations.
   * 
   * For example, [1,1,2] have the following unique permutations: [1,1,2],
   * [1,2,1], and [2,1,1].
   * 
   */

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    if (nums == null || nums.length == 0) {
      return res;
    }
    Arrays.sort(nums);
    boolean[] visited = new boolean[nums.length];
    dfs2(nums, visited, new LinkedList<Integer>(), res);
    return res;
  }

  private void dfs2(int[] nums, boolean[] visited, List<Integer> curr, List<List<Integer>> res) {
    if (curr.size() == nums.length) {
      res.add(new LinkedList<Integer>(curr));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (visited[i] == true) {
        continue;
      }
      if (i == 0 || nums[i] != nums[i - 1] || (nums[i] == nums[i - 1] && visited[i - 1] == true)) {
        visited[i] = true;
        curr.add(nums[i]);
        dfs2(nums, visited, curr, res);
        curr.remove(curr.size() - 1);
        visited[i] = false;
      }
    }
  }

  public static void main(String[] args) {

    int arr[] = { 1, 2, 3 };
    System.out.println(permute(arr));
  }
}
