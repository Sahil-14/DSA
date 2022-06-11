//palindrominc substring count

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

    for (int i = 0; i < n - 1; i++) {
      if (str.charAt(i) == str.charAt(i + 1)) {
        count++;
        t[i][i + 1] = true;
      }
    }

    for (int l = 3; l <= n; l++) {
      for (int i = 0; i <= n - l; i++) {
        int j = i + l - 1;
        if (t[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
          t[i][j] = true;
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {

    String Str = "abbaeae";
    System.out.println(palindromicSubstringCount(Str));

  }
}
