/**
 * Flood fill Algorithm – how to implement
 * 
 * 
 * In MS-Paint, when we take the brush to a pixel and click, the color of the
 * region of that pixel is replaced with a new selected color. Following is the
 * problem statement to do this task.
 * 
 * Given a 2D screen, location of a pixel in the screen and a color, replace
 * color of the given pixel and all adjacent same colored pixels with the given
 * color
 * 
 * Input:
 * screen[M][N] = {{1, 1, 1, 1, 1, 1, 1, 1},
 * {1, 1, 1, 1, 1, 1, 0, 0},
 * {1, 0, 0, 1, 1, 0, 1, 1},
 * {1, 2, 2, 2, 2, 0, 1, 0},
 * {1, 1, 1, 2, 2, 0, 1, 0},
 * {1, 1, 1, 2, 2, 2, 2, 0},
 * {1, 1, 1, 1, 1, 2, 1, 1},
 * {1, 1, 1, 1, 1, 2, 2, 1},
 * };
 * x = 4, y = 4, newColor = 3
 * The values in the given 2D screen
 * indicate colors of the pixels.
 * x and y are coordinates of the brush,
 * newColor is the color that
 * should replace the previous color on
 * screen[x][y] and all surrounding
 * pixels with same color.
 * 
 * Output:
 * Screen should be changed to following.
 * screen[M][N] = {{1, 1, 1, 1, 1, 1, 1, 1},
 * {1, 1, 1, 1, 1, 1, 0, 0},
 * {1, 0, 0, 1, 1, 0, 1, 1},
 * {1, 3, 3, 3, 3, 0, 1, 0},
 * {1, 1, 1, 3, 3, 0, 1, 0},
 * {1, 1, 1, 3, 3, 3, 3, 0},
 * {1, 1, 1, 1, 1, 3, 1, 1},
 * {1, 1, 1, 1, 1, 3, 3, 1},
 * };
 * 
 */

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
