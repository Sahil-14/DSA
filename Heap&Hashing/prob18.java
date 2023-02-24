import java.util.ArrayList;

/**
 * 
 * // Find subarray with given sum
 * 
 */

public class prob18 {

  int subArraySum(int arr[], int n, int sum) {
    ArrayList<Integer> result = new ArrayList<>();
    int curr_sum = 0;
    for (int i = 0; i < n; i++) {
      curr_sum += arr[i];
      if (curr_sum - sum == 0) {
        int start = 0;
        int end = i;
        result.add(start);
        result.add(end);
        break;
      }

      if (hm.containsKey(curr_sum - sum)) {
        int start = hm.get(curr_sum - sum) + 1;
        int end = i;
        result.add(start);
        result.add(end);
        break;
      }
      hm.put(curr_sum, i);

    }
  }

  //method 2 with constant space
  static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
    int start = 0;
    int last = 0;
    boolean flag = false;
    int currsum = 0;
    ArrayList<Integer> res = new ArrayList<Integer>();

    // iterating over the array.
    for (int i = 0; i < n; i++) {
      // storing sum upto current element.
      currsum += arr[i];

      // checking if current sum is greater than or equal to given number.
      if (currsum >= s) {
        last = i;
        // we start from starting index till current index and do the
        // excluding part while s(given number) < currsum.
        while (s < currsum && start < last) {
          // subtracting the element from left i.e., arr[start]
          currsum -= arr[start];
          ++start;
        }

        // now if current sum becomes equal to given number, we store
        // the starting and ending index for the subarray.
        if (currsum == s) {
          res.add(start + 1);
          res.add(last + 1);

          // flag is set to true since subarray exists.
          flag = true;
          break;
        }
      }
    }
    // if no subarray is found, we store -1 in result else the found indexes.
    if (flag == false) {
      res.add(-1);
    }
    // returning the result.
    return res;
  }

  public static void main(String[] args) {

  }
}
