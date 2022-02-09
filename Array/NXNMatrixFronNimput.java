/**
 * Construct a unique matrix n x n for an input n
 * 
 * Given an odd integer n, find a matrix of size n x n with following
 * conditions:
 * 
 * Each cell contains an integer from 1 and n (inclusive). No integer appears
 * twice in the same row or the same column. All 1’s must be at every possible
 * distance from the center of the matrix. The center of a n x n square is cell
 * ((n-1)/2, (n-1)/2) for odd n.
 * 
 * Input : n = 3 Output: 3 2 1 .1 3 2. 2 1 3
 * 
 * 
 */

public class NXNMatrixFronNimput {
    public static int MAX = 100;
    static int[][] mat = new int[MAX][MAX];

    static void fillRemaining(int i, int j, int n) {

        int x = 2;

        for (int k = i + 1; k < n; k++)
            mat[k][j] = x++;

        for (int k = 0; k < i; k++)
            mat[k][j] = x++;
    }

    static void constructMatrix(int n) {
        // Alternatively fill 1s starting from
        // rightmost and leftmost columns. For
        // example for n = 3, we get { {_ _ 1},
        // {1 _ _} {_ 1 _}}
        int right = n - 1, left = 0;
        for (int i = 0; i < n; i++) {
            // If i is even, then fill
            // next column from right
            if (i % 2 == 0) {
                mat[i][right] = 1;

                // After filling 1, fill remaining
                // entries of column "right"
                fillRemaining(i, right, n);

                // Move right one column back
                right--;
            }

            // Fill next column from left
            else {
                mat[i][left] = 1;

                // After filling 1, fill remaining
                // entries of column "left"
                fillRemaining(i, left, n);

                // Move left one column forward
                left++;
            }
        }
    }

    public static void main(String arg[]){
        int n =5;
        constructMatrix(n);
        for (int i = 0; i < n; i++)
        {
            for (int j = 0 ; j < n; j++)
            System.out.print(mat[i][j]+" ");
            System.out.println();
        }
    }
}
