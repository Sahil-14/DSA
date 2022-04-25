// coin chainging minimum coins bottomup
public class dp_prob15 {
    public int minimumCoinBottomUp(int total, int coins[]) {
        int T[] = new int[total + 1];
        int R[] = new int[total + 1];

        T[0] = 0;
        for (int i = 1; i <= total; i++) {
            T[i] = Integer.MAX_VALUE - 1;
            R[i] = -1;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= total; j++) { 
                if (j >= coins[i]) {
                    if (T[j] > 1 + T[j - coins[i]]) {
                        T[j] = 1 + T[j - coins[i]];
                        R[j] = i;
                    }
                }
            }
        }
        printCombinations(R, coins);
        return T[total];
    }

   

    private void printCombinations(int R[], int coins[]) {
        if (R[R.length - 1] == -1) {
            System.out.println("No solutions possible");
            return;
        }
        int start = R.length - 1;
        System.out.println("Coins used to form total are : ");
        while (start != 0) {
            int j = R[start];
            System.out.print(coins[j] + " ");
            start -= coins[j];
        }
        System.out.println();
    }
    


    public static void main(String[] args) {
        int total = 13;
        int coins[] = { 7, 3, 2, 6 };
        dp_prob15 cc = new dp_prob15();
        int bottomup = cc.minimumCoinBottomUp(total, coins);
        System.out.println(bottomup);
    }
}
