
//three sum
import java.util.*;

public class array_prob17 {
  public static List<List<Integer>> findTriplets(int[] nums, int sum) {

    /* Sort the elements */
    Arrays.sort(nums);

    List<List<Integer>> pair = new ArrayList<>();
    HashSet<String> set = new HashSet<String>();
    List<Integer> triplets = new ArrayList<>();

    /*
     * Iterate over the array from the start
     * and consider it as the first element
     */
    for (int i = 0; i < nums.length - 2; i++) {

      // index of the first element in the
      // remaining elements
      int j = i + 1;

      // index of the last element
      int k = nums.length - 1;

      while (j < k) {

        if (nums[i] + nums[j]
            + nums[k] == sum) {

          String str = nums[i] + ":" + nums[j]
              + ":" + nums[k];

          if (!set.contains(str)) {

            // To check for the unique triplet
            triplets.add(nums[i]);
            triplets.add(nums[j]);
            triplets.add(nums[k]);
            pair.add(triplets);
            triplets = new ArrayList<>();
            set.add(str);
          }

          // increment the second value index
          j++;

          // decrement the third value index
          k--;
        } else if (nums[i]
            + nums[j]
            + nums[k] < sum)
          j++;

        else
          k--;
      }
    }
    return pair;
  }

  // target 0
  public static List<List<Integer>> threeSum(int[] nums) {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Arrays.sort(nums);
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      int p = i + 1, q = n - 1;
      while (p < q) {
        if (nums[p] + nums[q] == -nums[i]) { // System.out.println(p+" "+q);
          List<Integer> t = new ArrayList<Integer>();
          t.add(nums[i]);
          t.add(nums[p]);
          t.add(nums[q]);

          ans.add(t);

          while (p + 1 < q && nums[p + 1] == nums[p])
            p++;
          while (q - 1 > p && nums[q - 1] == nums[q])
            q--;

          p++;
          q--;
        } else if (nums[p] + nums[q] < -nums[i])
          p++;
        else
          q--;
      }

      while (i + 1 < n && nums[i + 1] == nums[i])
        i++;
    }
    return ans;
  }

  // Driver code
  public static void main(String[] args) {
    int[] nums = { 12, 3, 6, 1, 6, 9 };
    int sum = 24;

    // List<List<Integer>> triplets = findTriplets(nums, sum);
    findTriplets2(nums, nums.length, sum);
    // Function call
    // if (!triplets.isEmpty()) {
    // System.out.println(triplets);
    // } else {
    // System.out.println("No triplets can be formed");
    // }
  }
}
