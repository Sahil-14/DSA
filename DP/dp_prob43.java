public class dp_prob43 {
  static int collectGold(int[][] gold, int x, int y,
      int n, int m, int[][] dp) {

    // Base condition.
    if ((x < 0) || (x == n) || (y == m)) {
      return 0;
    }

    if (dp[x][y] != -1) {
      return dp[x][y];
    }
    int rightUpperDiagonal = collectGold(gold, x - 1, y + 1, n, m, dp);
    // right
    int right = collectGold(gold, x, y + 1, n, m, dp);
    // Lower right diagonal
    int rightLowerDiagonal = collectGold(gold, x + 1, y + 1, n, m, dp);

    // Return the maximum and store the value
    return gold[x][y]
        + Math.max(Math.max(rightUpperDiagonal,
            rightLowerDiagonal),
            right);
  }

  static int getMaxGold(int[][] gold, int n, int m) {
    int maxGold = 0;
    int[][] dp = new int[n][m];
    for (int row = 0; row < n; row++) {
      Arrays.fill(dp[row], -1);
    }
    for (int i = 0; i < n; i++) {

      // Recursive function call for ith row.
      int goldCollected = collectGold(gold, i, 0, n, m, dp);
      maxGold = Math.max(maxGold, goldCollected);
    }

    return maxGold;
  }

  public static void main(String[] args) {
    int[][] gold = { { 1, 3, 1, 5 },
        { 2, 2, 4, 1 },
        { 5, 0, 2, 3 },
        { 0, 6, 1, 2 } };
    int m = 4, n = 4;
    System.out.println(getMaxGold(gold, n, m));
  }
}
