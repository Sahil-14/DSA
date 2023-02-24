//find next permutation
//step1 : first check consecutive pair of array arr[i] & arr[i+1] such that arr[i] > arr[i+1];
//step2 :find first element grateer than i search from right
//step3 : swap i and j
//step4 : reverse from i+1;
1,5,8,4,7,6,5,3,1


public class array_prob7 {

  //brute force 
  /**
   * In this approach, we find out every possible permutation of list formed by the elements 
   * of the given array and find out the permutation which is just larger than the given one.
   *  But this one will be a very naive approach, since it requires us to find out every possible
   *  permutation which will take really long time and the implementation is complex.
   *  Thus, this approach is not acceptable at all. Hence, we move on directly to the correct approach.
   * 
   * Time complexity : O(n!). Total possible permutations is n!.
Space complexity : O(n). Since an array will be used to store the permutations.
   */

   // solution explanation
   //https://leetcode.com/problems/next-permutation/solution/

  public void nextPermutation(int[] nums) {
    int i = nums.length - 2;
    while (i >= 0 && nums[i + 1] <= nums[i]) {
      i--;
    }
    if (i >= 0) {
      int j = nums.length - 1;
      while (nums[j] <= nums[i]) {
        j--;
      }
      swap(nums, i, j);
    }
    reverse(nums, i + 1);
  }

  private void reverse(int[] nums, int start) {
    int i = start, j = nums.length - 1;
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  /**
   *t ime complexity : O(n)O(n). In worst case, only two scans of the whole array are needed
Space complexity : O(1)O(1). No extra space is used. In place replacements are don
   * 

   */

  public static void main(String[] args) {
    array_prob7 ob = new array_prob7();
    int[] arr = { 1, 2, 3, 6, 5, 4 };
    ob.nextPermutation(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }

  }
}
