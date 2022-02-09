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

    public static void main(String arg[]) {
        int a[][] = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 23, 4, 56, 34, 22 },
                { 21, 32, 43, 54, 65 } };

                spiralPrint(a, 5, 5);
    }
}
