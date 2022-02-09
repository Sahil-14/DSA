
//Given an n x n matrix and a number x, find the position of x in the matrix if it is present in it.
// Otherwise, print “Not Found”. In the given matrix, every row and column is sorted in increasing order.//
// The designed algorithm should have linear time complexity. 

public class mat_prob2 {
  static boolean search(int[][] matrix, int target) {
    int rl = matrix.length;
    int cl = matrix[0].length;
    if (rl == 0 || cl == 0) {
      return false;
    }

    int i = 0, j = cl - 1;
    while (i < rl && j >= 0) {
      if (matrix[i][j] == target) {
        return true;
      } else if (matrix[i][j] < target) {
        i++;
      } else {
        j--;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int mat[][] = { { 10, 20, 30, 40 },
        { 15, 25, 35, 45 },
        { 27, 29, 37, 48 },
        { 32, 33, 39, 50 } };

    System.out.println(search(mat, 9));
  }
}
