////longest palindromic subsequence

public class prob_str13 {
  public int longestPaliSubse(String str) {
    int temp[][] = new int[str.length()][str.length()];
    for (int i = 0; i < temp.length; i++) {
      temp[i][i] = 1;
    }
    for (int l = 2; l <= str.length(); l++) {
      for (int i = 0; i <= str.length() - l; i++) {
        int j = i + l - 1;
        if (l == 2 && str.charAt(i) == str.charAt(j)) {
          temp[i][j] = 2;
        } else if (str.charAt(i) == str.charAt(j)) {
          temp[i][j] = 2 + t[i + 1][j][j - 1][i];
        } else {
          temp[i][j] = Math.max(temp[i + 1][j], temp[i][j - 1]);
        }
      }
    }
    return temp[0][str.length() - 1];

  }
}
