public class bt_prob1 {
  public static boolean isSafe(int arr[][], int x, int y, int n) {
    return x < n && y < n && arr[x][y] == 1;
  }

  public static boolean ratInMaze(int arr[][], int x, int y, int n, int sol[][]) {
    // base case
    if (x == n - 1 && y == n - 1) {
      return true;
    }

    if (isSafe(arr, x, y, n)) {
      sol[x][y] = 1;
      if (ratInMaze(arr, x + 1, y, n, sol)) {
        return true;
      }
      if (ratInMaze(arr, x, y + 1, n, sol)) {
        return true;
      }
      sol[x][y] = 0;
      return false;
    }

    return false;
  }

  public static void main(String[] args) {

    int arr[][] = {
        { 1, 0, 1, 0, 1 },
        { 1, 1, 1, 1, 1 },
        { 0, 1, 0, 1, 0 },
        { 1, 0, 0, 1, 1 },
        { 1, 1, 1, 0, 1 }
    };

    int sol[][] = new int[5][5];
    if (ratInMaze(arr, 0, 0, 5, sol)) {
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          System.out.print(sol[i][j] + " ");
        }
        System.out.println();
      }
    }
  }
}
