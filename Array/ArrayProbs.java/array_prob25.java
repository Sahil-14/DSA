import java.io.*;
import java.util.*;

public class array_prob25 {
  static int longSubarrWthSumDivByK(int arr[], int n,
      int k) {
    // Complete the function
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;

    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
      // to handle negavtive values as well
      int mod = ((sum % k) + k) % k;

      // this will be the longest possible length from
      // start
      if (mod == 0)
        max = i + 1;

      if (!map.containsKey(mod))
        map.put(mod, i);
      else {
        int sz = i - map.get(mod);
        max = Math.max(max, sz);
      }
    }

    return max;
  }

  public static void main(String[] args) {
    int arr[] = { 2, 7, 6, 1, 4, 5 };
    int n = arr.length;
    int k = 3;

    System.out.println(
        "Length = "
            + longSubarrWthSumDivByK(arr, n, k));
  }
}
