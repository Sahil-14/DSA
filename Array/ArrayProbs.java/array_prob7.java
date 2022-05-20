//find next permutation
//step1 : first check consecutive pair of array arr[i] & arr[i+1] such that arr[i] > arr[i+1];
//step2 :find first element grateer than i search from right
//step3 : swap i and j
//step4 : reverse from i+1;
1,5,8,4,7,6,5,3,1


public class array_prob7 {
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

  public static void main(String[] args) {
    array_prob7 ob = new array_prob7();
    int[] arr = { 1, 2, 3, 6, 5, 4 };
    ob.nextPermutation(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }

  }
}
