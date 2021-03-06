
//check array contains duplicate
import java.util.*;

public class array_prob4 {

  static boolean duplicate(int arr[], int n) {
    HashSet<Integer> hs = new HashSet<>();
    for (int i = 0; i < n; i++) {
      if (hs.contains(arr[i])) {
        return true;
      }
      hs.add(arr[i]);
    }

    return false;
  }

  /*
   * Java program to Check if a given array contains duplicate
   * elements within k distance from each other
   * Input: k = 3, arr[] = {1, 2, 3, 4, 1, 2, 3, 4}
   * Output: false
   * All duplicates are more than k distance away.
   * 
   * Input: k = 3, arr[] = {1, 2, 3, 1, 4, 5}
   * Output: true
   * 1 is repeated at distance 3.
   * 
   * Input: k = 3, arr[] = {1, 2, 3, 4, 5}
   * Output: false
   * 
   * Input: k = 3, arr[] = {1, 2, 3, 4, 4}
   * Output: true
   * 
   * 
   * 
   */
  static boolean checkDuplicatesWithinK(int arr[], int k) {
    // Creates an empty hashset
    HashSet<Integer> set = new HashSet<>();

    // Traverse the input array
    for (int i = 0; i < arr.length; i++) {

      if (set.contains(arr[i]))
        return true;

      set.add(arr[i]);

      if (i >= k)
        set.remove(arr[i - k]);
    }
    return false;
  }

  public static void main(String[] args) {
    int arr[] = { 10, 5, 3, 4 };
    if (duplicate(arr, arr.length)) {
      System.out.println("yes");
    } else {
      System.out.println("false");
    }
  }
}
