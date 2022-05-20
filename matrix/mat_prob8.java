// zig-zag traversal
/**
 * 
 * 
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 17 18 19 20
 * 
 * 
 * 1
 * 5 2
 * 9 6 3
 * 13 10 7 4
 * 17 14 11 8
 * 18 15 12
 * 19 16
 * 20
 * 
 */
public class mat_prob8 {
  static final int ROW = 5;
  static final int COL = 4;

  // A utility function to find min
  // of two integers
  static int min(int a, int b) {
    return (a < b) ? a : b;
  }

  // A utility function to find min
  // of three integers
  static int min(int a, int b, int c) {
    return min(min(a, b), c);
  }

  // A utility function to find max
  // of two integers
  static int max(int a, int b) {
    return (a > b) ? a : b;
  }

  static void digonalOrder(int matrix[][]) {
    for (int line = 1; line <= (ROW + COL - 1); line++) {
      // Get column index of the first
      // element in this line of output.
      // The index is 0 for first ROW
      // lines and line - ROW for remaining lines
      int start_col = max(0, line - ROW);
      // Get count of elements in this line.
      // The count of elements is equal to
      // minimum of line number, COL-start_col and ROW
      int count = min(line, (COL - start_col),
          ROW);
      // Print elements of this line
      for (int j = 0; j < count; j++)
        System.out.print(
            matrix[min(ROW, line) - j - 1][start_col + j]
                + " ");

      // Print elements of next diagonal on next line
      System.out.println();
    }
  }
}
