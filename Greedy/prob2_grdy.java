import java.util.Vector;

/**
 * 
 * Given a value V, if we want to make a change for V Rs, and we have an
 * infinite supply of each of the denominations in Indian currency, i.e., we
 * have an infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued
 * coins/notes, what is the minimum number of coins and/or notes needed to make
 * the change?
 *
 * 
 * Input: V = 70
 * Output: 2
 * We need a 50 Rs note and a 20 Rs note.
 * 
 * Input: V = 121
 * Output: 3
 * We need a 100 Rs note, a 20 Rs note and a 1 Rs coin.
 * 
 * 
 * 
 * Sort the array of coins in decreasing order.
 * Initialize result as empty.
 * Find the largest denomination that is smaller than current amount.
 * Add found denomination to result. Subtract value of found denomination from
 * amount.
 * If amount becomes 0, then print result.
 * Else repeat steps 3 and 4 for new value of V.
 * 
 * 
 */

public class prob2_grdy {
  // All denominations of Indian Currency
  static int deno[] = { 1, 2, 5, 10, 20,
      50, 100, 500, 1000 };
  static int n = deno.length;

  static void findMin(int v) {
    Vector<Integer> ans = new Vector<>();
    for (int i = n - 1; i >= 0; i--) {
      while (v >= deno[i]) {
        v -= deno[i];
        ans.add(deno[i]);
      }
    }

    // Print result
    for (int i = 0; i < ans.size(); i++) {
      System.out.print(
          " " + ans.elementAt(i));
    }
  }

  // Driver code
  public static void main(String[] args) {
    int n = 1500;
    System.out.print(
        "Following is minimal number "
            + "of change for " + n + ": ");
    findMin(n);
  }

}
