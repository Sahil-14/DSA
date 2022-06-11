import java.util.HashMap;

// A hashing based Java program to find
// if there are four elements with given sum.
public class prob2 {
  static class pair {
    int first, second;

    public pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  static void findFourElements(int arr[], int n, int X) {
    // Store sums of all pairs in a hash table
    HashMap<Integer, pair> mp = new HashMap<Integer, pair>();
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        mp.put(arr[i] + arr[j], new pair(i, j));
      }
    }
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int sum = arr[i] + arr[j];
        if (mp.containsKey(X - sum)) {
          // Making sure that all elements are
          // distinct array elements and an
          // element is not considered more than
          // once.
          pair p = mp.get(X - sum);
          if (p.first != i && p.first != j && p.second != i && p.second != j) {
            System.out.print(
                arr[i] + ", " + arr[j] + ", "
                    + arr[p.first] + ", "
                    + arr[p.second]);
            return;
          }
        }

      }
    }
  }

  // method 2 withoud duplicates
  public static void fourSum(int X, int[] arr,
      Map<Integer, pair> map) {
    int[] temp = new int[arr.length];

    // Iterate from 0 to temp.length
    for (int i = 0; i < temp.length; i++)
      temp[i] = 0;

    // Iterate from 0 to arr.length
    for (int i = 0; i < arr.length - 1; i++) {

      // Iterate from i + 1 to arr.length
      for (int j = i + 1; j < arr.length; j++) {

        // Store curr_sum = arr[i] + arr[j]
        int curr_sum = arr[i] + arr[j];

        // Check if X - curr_sum if present
        // in map
        if (map.containsKey(X - curr_sum)) {

          // Store pair having map value
          // X - curr_sum
          pair p = map.get(X - curr_sum);

          if (p.first != i && p.sec != i
              && p.first != j && p.sec != j
              && temp[p.first] == 0
              && temp[p.sec] == 0 && temp[i] == 0
              && temp[j] == 0) {

            // Print the output
            System.out.printf(
                "%d,%d,%d,%d", arr[i], arr[j],
                arr[p.first], arr[p.sec]);
            temp[p.sec] = 1;
            temp[i] = 1;
            temp[j] = 1;
            break;
          }
        }
      }
    }
  }

  // Driver Code
  // Program for two Sum
  public static Map<Integer, pair> twoSum(int[] nums) {
    Map<Integer, pair> map = new HashMap<>();
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        map.put(nums[i] + nums[j], new pair(i, j));
      }
    }
    return map;
  }

  public static void main(String[] args) {
    int arr[] = { 10, 20, 30, 40, 1, 2 };
    int n = arr.length;
    int X = 91;

    // Function call
    findFourElements(arr, n, X);

    /**
     * 
     * int[] arr = { 10, 20, 30, 40, 1, 2 };
     * int n = arr.length;
     * int X = 91;
     * Map<Integer, pair> map = twoSum(arr);
     * 
     * // Function call
     * fourSum(X, arr, map);
     */
  }

}
