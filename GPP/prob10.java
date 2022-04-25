// Print matrix in spiral Order
public class prob10 {
    static void spiralPrint(int a[][], int n, int m) {
        int row_start = 0;
        int col_start = 0;
        int row_end = n - 1;
        int col_end = m - 1;

        while (row_start <= row_end && col_start <= col_end) {
            for (int col = col_start; col <= col_end; col++) {
                System.out.println(a[row_start][col]);
            }
            row_start++;
            for (int row = row_start; row <= row_end; row++) {
                System.out.println(a[row][col_end]);
            }
            col_end--;
            for (int col = col_end; col >= col_start; col--) {
                System.out.println(a[row_end][col]);

            }
            row_end--;
            for (int row = row_end; row >= row_start; row--) {
                System.out.println(a[row][col_start]);
            }
            col_start++;
        }
    }

    static void spiralPrint(int m, int n, int a[][]) {
        int i, k = 0, l = 0;

        /*
         * k - starting row index
         * m - ending row index
         * l - starting column index
         * n - ending column index
         * i - iterator
         */

        while (k < m && l < n) {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i) {
                System.out.print(a[k][i] + " ");
            }
            k++;

            // Print the last column from the remaining
            // columns
            for (i = k; i < m; ++i) {
                System.out.print(a[i][n - 1] + " ");
            }
            n--;

            // Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    System.out.print(a[m - 1][i] + " ");
                }
                m--;
            }

            // Print the first column from the remaining
            // columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    System.out.print(a[i][l] + " ");
                }
                l++;
            }
        }
    }

    public static void main(String arg[]) {
        int a[][] = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 23, 4, 56, 34, 22 },
                { 21, 32, 43, 54, 65 } };

        spiralPrint(a, 5, 5);
    }
}
