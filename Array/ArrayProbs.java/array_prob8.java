
//find the repeting and missing element in an array
import java.util.*;

public class array_prob8 {

  /**
   * 
   * Method 1 (Use Sorting)
   * Approach:
   * 
   * Sort the input array.
   * Traverse the array and check for missing and repeating.
   * 
   */
  public static void repetAndMissingUsingMapping(int arr[]) {
    Map<Integer, Boolean> numberMap = new HashMap<>();
    int max = arr.length;
    for (Integer i : arr) {
      if (numberMap.get(i) == null) {
        numberMap.put(i, true);
      } else {
        System.out.println("Repeating =" + i);
      }
    }

    for (int i = 1; i <= max; i++) {
      if (numberMap.get(i) == null) {
        System.out.println("Missing = " + i);
      }
    }
  }

  /**
   * 
   * time = O(n)
   * space = O(n)
   */
  public static void repetAndMissingUsingConstantSpace(int arr[]) {
    int n = arr.length;
    System.out.print("The repeating element is ");

    for (int i = 0; i < n; i++) {
      int abs = Math.abs(arr[i]);
      if (arr[abs - 1] > 0) {
        arr[abs - 1] = -arr[abs - 1];
      } else {
        System.out.println(abs);
      }
    }

    System.out.print("and the missing element is ");
    for (int i = 0; i < n; i++) {
      if (arr[i] > 0)
        System.out.println(i + 1);
    }

  }

  public static void repetAndMissingUsingBit(int arr[], int n) {
    int xor1;
    int set_bit_no;
    int i,
        x = 0,
        y = 0;
    xor1 = arr[0];
    /* Get the xor of all array elements */
    for (i = 1; i < n; i++)
      xor1 = xor1 ^ arr[i];

    /*
     * XOR the previous result with numbers from
     * 1 to n
     */
    for (i = 1; i <= n; i++)
      xor1 = xor1 ^ i;

    set_bit_no = (xor1 & -xor1);

    /*
     * Now divide elements into two sets by comparing
     * rightmost set bit of xor1 with the bit at the same
     * position in each element. Also, get XORs of two
     * sets. The two XORs are the output elements. The
     * following two for loops serve the purpose
     */
    for (i = 0; i < n; i++) {
      if ((arr[i] & set_bit_no) != 0)
        /* arr[i] belongs to first set */
        x = x ^ arr[i];

      else
        /* arr[i] belongs to second set */
        y = y ^ arr[i];
    }

    for (i = 1; i <= n; i++) {
      if ((i & set_bit_no) != 0)
        /* i belongs to first set */
        x = x ^ i;
      else
        /* i belongs to second set */
        y = y ^ i;
    }
    System.out.println(" The missing element is  "
        + x + "and the "
        + "repeating number is "
        + y);
  }

  public static void main(String[] args) {
    int arr[] = { 1, 3, 4, 5, 7, 6, 3 };
    int n = arr.length;
    repetAndMissingUsingMapping(arr);
    repetAndMissingUsingBit(arr, n);
  }

}
