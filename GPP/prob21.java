public class prob21 {
    static void permutation(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String ros = s.substring(0, i) + s.substring(i + 1);
            permutation(ros, ans + ch);
        }
    }

    // count the number of paths possi le from start point to end point in gameboard
    // and number of steps to taken is decided by die
    static int countPath(int s, int e) {
        if (s == e) {
            return 1;

        }
        if (s > e) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= 6; i++) {
            count += countPath(s + i, e);
        }
        return count;
    }

    static int countmazePath(int n, int i, int j) {
        if (i == n - 1 && j == n - 1) {
            return 1;
        }
        if (i >= n || j >= n) {
            return 0;
        }

        return countmazePath(n, i + 1, j) + countmazePath(n, i, j + 1);
    }

    // tilling problem
    // given "2 x n" board and tiles of size "2 X 1" count the number of ways to
    // tile the given board using these tiles

    static int tilling(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return tilling(n - 1) + tilling(n - 2);
    }

    // freind pairing problem
    // find the number of ways in which n friends can remain single or can be paired
    // up
    static int freindPair(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }

        return freindPair(n - 1) + (n - 1) * freindPair(n - 2);
    }

    // 0/1 knpsack problem
    static int knapsack(int value[], int wt[], int n, int W) {

        if (n == 0 || W == 0) {
            return 0;
        }
        if (wt[n - 1] > W) {
            return 1;
        }
        return Math.max(knapsack(value, wt, n - 1, W - wt[n - 1]) + value[n - 1], knapsack(value, wt, n - 1, W));
    }

    public static void main(String arg[]) {
        // permutation("ABC", "");
        // System.out.println(countPath(0, 3));
        // System.out.println(countmazePath(3, 0, 0));
        System.out.println(tilling(3));
        // System.out.println(freindPair(3));
        // int wt[] = {10,20,30};
        // int value[] ={100,50,150};
        // int W = 50;
        // System.out.println(knapsack(value, wt, 3, W));

    }
}
