// minimum cost path
//given a matrix and a start point and end point what is the minimum cost ot reach from start to end;
public class dp_prob23 {
    public int minCost(int cost[][]) {
        int m = cost.length;
        int n = cost[0].length;
        int[][] T = new int[m][n];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            T[i][0] = sum + cost[i][0];
            sum = T[i][0];
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            T[0][i] = sum + cost[0][i];
            sum = T[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                T[i][j] = cost[i][j] + Math.min(T[i - 1][j], T[i][j - 1]);// if only right and bottom move allow
            }
        }
        path(T, cost, m - 1, n - 1);
        System.out.println();
        return T[m - 1][n - 1];

    }

    public void path(int T[][], int val[][], int i, int j) {
        if (i == 0 && j == 0) {
            System.out.print(T[0][0] + " ");
            return;
        }
        if (i > 0 && (T[i][j] - val[i][j] == T[i - 1][j])) {
            path(T, val, i - 1, j);
        } else if (j > 0 && (T[i][j] - val[i][j] == T[i][j - 1])) {
            path(T, val, i, j - 1);
        }
        System.out.print(T[i][j] + " ");
    }

    public static void main(String[] args) {
        dp_prob23 mcp = new dp_prob23();
        int cost[][] = { { 1, 3, 5, 8 }, { 4, 2, 1, 7 }, { 4, 3, 2, 3 } };
        int result = mcp.minCost(cost);
        System.out.println(result);
    }
}
