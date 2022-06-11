import java.util.*;
import java.util.stream.Collectors;

public class prob16 {
  public static List<Integer> findKClosestElements(int[] nums, int k, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (right - left >= k) {
      if (Math.abs(nums[left] - target) > Math.abs(nums[right] - target)) {
        left++;
      } else {
        right--;
      }
    }
    int arr[] = Arrays.copyOfRange(nums, left, right + 1);
    for (int i : arr) {
      System.out.println(i);
    }

    return Arrays.stream(nums, left, right + 1).boxed()
        .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    int[] nums = { 10, 12, 15, 17, 18, 20, 25 };
    int target = 16, k = 4;

    System.out.println(findKClosestElements(nums, k, target));
  }
}
