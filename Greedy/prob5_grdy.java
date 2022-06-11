/**
 * You are given a list of N coins of different denominations. You can pay an
 * amount equivalent to any 1 coin and can acquire that coin. In addition, once
 * you have paid for a coin, we can choose at most K more coins and can acquire
 * those for free. The task is to find the minimum amount required to acquire
 * all the N coins for a given value of K.
 * 
 * 
 * 
 */

public class prob5_grdy {

  // Converts coin[] to prefix sum array
  static void preprocess(int[] coin, int n) {

    // sort the coins value
    Arrays.sort(coin);

    // Maintain prefix sum array
    for (int i = 1; i <= n - 1; i++)
      coin[i] += coin[i - 1];
  }

  // Function to calculate min cost when we
  // can get k extra coins after paying
  // cost of one.
  static int minCost(int[] coin, int n, int k) {

    // calculate no. of coins needed
    int coins_needed = (int) Math.ceil(1.0
        * n / (k + 1));

    // return sum of from prefix array
    return coin[coins_needed - 1];
  }

  // Driver Code
  static public void main(String[] args) {
    int[] coin = { 8, 5, 3, 10, 2, 1, 15, 25 };
    int n = coin.length;

    preprocess(coin, n);

    int k = 3;
    System.out.println(minCost(coin, n, k));

    k = 7;
    System.out.println(minCost(coin, n, k));
  }
}
