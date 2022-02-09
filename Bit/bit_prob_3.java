//find the number of once int binary number
public class bit_prob_3 {
  public static int countOnce(int n) {
    int count = 0;
    while (n != 0) {
      n = n & (n - 1);
      count++;
    }
    return count;
  }

  public static int countOnce2(int n) {
    int count = 0;
    for (int i = 31; i >= 0; i--) {
      int k = n >> i;
      if ((k & 1) == 1) {
        count++;
      }
    }
    return count;
  }

  public static int countOnce3(int n) {
    int count = 0;
    while (n > 0) {
      count += n & 1;
      n = n >> 1;
    }
    return count;
  }

  public static int numberOfOnceFrom1ToN(int n) {
    int total = 0;
    for (int i = 1; i <= n; i++) {
      total += countOnce(i);
    }
    return total;
  }

  public static void main(String[] args) {
    System.out.println(countOnce(2352353));
    System.out.println(countOnce2(2352353));
    System.out.println(countOnce3(2352353));
    // System.out.println(numberOfOnceFrom1ToN(10));
  }
}
