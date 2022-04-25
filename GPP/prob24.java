//N-queen
public class prob24 {
    static boolean isSafe(int arr[][], int x, int y, int n) {
        // check for row
        for (int row = 0; row < x; row++) {
            if (arr[row][y] == 1) {
                return false;
            }
        }

        // check for left diagonal
        int row = x;
        int col = y;
        while (row >= 0 && col >= 0) {
            if (arr[row][col] == 1) {
                return false;
            }
            row--;
            col--;
        }
        // check for right diagonal
        row = x;
        col = y;
        while (row >= 0 && col < n) {
            if (arr[row][col] == 1) {
                return false;
            }
            row--;
            col++;
        }
        return true;
    }

    static boolean nQueen(int arr[][], int x, int n) {
        if (x >= n) {
            return true;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(arr, x, col, n)) {
                arr[x][col] = 1;
                if (nQueen(arr, x + 1, n)) {
                    return true;
                }
            }

            arr[x][col] = 0; // backtracking
        }
        return false;
    }

    public static void main(String arg[]) {
        int arr[][] = new int[6][6];
        if (nQueen(arr, 0, 6)) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }

    }
}
