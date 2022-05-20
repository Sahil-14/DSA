public class prob_str18 {
  public static int palindromicSubstringCount(String str) {
    int n = str.length();
    if (n <= 1) {
      return n;
    }
    boolean t[][] = new boolean[n][n];
    int count = 0;
    for (int i = 0; i < n; i++) {
      t[i][i] = true;
      count++;
    }

    for (int l = 2; l <= n; l++) {
      for (int i = 0; i <= n - l; i++) {
        int j = i + l - 1;
        if (l == 2 && str.charAt(i) == str.charAt(j)) {
          t[i][j] = true;
          count++;
        } else if (t[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
          t[i][j] = true;
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {

    String Str = "abbaeae";
    System.out.println(palindromicSubsequeceCount(Str));

  }
}
