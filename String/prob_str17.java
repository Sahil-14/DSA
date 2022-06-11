//longest palindromic substring
public class prob_str17 {
  static int longestPalindromSubString(String str) {
    int n = str.length();
    boolean t[][] = new boolean[n][n];
    int maxLength = 1;

    for (int i = 0; i < n; i++) {
      t[i][i] = true;
    }

    int start = 0;
    for (int i = 0; i < n - 1; ++i) {
      if (str.charAt(i) == str.charAt(i + 1)) {
        table[i][i + 1] = true;
        start = i;
        maxLength = 2;
      }
    }
    for (int k = 3; k <= n; ++k) {

      // Fix the starting index
      for (int i = 0; i <= n - k; ++i) {
        // Get the ending index of substring from
        // starting index i and length k
        int j = i + k - 1;

        // checking for sub-string from ith index to
        // jth index iff str.charAt(i+1) to
        // str.charAt(j-1) is a palindrome
        if (table[i + 1][j - 1]
            && str.charAt(i) == str.charAt(j)) {
          table[i][j] = true;

          if (k > maxLength) {
            start = i;
            maxLength = k;
          }
        }
      }
    }
    return maxLength;
  }
}
