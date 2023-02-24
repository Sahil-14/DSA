import java.util.*;

public class array_prob31 {
  public static int firstMissingPositive(int[] nums,
      int n) {
    Arrays.sort(nums);
    int ans = 1;
    for (int i = 0; i < n; i++) {
      if (nums[i] == ans)
        ans++;
    }
    return ans;
  }

  public static int firstMissingPositive2(int arr[], int n) {
    // Check if 1 is present in array or not
    for (int i = 0; i < n; i++) {

      // Loop to check boundary
      // condition and for swapping
      while (arr[i] >= 1 && arr[i] <= n
          && arr[i] != arr[arr[i] - 1]) {

        int temp = arr[arr[i] - 1];
        arr[arr[i] - 1] = arr[i];
        arr[i] = temp;
      }
    }

    for (int i = 0; i < n; i++) {
      if (arr[i] != i + 1) {
        return i + 1;
      }
    }

    return (n + 1);
  }

  // Driver Code
  public static void main(String[] args) {
    int arr[] = { 2, 3, -7, 6, 8, 1, -10, 15 };
    int n = arr.length;
    int ans = firstMissingPositive2(arr, n);

    System.out.println(ans);
  }

}
