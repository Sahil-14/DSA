public class prob13_graph {
  public static int M = 8;
  public static int N = 8;

  static void floddFillUitl(int screen[][], int x, int y, int prevC, int newC) {
    // check whether bruch is insicde screen
    if (x < 0 || x >= M || y < 0 || y >= N)
      return;
    // check whether adjecent color is same
    if (screen[x][y] != prevC)
      return;
    screen[x][y] = newC;
    int xP[] = { 0, 0, 1, -1 };
    int yP[] = { -1, 1, 0, 0 };

    for (int i = 0; i < 4; i++)
      floddFillUitl(screen, x + xP[i], y + yP[i], prevC, newC);
  }

  static void floodFill(int[][] screen, int x, int y, int newC) {
    int currC = screen[x][y];
    if (currC == newC)
      return;
    floddFillUitl(screen, x, y, currC, newC);
  }

  public static void main(String[] args) {

    int screen[][] = { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0 }, { 1, 0, 0, 1, 1, 0, 1, 1 },
        { 1, 2, 2, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 2, 2, 0 },
        { 1, 1, 1, 1, 1, 2, 1, 1 }, { 1, 1, 1, 1, 1, 2, 2, 1 }, };
    int x = 4, y = 4, newC = 3;
    floodFill(screen, x, y, newC);
    System.out.println("Updated screen after call to floodFill: ");
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++)
        System.out.print(screen[i][j] + " ");
      System.out.println();
    }
  }
}
