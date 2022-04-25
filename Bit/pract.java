import java.util.Scanner;

public class pract {
  static void unique2() {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum = sum ^ arr[i];
    }
    // get righmost set bit;
    sum = (sum & -sum);
    int sum1 = 0;
    int sum2 = 0;
    for (int i = 0; i < n; i++) {
      if ((arr[i] & sum) == 0) {
        sum1 = sum1 ^ arr[i];
      } else {
        sum2 ^= arr[i];
      }
    }
    System.out.println(sum1 + " " + sum2);

  }

  static void printMissing(int arr[], int n) {
    int xor = 0;
    for (int i = 0; i < arr.length; i++) {
      xor = xor ^ arr[i];
    }

    for (int i = 1; i <= n; i++) {
      xor = xor ^ i;
    }
    int setbit = xor & -xor;
    int x = 0;
    int y = 0;
    for (int i = 0; i < arr.length; i++) {
      if ((arr[i] & setbit) > 0) {
        x = x ^ arr[i];
      } else {
        y = y ^ arr[i];
      }
    }
    for (int i = 0; i <= n; i++) {
      if ((i & setbit) > 0) {
        x = x ^ i;
      } else {
        y = y ^ i;
      }
    }

    System.out.println(x + " " + y);

  }

  static int square(int n) {
    if (n == 0) {
      return 0;

    }
    if (n < 0) {
      n = -n;
    }
    int x = n >> 1;
    if (n % 2 == 0) {
      return (square(x) << 2);
    } else {
      return ((square(x) << 2) + (x << 2) + 1);
    }
  }

  public static void main(String[] args) {
    // unique2();
    printMissing(new int[] { 1, 2, 5, 6 }, 6);
  }
}
