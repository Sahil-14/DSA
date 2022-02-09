public class bit_prob_6 {
  // Function to count set bits
  public static int countSetBits(int n) {
    int count = 0;
    while (n > 0) {
      count += n & 1;
      n >>= 1;
    }
    return count;

  }

  public static int countOnce(int n) {
    int count = 0;
    while (n != 0) {
      n = n & (n - 1);
      count++;
    }
    return count;
  }

  // Function to find number of bits needed to be flipped to convert A to B
  public static int countBitsFlip(int a, int b) {

    // XOR operation gives set bits only when there are dissimilar bits.
    // We store the value of XOR operation of a and b.
    int ans = a ^ b;
    System.out.println(countSetBits(ans));
    System.out.println(countOnce(ans));

  }

  

}
