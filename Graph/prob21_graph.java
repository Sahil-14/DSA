import java.util.Vector;

/**
 * Minimum steps to reach target by a Knight (BFS)
 * Given a square chessboard of N x N size, the position of Knight and position
 * of a target is given. We need to find out the minimum steps a Knight will
 * take to reach the target position.
 * 
 * 
 * 
 * 
 * This problem can be seen as shortest path in unweighted graph. Therefore we
 * use BFS to solve this problem. We try all 8 possible positions where a Knight
 * can reach from its position. If reachable position is not already visited and
 * is inside the board, we push this state into queue with distance 1 more than
 * its parent state. Finally we return distance of target position, when it gets
 * pop out from queue.
 * Below code implements BFS for searching through cells, where each cell
 * contains its coordinate and distance from starting node. In worst case, below
 * code visits all cells of board, making worst-case time complexity as O(N^2)
 * 
 * 
 */

public class prob21_graph {
  // Class for storing a cell's data
  static class cell {
    int x, y;
    int dis;

    public cell(int x, int y, int dis) {
      this.x = x;
      this.y = y;
      this.dis = dis;
    }
  }

  static boolean isInside(int x, int y, int N) {
    if (x >= 1 && x <= N && y >= 1 && y <= N)
      return true;
    return false;
  }

  static int minStepToReachTarget(
      int knightPos[], int targetPos[],
      int N) {
    int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
    int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

    Vector<cell> q = new Vector<>();
    q.add(new cell(knightPos[0], knightPos[1], 0));
    cell t;
    int x, y;
    boolean visit[][] = new boolean[N + 1][N + 1];

    // make all cell unvisited
    for (int i = 1; i <= N; i++)
      for (int j = 1; j <= N; j++)
        visit[i][j] = false;

    visit[knightPos[0]][knightPos[1]] = true;
    while (!q.isEmpty()) {
      t = q.firstElement();
      q.remove(0);

      // if current cell is equal to target cell,
      // return its distance
      if (t.x == targetPos[0] && t.y == targetPos[1])
        return t.dis;

      // loop for all reachable states
      for (int i = 0; i < 8; i++) {
        x = t.x + dx[i];
        y = t.y + dy[i];

        // If reachable state is not yet visited and
        // inside board, push that state into queue
        if (isInside(x, y, N) && !visit[x][y]) {
          visit[x][y] = true;
          q.add(new cell(x, y, t.dis + 1));
        }

      }
    }
    return Integer.MAX_VALUE;

  }

  // Driver code
  public static void main(String[] args) {
    int N = 30;
    int knightPos[] = { 1, 1 };
    int targetPos[] = { 30, 30 };
    System.out.println(
        minStepToReachTarget(
            knightPos, targetPos, N));
  }
}
