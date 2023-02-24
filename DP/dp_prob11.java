// cutting rod problem
//
public class dp_prob11 {
    public int recursiveMaxValue(int price[], int len) {
        if (len <= 0) {
            return 0;
        }
        int maxValue = 0;
        for (int i = 0; i < len; i++) {
            int val = price[i] + recursiveMaxValue(price, len - i - 1);
            if (maxValue < val) {
                maxValue = val;
            }
        }

        return maxValue;
    }

    public int maxValue1(int price[]) {
        int max[] = new int[price.length + 1];
        for (int i = 1; i <= price.length; i++) {
            max[i] = price[i - 1];
        }
        for (int i = 1; i <= price.length; i++) {
            for (int j = 1; j < i; j++) {
                max[i] = Math.max(max[i], max[i - j] + max[j]);
            }
        }
        return max[price.length];
    }

    public static int cutRod(int prices[], int n) {

        int mat[][] = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    mat[i][j] = 0;
                } else {
                    if (i == 1) {
                        mat[i][j] = j * prices[i - 1];
                    } else {
                        if (i > j) {
                            mat[i][j] = mat[i - 1][j];
                        } else {
                            mat[i][j] = Math.max(
                                    prices[i - 1]
                                            + mat[i][j - i],
                                    mat[i - 1][j]);
                        }
                    }
                }
            }
        }

        return mat[n][n];
    }

    public static void main(String args[]) {
        dp_prob11 cr = new dp_prob11();
        int[] price = { 2, 5, 7, 8 };
        long t1 = System.currentTimeMillis();
        int r = cr.recursiveMaxValue(price, 4);
        long t2 = System.currentTimeMillis();
        System.out.println(r);
        System.out.println(cr.maxValBOtotmup(price, 5));
    }
}
