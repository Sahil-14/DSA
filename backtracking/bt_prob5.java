/**
 * find logest path in maze
 * 
 */

class bt_prob5 {
  private static boolean isSafe(int[][] mat, boolean[][] visited, int x, int y) {
    return (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length) &&
        mat[x][y] == 1 && !visited[x][y];
  }

  public static int findLongestPath(int mat[][], boolean[][] visited, int i, int j, int x, int y, int max_dist,
      int dist) {

    if (mat[i][j] == 0) {
      return 0;
    }

    // base condition
    if (i == x && j == y) {
      return Math.max(dist, max_dist);
    }
    visited[i][j] = true;

    // go to the bottom cell
    if (isSafe(mat, visited, i + 1, j)) {
      max_dist = findLongestPath(mat, visited, i + 1, j, x, y,
          max_dist, dist + 1);
    }

    // go to the right cell
    if (isSafe(mat, visited, i, j + 1)) {
      max_dist = findLongestPath(mat, visited, i, j + 1, x, y,
          max_dist, dist + 1);
    }

    // go to the top cell
    if (isSafe(mat, visited, i - 1, j)) {
      max_dist = findLongestPath(mat, visited, i - 1, j, x, y,
          max_dist, dist + 1);
    }

    // go to the left cell
    if (isSafe(mat, visited, i, j - 1)) {
      max_dist = findLongestPath(mat, visited, i, j - 1, x, y,
          max_dist, dist + 1);
    }

    // backtrack: remove (i, j) from the visited matrix
    visited[i][j] = false;

    return max_dist;

  }

  public static int findLongestPathLength(int[][] mat, int i, int j, int x, int y) {
    // base case: invalid input
    if (mat == null || mat.length == 0 || mat[i][j] == 0 || mat[x][y] == 0) {
      return -1;
    }

    // `M × N` matrix
    int M = mat.length;
    int N = mat[0].length;

    // construct an `M × N` matrix to keep track of visited cells
    boolean[][] visited = new boolean[M][N];

    // (i, j) are the source cell, and (x, y) are the destination
    // cell coordinates
    return findLongestPath(mat, visited, i, j, x, y, 0, 0);
  }

  public static void main(String[] args) {
    // input matrix
    int mat[][] = {
        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
        { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
        { 1, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
        { 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
        { 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
        { 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
        { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }
    };

    // (0, 0) are the source cell, and (5, 7) are the destination
    // cell coordinates
    int max_dist = findLongestPathLength(mat, 0, 0, 5, 7);
    System.out.println("The maximum length path is " + max_dist);
  }
}