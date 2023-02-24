import java.util.*;

//find all subset
public class bt_prob8 {
  public static List<List<Integer>> findsubset(int nums[]) {
    List<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> output = new ArrayList<>();
    subsetUtil(result, output, nums, 0);
    return result;
  }

  public static void subsetUtil(List<List<Integer>> result, ArrayList<Integer> output, int[] nums, int i) {
    if (i == nums.length) {
      result.add(output);
      return;
    }
    output.add(nums[i]);
    subsetUtil(result, new ArrayList<>(output), nums, i + 1);
    output.remove(output.size() - 1);
    subsetUtil(result, new ArrayList<>(output), nums, i + 1);

  }

  public static void main(String[] args) {

    int nums[] = { 1, 2, 3 };
    System.out.println(findsubset(nums));

  }
}
