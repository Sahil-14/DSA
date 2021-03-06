// print all subset from 1 to n;
public class bit_prob_4 {
  public static void subset(int arr[], int n) {
    for (int i = 0; i < (1 << n); i++) {
      for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) != 0) {
          System.out.print(arr[j] + "\t");
        }
      }
      System.out.println();
    }
  }

  static void printPowerSet(char[] set,
      int set_size) {

    /*
     * set_size of power set of a set
     * with set_size n is (2**n -1)
     */
    long pow_set_size = (long) Math.pow(2, set_size);
    int counter, j;

    /*
     * Run from counter 000..0 to
     * 111..1
     */
    for (counter = 0; counter < pow_set_size; counter++) {
      for (j = 0; j < set_size; j++) {
        /*
         * Check if jth bit in the
         * counter is set If set then
         * print jth element from set
         */
        if ((counter & (1 << j)) > 0)
          System.out.print(set[j]);
      }

      System.out.println();
    }
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 4 };
    subset(arr, 4);
  }
}
