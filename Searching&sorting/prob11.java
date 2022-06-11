/**
 * Make all array elements equal with minimum cost
 * 
 * Input : arr[] = [1, 100, 101]
 * Output : 100
 * We can change all its values to 100 with minimum cost,
 * |1 - 100| + |100 - 100| + |101 - 100| = 100
 * 
 * Input : arr[] = [4, 6]
 * Output : 2
 * We can change all its values to 5 with minimum cost,
 * |4 - 5| + |5 - 6| = 2
 * 
 * 
 * Alternate Solution
 * Think geometrically. Assume that array elements are co-ordinates on x axis.
 * The problem reduces to finding another co-ordinate such that the sum of
 * distances between this choice and other co-ordinates is minimized.
 * Observe that: If number of coordinates are odd then y = middle element. If
 * even then y is any number in between middle 2 co-ordinates. Say Input = [a,
 * b, c, d]. Output is any number between b and c including both. Hence the cost
 * is sum which can be computed easily now that we have chosen y. sum|(y-ai)|
 * for all i.
 * 
 * It is really easy to code it.
 * 
 * 
 */

public class prob11 {
  // This function assumes that a[] is
  // sorted. If a[] is not sorted, we need
  // to sort it first.
  public static int minCostToMakeElementEqual(int a[], int n) {
    int y;
    if (n % 2 == 1) {
      y = a[n / 2];
    }

    else
      y = (a[n / 2] + a[(n - 2) / 2]) / 2;

    // After deciding the final value,
    // find the result.
    int s = 0;

    for (int i = 0; i < n; i++)
      s += Math.abs(a[i] - y);
    return s;

  }

  // Driver code
  public static void main(String[] args) {
    int a[] = { 1, 100, 101 };
    int n = a.length;

    System.out.println(minCostToMakeElementEqual(a, n));
  }
}
