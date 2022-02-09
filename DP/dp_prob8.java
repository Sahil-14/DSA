// optimal binary search tree
/**
 * ]
 * 
 * given certail keys and freq at which this keys are search what kind of bst
 * would you create so that cost of searching is minimum
 */

public class dp_prob8 {
    public int minCost(int input[], int freq[]) {
        int T[][] = new int[input.length][input.length];

        for (int i = 0; i < input.length; i++) {
            T[i][i] = freq[i];
        }

        for (int l = 2; l <= input.length; l++) {
            for (int i = 0; i <= input.length - l; i++) {
                int j = i + l - 1;
                T[i][j] = Integer.MAX_VALUE;
                int sum = getSum(freq, i, j);
                // k represent the root
                for (int k = i; k <= j; k++) {
                    int val = sum + (k - 1 < i ? 0 : T[i][k - 1]) + (k + 1 > j ? 0 : T[k + 1][j]);
                    if (val < T[i][j]) {
                        T[i][j] = val;
                    }
                }
            }
        }
        return T[0][input.length - 1];
    }

    private int getSum(int freq[], int i, int j) {
        int sum = 0;
        for (int x = i; x <= j; x++) {
            sum += freq[x];
        }
        return sum;
    }

    public static void main(String[] args) {
        // int input[] = { 10, 12, 20, 35, 46 };
        int input[] = { 10, 12, 16, 25 };
        int freq[] = { 4, 2, 6, 3 };
        // int freq[] = { 34, 8, 50, 21, 16 };
        dp_prob8 ob = new dp_prob8();
        System.out.println(ob.minCost(input, freq));

    }
}

// note
// val = sum of 1 time freq from i to j + value of root from T[i][k-1] + val of
// root from T[k+1][j]