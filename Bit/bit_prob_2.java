//check whether number is power of 2 or not
public class bit_prob2 {
  public static boolean isPowerOf2(int n) {
    return n != 0 && ((n & (n - 1)) == 0);
  }

  public static void main(String[] args) {
    System.out.println(isPowerOf2(1));
  }
}
