// Calculate square of a number without using *, / and pow()

public class bit_prob_10 {
  // o(n)
  public static int square(int n) {
    if (n < 0) {
      n = -n;
    }
    int res = n;
    for (int i = 1; i < n; i++) {
      res += n;
    }
    return res;
  }

  public int square2(int n) {
    if (n == 0) {
      return 0;
    }
    
    if (n < 0) {
      n = -n;
    }
    // Get floor(n/2) using
    // right shift
    int x = n >> 1;
    
    if(n %2 != 0){
      return ((square(x) << 2) + (x << 2) +1);
    }else{
      return (square(x) << 2);
    }

  }

  public static void main(String[] args) {

    for (int n = 1; n <= 5; n++)
      System.out.println("n = " + n
          + ", n^2 = " + square(n));
  }

}
