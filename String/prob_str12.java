//minimum edit distance
public class prob_str12 {
  public int minEditDistance(String s1, String s2) {
    int t[][] = new int[s1.length() + 1][s2.length() + 1];
    for (int i = 0; i < temp.length; i++) {
      temp[i][0] = i;
    }
    for (int i = 0; i < temp[0].length; i++) {
      temp[0][i] = i;
    }

    for (int i = 1; i < temp.length; i++) {
      for (int j = 1; j < temp[0].length; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          t[i][j] = t[i - 1][j - 1];
        } else {
          t[i][j] = 1 + Math.min(t[i - 1][j - 1], Math.min(t[i][j - 1], t[j][i - 1]));
        }
      }
    }
    return temp[str1.length][str2.length];

  }

  public static void main(String arg[]) {
    String str1 = "azced";
    String str2 = "abcdef";
    prob_str12 ob = new prob_str12();
    int result = ob.dynamicEditDistance(str1.toCharArray(), str2.toCharArray());
    System.out.println(result);
  }
}
