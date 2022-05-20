
//Count All Palindromic Subsequence in a given String

public class prob_str19 {
  static int countPS(String str) {
    int N = str.length();
    int[][] cps = new int[N][N];

    // palindromic subsequence of length 1
    for (int i = 0; i < N; i++)
      cps[i][i] = 1;

    // check subsequence of length L is
    // palindrome or not
    for (int L = 2; L <= N; L++) {
      for (int i = 0; i <= N - L; i++) {
        int j = L + i - 1;
        if (str.charAt(i) == str.charAt(j)) {
          cps[i][j] = cps[i][j - 1]
              + cps[i + 1][j] + 1;
        } else {
          cps[i][j] = cps[i][j - 1]
              + cps[i + 1][j]
              - cps[i + 1][j - 1];
        }
      }
    }

    // return total palindromic subsequence
    return cps[0][N - 1];
  }
}
