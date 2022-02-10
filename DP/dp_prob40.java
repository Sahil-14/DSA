
/**
 * Date 12/22/2015
 * 
 * @author Tushar Roy
 *
 *         Given stockc prices for certain days and at most k transactions how
 *         to buy and sell
 *         to maximize profit.
 *
 *         Time complexity - O(number of transactions * number of days)
 *         Space complexity - O(number of transcations * number of days)
 *
 *         https://leetcode.com/discuss/15153/a-clean-dp-solution-which-generalizes-to-k-transactions
 */
import java.util.*;

public class dp_prob40 {
  public int maxProfit(int prices[], int k) {
    if (k == 0 || prices.length == 0) {
      return 0;
    }
    int T[][] = new int[k + 1][prices.length];

    for (int i = 1; i < T.length; i++) {
      int maxDiff = -prices[0];
      for (int j = 1; j < T[0].length; j++) {
        T[i][j] = Math.max(T[i][j - 1], prices[j] + maxDiff);
        maxDiff = Math.max(maxDiff, T[i - 1][j] - prices[j]);
      }
    }
    // printActualSolution(T, prices);
    return T[k][prices.length - 1];
  }

  /**
   * This is slow method but easier to understand.
   * Time complexity is O(k * number of days ^ 2)
   * T[i][j] = max(T[i][j-1], max(prices[j] - prices[m] + T[i-1][m])) where m is
   * 0...j-1
   */
  public int maxProfitSlowSolution(int prices[], int K) {
    if (K == 0 || prices.length == 0) {
      return 0;
    }
    int T[][] = new int[K + 1][prices.length];

    for (int i = 1; i < T.length; i++) {
      for (int j = 1; j < T[0].length; j++) {
        int maxVal = 0;
        for (int m = 0; m < j; m++) {
          maxVal = Math.max(maxVal, prices[j] - prices[m] + T[i - 1][m]);
        }
        T[i][j] = Math.max(T[i][j - 1], maxVal);
      }
    }
    printActualSolution(T, prices);
    return T[K][prices.length - 1];
  }

  static int maxProfitt(int prices[], int size) {

    // maxProfit adds up the difference between
    // adjacent elements if they are in increasing order
    int maxProfit = 0;

    // The loop starts from 1
    // as its comparing with the previous
    for (int i = 1; i < size; i++)
      if (prices[i] > prices[i - 1])
        maxProfit += prices[i] - prices[i - 1];
    return maxProfit;
  }

  // use this
  static int maxProfit(int price[],
      int n, int k) {

    // table to store results of subproblems
    // profit[t][i] stores maximum profit
    // using atmost t transactions up to day
    // i (including day i)
    int profit[][] = new int[k + 1][n + 1];

    // For day 0, you can't earn money
    // irrespective of how many times you trade
    for (int i = 0; i <= k; i++)
      profit[i][0] = 0;

    // profit is 0 if we don't do any
    // transaction (i.e. k =0)
    for (int j = 0; j <= n; j++)
      profit[0][j] = 0;

    // fill the table in bottom-up fashion
    for (int i = 1; i <= k; i++) {
      int prevDiff = Integer.MIN_VALUE;
      for (int j = 1; j < n; j++) {
        prevDiff = Math.max(prevDiff,
            profit[i - 1][j - 1] -
                price[j - 1]);
        profit[i][j] = Math.max(profit[i][j - 1],
            price[j] + prevDiff);
      }
    }

    return profit[k][n - 1];
  }

  public void printActualSolution(int T[][], int prices[]) {
    int i = T.length - 1;
    int j = T[0].length - 1;

    Deque<Integer> stack = new LinkedList<>();
    while (true) {
      if (i == 0 || j == 0) {
        break;
      }
      if (T[i][j] == T[i][j - 1]) {
        j = j - 1;
      } else {
        stack.addFirst(j);
        int maxDiff = T[i][j] - prices[j];
        for (int k = j - 1; k >= 0; k--) {
          if (T[i - 1][k] - prices[k] == maxDiff) {
            i = i - 1;
            j = k;
            stack.addFirst(j);
            break;
          }
        }
      }
    }

    while (!stack.isEmpty()) {
      System.out.println("Buy at price " + prices[stack.pollFirst()]);
      System.out.println("Sell at price " + prices[stack.pollFirst()]);
    }

  }

  public static void main(String[] args) {
    dp_prob40 sbt = new dp_prob40();
    int prices[] = { 2, 5, 7, 1, 4, 3, 1, 3 };

    System.out.println("Max profit fast solution " + sbt.maxProfit(prices, 3));
    // System.out.println("Max profit slow solution " +
    // sbt.maxProfitSlowSolution(prices, 3));
  }
}
