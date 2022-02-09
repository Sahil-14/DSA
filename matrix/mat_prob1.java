public class mat_prob1 {

  // Function print matrix in spiral form
  static void spiralPrint(int m, int n, int a[][]) {
    int i, row_start = 0, col_start = 0;
    int row_end = m, col_end = n;
   
    while (row_start < row_end && col_start < col_end) {
      // Print the first row from the remaining rows
      for (i = col_start; i < col_end; ++i) {
        System.out.print(a[row_start][i] + " ");
      }
      row_start++;

      // Print the last column from the remaining
      // columns
      for (i = row_start; i < row_end; ++i) {
        System.out.print(a[i][col_end - 1] + " ");
      }
      col_end--;

      // Print the last row from the remaining rows */
      if (row_start < row_end) {
        for (i = col_end - 1; i >= col_start; --i) {
          System.out.print(a[row_end - 1][i] + " ");
        }
        row_end--;
      }

      // Print the first column from the remaining
      // columns */
      if (col_start < col_end) {
        for (i = row_end - 1; i >= row_start; --i) {
          System.out.print(a[i][col_start] + " ");
        }
        col_start++;
      }
    }
  }

  public static void main(String[] args) {
    int R = 3;
    int C = 6;
    int a[][] = { { 1, 2, 3, 4, 5, 6 },
        { 7, 8, 9, 10, 11, 12 },
        { 13, 14, 15, 16, 17, 18 } };
    spiralPrint(R, C, a);
  }

}
