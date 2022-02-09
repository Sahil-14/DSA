//Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s. 
public class mat_prob4 {
  static int rowWithmax1s(int mat[][], int r, int c) {
    int j, max_row_index = 0;
    j = c - 1;
    for (int i = 0; i < r; i++) {
      while (j >= 0 && mat[i][j] == 1) {
        j = j - 1;
        max_row_index = i;
      }
    }
    if (max_row_index == 0 && mat[0][c - 1] == 0) {
      return -1;
    }
    return max_row_index;
  }

  public static void main(String[] args) {
    int mat[][] = { { 1, 0, 0, 0 },
        { 0, 1, 1, 0 },
        { 1, 0, 0, 0 },
        { 0, 0, 0, 0 } };
    System.out.println(rowWithmax1s(mat, 4, 4));
  }
}
