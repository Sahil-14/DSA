//stock busy sell to maximum profit
// Solution structure
class Interval {
  int buy, sell;
}

public class array_prob10 {
  public static int maxProfit(int prices[]) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minPrice) {
        minPrice = prices[i];
      } else if (prices[i] - minPrice > maxProfit) {
        maxProfit = prices[i] - minPrice;
      }
    }
    return maxProfit;
  }

  static int maxProfit(int prices[], int size) {

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

  void stockBuySell(int price[], int n) {
    if (n == 1) {
      return;
    }
    int count = 0;
    // solution array
    ArrayList<Interval> sol = new ArrayList<Interval>();
    // Traverse through given price array
    int i = 0;
    while (i < n - 1) {
      while ((i < n - 1) && price[i + 1] <= price[i]) {
        i++;
      }
      // If we reached the end, break as no further solution possible
      if (i == n - 1)
        break;
      Interval e = new Interval();
      e.buy = i++;
      while ((i < n) && price[i] >= price[i - 1]) {
        i++;
      }

      // Store the index of maxima
      e.sell = i - 1;
      sol.add(e);// Increment number of buy/sell
      count++;
    }

    // print solution
    if (count == 0)
      System.out.println("There is no day when buying the stock "
          + "will make profit");
    else
      for (int j = 0; j < count; j++)
        System.out.println("Buy on day: " + sol.get(j).buy
            + "        "
            + "Sell on day : " + sol.get(j).sell);

    return;

  }

  public static void main(String[] args) {
    int arr[] = { 100, 180, 260, 310, 40, 535, 695 };
    System.out.println(maxProfit(arr));
  }
}
