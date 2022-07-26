import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * Minimum Cost to cut a board into squares
 * 
 * 
 * For above board optimal way to cut into square is:
 * Total minimum cost in above case is 42. It is
 * evaluated using following steps.
 * 
 * Initial Value : Total_cost = 0
 * Total_cost = Total_cost + edge_cost * total_pieces
 * 
 * Cost 4 Horizontal cut Cost = 0 + 4*1 = 4
 * Cost 4 Vertical cut Cost = 4 + 4*2 = 12
 * Cost 3 Vertical cut Cost = 12 + 3*2 = 18
 * Cost 2 Horizontal cut Cost = 18 + 2*3 = 24
 * Cost 2 Vertical cut Cost = 24 + 2*3 = 30
 * Cost 1 Horizontal cut Cost = 30 + 1*4 = 34
 * Cost 1 Vertical cut Cost = 34 + 1*4 = 38
 * Cost 1 Vertical cut Cost = 38 + 1*4 = 42
 */

public class prob17 {
  // m*n squares
  static int minimumCostOfBreaking(Integer X[], Integer Y[],
      int m, int n) {
    int res = 0;
    Arrays.sort(X, Collections.reverseOrder());
    Arrays.sort(Y, Collections.reverseOrder());

    // initialize current width as 1
    int hzntl = 1, vert = 1;

    int i = 0, j = 0;

    while (i < m && j < n) {
      if (X[i] > Y[j]) {
        res += X[i] * vert;
        // increase current horizontal
        // part count by 1
        hzntl++;
        i++;
      } else {
        res += Y[j] * hzntl;
        // increase current vertical
        // part count by 1
        vert++;
        j++;
      }
    }
    // loop for horizontal array,
    // if remains
    int total = 0;
    while (i < m)
      total += X[i++];
    res += total * vert;

    // loop for vertical array,
    // if remains
    total = 0;
    while (j < n)
      total += Y[j++];
    res += total * hzntl;

    return res;
  }

  // Driver program
  public static void main(String arg[]) {
    int m = 6, n = 4;
    Integer X[] = { 2, 1, 3, 1, 4 };
    Integer Y[] = { 4, 1, 2 };
    System.out.print(minimumCostOfBreaking(X, Y, m - 1, n - 1));
  }
}
