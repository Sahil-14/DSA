import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//combinational sum
/**
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen
 * numbers sum to target. You may return the combinations in any order.
 * 
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen
 * numbers is different.
 * 
 * 
 * 
 * Time Complexity
 * O(N^(M/T + 1)) where N is the number of candidates, M is the smallest
 * candidate among all the given integers, and T is the target value. Thus the
 * time complexity is exponential and this is expected because the algorithm is
 * recursive backtracking.
 * 
 * Space Complexity
 * O(T/M), where T is the target value and M is the minimal element among all
 * other candidates.
 * 
 * 
 */
public class bt_prob3 {
  public static List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    // Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
  }

  private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
    if (remain < 0)
      return;
    else if (remain == 0)
      list.add(new ArrayList<>(tempList));
    else {
      for (int i = start; i < nums.length; i++) {
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, remain - nums[i], i + 1); // not i + 1 because we can reuse same elements
        tempList.remove(tempList.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = { 1, 3, 5, 2 };
    List<List<Integer>> output = combinationSum(nums, 6);
    for (List<Integer> x : output) {
      for (Integer y : x)
        System.out.print(y + " ");
      System.out.println();
    }
  }
}
