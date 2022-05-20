/**
 * 
 * 11. Container With Most Water
 * You are given an integer array height of length n. There are n vertical lines
 * drawn such that the two endpoints of the ith line are (i, 0) and (i,
 * height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 * 
 * Return the maximum amount of water a container can store
 */

public class array_prob15 {
  static int maxArrea(int arr[], int n) {
    int l = 0, r = n - 1;
    int maxArea = Integer.MIN_VALUE;
    while (l < r) {
      int width = r - l;
      maxArea = Math.max(maxArea, Math.min(arr[l], arr[r]) * width);
      if (arr[l] <= arr[r]) {
        l++;
      } else {
        r--;
      }
    }

    return maxArea;
  }

  public static void main(String[] args) {
    int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
    System.out.print(maxArrea(height, height.length));
  }
}
