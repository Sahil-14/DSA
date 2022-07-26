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

    public int maxValBOtotmup(int price[], int len) {
        int T[][] = new int[price.length + 1][len + 1];
        for (int i = 0; i < T[0].length; i++) {
            T[0][i] = 0;
        }
        for (int i = 0; i < T.length; i++) {
            T[i][0] = 0;
        }
        for (int i = 1; i <= price.length; i++) {
            for (int j = 1; j <= len; j++) {
                if (j - i >= 0) {
                    T[i][j] = Integer.max(T[i - 1][j], T[i][j - i] + price[i - 1]);
                } else {
                    T[i][j] = T[i - 1][j];
                }
            }
        }
        for (int i = 0; i <= price.length; i++) {
            for (int j = 0; j <= len; j++) {
                System.out.print(T[i][j] + " ");
            }
            System.out.println();
        }
        return T[price.length][len];
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
