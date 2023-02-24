
// to find maximum length of sub array having sum 0
import java.io.*;
import java.util.HashMap;

public class prob5 {
  public static int maxSumSubarray(int arr[]) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    hm.put(0, 0);
    int length = -1;
    int curSum = 0;
    for (int i = 0; i < arr.length; i++) {
      curSum += arr[i];
      if (hm.containsKey(curSum)) {
        length = Math.max(length, i + 1 - hm.get(curSum));
      } else {
        hm.put(curSum, i + 1);
      }
    }
    return length;
  }
  

  // Find subarray with given sum

  public static void main(String[] args) {
    int[] arr = new int[] { 15, -2, 2, -8, 1, 7, 10, 23 };
    System.out.println(maxSumSubarray(arr));
  }
}
