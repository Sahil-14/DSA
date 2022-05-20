
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

  public static void findTriplets2(int a[], int n, int sum) {
    int i;

    // Sort the input array
    Arrays.sort(a);

    // For handling the cases when no such
    // triplets exits.
    boolean flag = false;

    // Iterate over the array from start to n-2.
    for (i = 0; i < n - 2; i++) {
      if (i == 0 || a[i] > a[i - 1]) {
        // Index of the first element in
        // remaining range.
        int start = i + 1;

        // Index of the last element
        int end = n - 1;

        // Setting our new target
        int target = sum - a[i];

        while (start < end) {
          // Checking if current element
          // is same as previous
          if (start > i + 1
              && a[start] == a[start - 1]) {
            start++;
            continue;
          }

          // Checking if current element is
          // same as previous
          if (end < n - 1
              && a[end] == a[end + 1]) {
            end--;
            continue;
          }

          // If we found the triplets then print it
          // and set the flag
          if (target == a[start] + a[end]) {
            System.out.print("[" + a[i]
                + "," + a[start]
                + "," + a[end] + "] ");
            flag = true;
            start++;
            end--;
          }

          // If target is greater then
          // increment the start index
          else if (target > (a[start] + a[end])) {
            start++;
          }

          // If target is smaller than
          // decrement the end index
          else {
            end--;
          }
        }
      }
    }

    // If no such triplets found
    if (flag == false) {
      System.out.print("No Such Triplets Exist");
    }
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
