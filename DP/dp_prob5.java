/* Given a total and coins of certain denomination with infinite supply, what is the minimum number
 * of coins it takes to form this total.
*/
public class dp_prob5 {
    public int minmumCoinBottomUp(int total, int coins[]) {
        int T[] = new int[total + 1];
        int R[] = new int[total + 1];
        T[0] = 0;
        for (int i = 1; i <= total; i++) {
            T[i] = Integer.MAX_VALUE - 1;
            R[i] = -1;
        }
        for (int j = 0; j < coins.length; j++) {
            for (int i = 1; i <= total; i++) {
                if (i >= coins[j]) {
                    if (T[i] > 1 + T[i - coins[j]]) {
                        T[i] = 1 + T[i - coins[j]];
                        R[i] = j;
                    }
                }
            }
        }
        return T[total];
    }

    public int minCoin(int total, int coins[]) {
        int t[][] = new int[coins.length + 1][total + 1];
        for (int i = 0; i <= coins.length; i++)
            t[i][0] = 0;
        for (int k = 0; k <= total; k++)
            t[0][k] = Integer.MAX_VALUE - 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j - coins[i - 1] >= 0) {
                    t[i][j] = Math.min(t[i - 1][j], 1 + t[i][j - coins[i - 1]]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[coins.length][total];
    }

    public static void main(String arg[]) {
        int total = 11;
        int coins[] = { 1, 5, 6, 8 };
        dp_prob5 ob = new dp_prob5();
        // int bottomUpValue = ob.minmumCoinBottomUp(total, coins);
        int ans = ob.minCoin(total, coins);
        System.out.println(ans);
    }
}

/// as problem is of minimization type initialize first row by +infinity
/// when we have take minimum value of previous iteration and current calculated
/// value we can use space efficient solution