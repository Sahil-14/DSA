import java.util.Arrays;

class abhyas {
  public static void SOE(int n) {
    int prime[] = new int[100];
    Arrays.fill(prime, 0);

    for (int i = 2; i <= n; i++) {
      if (prime[i] == 0) {
        for (int j = i * i; j <= n; j += i) {
          prime[j] = i;
        }
      }
    }

    for (int i = 2; i <= n; i++) {
      if (prime[i] == 0) {
        System.out.println(i);
      }
    }
  }

  public static void pf(int n) {
    int spf[] = new int[100];
    Arrays.fill(spf, 0);

    for (int i = 0; i <= n; i++) {
      spf[i] = i;
    }

    for (int i = 2; i <= n; i++) {
      if (spf[i] == i) {
        for (int j = i * i; j <= n; j += i) {
          if (spf[j] == j) {
            spf[j] = i;
          }
        }
      }
    }

    while (n != 1) {
      System.out.println(spf[n]);
      n = n / spf[n];
    }
  }

  public static void toh(int n, char src, char dest, char help) {
    if (n == 0) {
      return;
    }
    toh(n - 1, src, help, dest);
    System.out.println("move from " + src + " to " + dest);
    toh(n - 1, help, dest, src);
  }

  public static int countPath(int s, int e) {
    if (s == e) {
      return 1;
    }
    if (s > e) {
      return 0;
    }
    int count = 0;
    for (int i = 1; i <= 6; i++) {
      count += countPath(s + i, e);
    }
    return count;
  }

  public static boolean isSafe(int arr[][], int x, int y, int n) {
    if (x < n && y < n && (arr[x][y] != 1)) {
      return true;
    }
    return false;
  }

  public static boolean ratInMaze(int arr[][], int x, int y, int n, int sol[][]) {
    // base case
    if (x == n - 1 && y == n - 1) {
      return true;
    }

    if (isSafe(arr, x, y, n)) {
      sol[x][y] = 1;
      if (ratInMaze(arr, x + 1, y, n, sol)) {
        return true;
      }
      if (ratInMaze(arr, x, y + 1, n, sol)) {
        return true;
      }
      sol[x][y] = 0;
      return false;
    }

    return false;
  }

  public static void main(String[] args) {
    pf(45);
  }
}