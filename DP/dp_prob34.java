// total number way of path from top left to bottom right;
public class dp_prob34 {
    public int countPaths(int n, int m) {
        int T[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            T[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            T[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                T[i][j] = T[i - 1][j] + T[i][j - 1];
            }
        }
        return T[n - 1][m - 1];
    }

    public static void main(String[] args) {
        dp_prob34 ob = new dp_prob34();
        System.out.print(ob.countPaths(4, 4));

    }
}
