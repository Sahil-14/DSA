
/**
 * Merge two sorted arrays with O(1) extra space
 * Input: ar1[] = {10};
       ar2[] = {2, 3};
Output: ar1[] = {2}
        ar2[] = {3, 10}  

Input: ar1[] = {1, 5, 9, 10, 15, 20};
       ar2[] = {2, 3, 8, 13};
Output: ar1[] = {1, 2, 3, 5, 8, 9}
        ar2[] = {10, 13, 15, 20}

 * 
 */
import java.util.*;

public class prob14 {
  static int arr1[] = new int[] { 1, 5, 9, 10, 15, 20 };
  static int arr2[] = new int[] { 2, 3, 8, 13 };

  static void merge(int m, int n) {
    int i = 0, j = 0, k = m - 1;

    while (i <= k && j < n) {
      if (arr1[i] < arr2[j]) {
        i++;
      } else {
        int temp = arr2[j];
        arr2[j] = arr1[k];
        arr1[k] = temp;
        j++;
        k--;
      }
    }

    Arrays.sort(arr1);
    Arrays.sort(arr2);
  }

  // method 2:

  static void merge2(int n, int m) {
    int i = 0;
    int temp = 0;

    while (arr1[n - 1] > arr2[0]) {
      if (arr1[i] > arr2[0]) {
        temp = arr1[i];
        arr1[i] = arr2[0];
        arr2[0] = temp;
        Arrays.sort(arr2);
      }
      i++;
    }
  }

  public static void main(String[] args) {
    merge(arr1.length, arr2.length);
    System.out.print("After Merging \nFirst Array: ");
    System.out.println(Arrays.toString(arr1));
    System.out.print("Second Array:  ");
    System.out.println(Arrays.toString(arr2));
  }

}
