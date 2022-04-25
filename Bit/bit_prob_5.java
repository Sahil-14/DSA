//Given a number N having only one ‘1’ and all other ’0’s in its binary representation,
// find position of the only set bit. If there are 0 or more than 1 set bit the answer should be -1.
// Position of  set bit '1' should be counted starting with 1 from LSB side in binary representation of the number.

public class bit_prob_5 {
  static boolean isPowerOf2(int n) {
    return (n != 0 && ((n & (n - 1)) == 0));
  }

  static int findPosition(int n) {
    if (!isPowerOf2(n)) {
      return -1;
    }
    unsigned count = 0;
    while (n) {
      n = n >> 1;
      ++count;
    }

    return count;

  }

  static int Log2n(int n) {
    return (n > 1) ? 1 + Log2n(n / 2) : 0;
  }

  static int findPosition2(int n) {
    if (!isPowerOfTwo(n))
      return -1;
    return Log2n(n) + 1;
  }

  public static void main(String[] args) {
    System.out.println(findPosition(16));
  }
}
