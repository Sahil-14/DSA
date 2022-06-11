import java.util.*;

/**
 * Distance of nearest cell having 1 in a binary matrix
 * Given a binary matrix of N x M, containing at least a value 1. The task is to
 * find the distance of nearest 1 in the matrix for each cell. The distance is
 * calculated as |i1 – i2| + |j1 – j2|, where i1, j1 are the row number and
 * column number of the current cell and i2, j2 are the row number and column
 * number of the nearest cell having value 1.
 * 
 * 
 * 
 * Input : N = 3, M = 4
 * mat[][] = { 0, 0, 0, 1,
 * 0, 0, 1, 1,
 * 0, 1, 1, 0 }
 * Output : 3 2 1 0
 * 2 1 0 0
 * 1 0 0 1
 * Explanation:
 * For cell at (0, 0), nearest 1 is at (0, 3),
 * so distance = (0 - 0) + (3 - 0) = 3.
 * Similarly, all the distance can be calculated.
 * 
 * Input : N = 3, M = 3
 * mat[][] = { 1, 0, 0,
 * 0, 0, 1,
 * 0, 1, 1 }
 * Output :
 * 0 1 1
 * 1 1 0
 * 1 0 0
 * Explanation:
 * For cell at (0, 1), nearest 1 is at (0, 0), so distance
 * is 1. Similarly, all the distance can be calculated.
 * 
 * 
 * 
 */

public class prob27 {

  // method 1 :o(n2*m2)
  private static void minimumDistance1(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    int[][] ans = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int minDist = Integer.MAX_VALUE;
        for (int x = 0; x < n; x++) {
          for (int y = 0; y < m; y++) {
            if (matrix[x][y] == 1) {
              int dist = Math.abs(x - i) + Math.abs(y - j);
              minDist = Math.min(minDist, dist);
            }
          }
        }
        ans[i][j] = minDist;
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(ans[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  // method 2: bfs
  /**
   * Time Complexity = O(n * m)
   * Space Complexity = O(n * m)
   * 
   */
  static class Coordinate {
    int row;
    int col;

    public Coordinate(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  private static void minimumDistance(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    // create an array ans of size same as matrix array
    int ans[][] = new int[n][m];
    // create a queue of coordinates
    // push all the elements that are equals to 1 in the matrix array to the queue
    Queue<Coordinate> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == 1) {
          queue.add(new Coordinate(i, j));
        }
      }
    }
    // initialize minDistance as 0
    int minDistance = 0;
    while (!queue.isEmpty()) {
      // initialize size as size of queue
      int size = queue.size();
      // Run a loop size times
      for (int i = 0; i < size; i++) {
        // remove an element from queue
        Coordinate curr = queue.poll();
        // ans to this coordinate is minDistance
        ans[curr.row][curr.col] = minDistance;
        // enqueue all the valid adjacent cells of curr that are equals to
        // 0 in the matrix array and set them as 1
        // left adjacent
        int leftRow = curr.row - 1;
        int leftCol = curr.col;
        if ((leftRow >= 0 && leftRow < n) && (leftCol >= 0 && leftCol < m)) {
          if (matrix[leftRow][leftCol] == 0) {
            queue.add(new Coordinate(leftRow, leftCol));
            matrix[leftRow][leftCol] = 1;
          }
        }
        // right adjacent
        int rightRow = curr.row + 1;
        int rightCol = curr.col;
        if ((rightRow >= 0 && rightRow < n) && (rightCol >= 0 && rightCol < m)) {
          if (matrix[rightRow][rightCol] == 0) {
            queue.add(new Coordinate(rightRow, rightCol));
            matrix[rightRow][rightCol] = 1;
          }
        }
        // up adjacent
        int upRow = curr.row;
        int upCol = curr.col + 1;
        if ((upRow >= 0 && upRow < n) && (upCol >= 0 && upCol < m)) {
          if (matrix[upRow][upCol] == 0) {
            queue.add(new Coordinate(upRow, upCol));
            matrix[upRow][upCol] = 1;
          }
        }
        // down adjacent
        int downRow = curr.row;
        int downCol = curr.col - 1;
        if ((downRow >= 0 && downRow < n) && (downCol >= 0 && downCol < m)) {
          if (matrix[downRow][downCol] == 0) {
            queue.add(new Coordinate(downRow, downCol));
            matrix[downRow][downCol] = 1;
          }
        }
      }
      // increment minimum distance
      minDistance++;
    }
    // print the elements of the ans array
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(ans[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    // Example 1
    int matrix1[][] = new int[][] {
        { 0, 1, 0 },
        { 0, 0, 0 },
        { 1, 0, 0 }
    };
    minimumDistance(matrix1);
    // Example 2
    int matrix2[][] = new int[][] {
        { 0, 0, 0 },
        { 0, 0, 0 },
        { 1, 0, 1 }
    };
    minimumDistance(matrix2);
  }

}