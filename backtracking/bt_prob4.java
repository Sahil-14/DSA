
import java.util.*;

/**
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sum to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note: The solution set must not contain duplicate combinations.
 * 
 * 
 */

public class bt_prob4 {
  public static List<List<Integer>> combinationalSumII(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack(ans, new ArrayList<>(), target, 0, candidates);
    return ans;
  }

  private static void backtrack(List<List<Integer>> ans, List<Integer> templist, int target, int start, int[] arr) {
    if (target == 0) {
      ans.add(new ArrayList<>(templist));
      return;
    }
    for (int i = start; i < arr.length; i++) {
      if (i > start && arr[i] == arr[i - 1])
        continue;
      if (arr[i] > target)
        break;
      templist.add(arr[i]);
      backtrack(ans, templist, target - arr[i], i + 1, arr);
      templist.remove(templist.size() - 1);
    }
  }

  public static void main(String args[]) {
    int v[] = { 10, 1, 2, 7, 6, 1, 5 };
    List<List<Integer>> comb = combinationalSumII(v, 8);
    System.out.println(comb.toString().replace(",", " "));
  }
}
