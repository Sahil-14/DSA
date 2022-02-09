//// Java program to rearrange array in alternating
// Java program to copy set bits in a given
// range [l, r] from y to x.

public class bit_prob_9 {
  static int copySetBits(int x, int y, int l, int r) {
    if (l < 1 || r > 32)
      return x;
    for (int i = l; i <= r; i++) {
      int mask = i << (i - 1);
      if ((y & mask) != 0) {
        // set bit in x
        x = x | mask;
      }
    }
    return x;
  }

  public static void main(String[] args) {
    int x = 10, y = 13, l = 1, r = 32;
    x = copySetBits(x, y, l, r);
    System.out.print("Modified x is " + x);
  }

}
