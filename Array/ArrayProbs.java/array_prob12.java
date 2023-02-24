import java.util.Stack;

//trappping rainwater

public class array_prob12 {

  /**
   * Time Complexity: O(N)
   * Auxiliary Space: O(N)
   * 
   */

  /**
   * Brute Approach
   * Traverse every array element and find the highest bars on the left and right
   * sides. Take the smaller of two heights. The difference between the smaller
   * height and the height of the current element is the amount of water that can
   * be stored in this array element.
   */

   public static int maxWater(int[] arr, int n) {

    // To store the maximum water
    // that can be stored
    int res = 0;

    // For every element of the array
    // except first and last element
    for (int i = 1; i < n - 1; i++) {

      // Find maximum element on its left
      int left = arr[i];
      for (int j = 0; j < i; j++) {
        left = Math.max(left, arr[j]);
      }

      // Find maximum element on its right
      int right = arr[i];
      for (int j = i + 1; j < n; j++) {
        right = Math.max(right, arr[j]);
      }

      // Update maximum water value
      res += Math.min(left, right) - arr[i];
    }
    return res;
  }

  public static int trapingRainwater(int arr[]) {
    Stack<Integer> s = new Stack<>();
    int ans = 0;
    for (int i = 0; i < arr.length; i++) {
      while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
        int current = s.pop();
        if (s.isEmpty()) {
          break;
        }
        int diff = i - s.peek() - 1;
        ans += (Math.min(arr[i], arr[s.peek()]) - arr[current]) * diff;
      }
      s.push(i);
    }
    return ans;
  }

  public static void main(String[] args) {
    int arr[] = { 4, 2, 0, 3, 2, 5 };
    System.out.println(trapingRainwater(arr));
  }
}
