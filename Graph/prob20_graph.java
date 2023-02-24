/**
 * Find the number of islands | ( DFS)
 * 
 * Input : mat[][] = {{1, 1, 0, 0, 0},
 * {0, 1, 0, 0, 1},
 * {1, 0, 0, 1, 1},
 * {0, 0, 0, 0, 0},
 * {1, 0, 1, 0, 1}}
 * Output : 5
 * 
 */
public class prob20_graph {
  static final int ROW = 5, COL = 5;

  boolean isSafe(int M[][], int row, int col,
      boolean visited[][]) {
    // row number is in range, column number is in range
    // and value is 1 and not yet visited
    return (row >= 0) && (row < ROW) && (col >= `0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]);
  }

  void DFS(int M[][], int row, int col, boolean visited[][]) {
    // These arrays are used to get row and column numbers
    // of 8 neighbors of a given cell
    int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
    int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
   
    // Mark this cell as visited
    visited[row][col] = true;

    // Recur for all connected neighbours
    for (int k = 0; k < 8; ++k)
      if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
        DFS(M, row + rowNbr[k], col + colNbr[k], vis ited);
  }

  int countIslands(int M[][]) {
    // Make a bool array to mark visited cells.
    // Initially all cells are unvisited
    boolean visited[][] = new boolean[ROW][COL];

    // Initialize count as 0 and traverse through the all cells
    // of given matrix
    int count = 0;
    for (int i = 0; i < ROW; ++i)
      for (int j = 0; j < COL; ++j)
        if (M[i][j] == 1 && !visited[i][j]) // If a cell with
        { // value 1 is not
          // visited yet, then new island found, Visit all
          // cells in this island and increment island count
          DFS(M, i, j, visited);
          ++count;
        }

    return count;
  }

  public static void main(String[] args) throws java.lang.Exception {
    int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
        { 0, 1, 0, 0, 1 },
        { 1, 0, 0, 1, 1 },
        { 0, 0, 0, 0, 0 },
        { 1, 0, 1, 0, 1 } };
    prob20_graph I = new prob20_graph();
    System.out.println("Number of islands is: " + I.countIslands(M));
  }
}
