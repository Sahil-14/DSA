// Longest Common String
public class dp_prob20 {
    public int longestCommonString(char str1[], char str2[]) {
        int T[][] = new int[str1.length + 1][str2.length + 1];

        int max = 0;
        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    T[i][j] = T[i - 1][j - 1] + 1;
                    if (max < T[i][j]) {
                        max = T[i][j];
                    }
                }
            }
        }

        return max;
    }

    public void printString(int i, int j, int T[][], char[] s) {
        if (i == 0 || j == 0) {
            return;
        }
        if (T[i][j] == 0) {
            return;
        }
        printString(i - 1, j - 1, T, s);
        System.out.print(s[i]);
    }

    public static void main(String[] args) {
        dp_prob20 lcs = new dp_prob20();
        char str1[] = "abcdef".toCharArray();
        char str2[] = "zcdemf".toCharArray();
        System.out.println(lcs.longestCommonSubstring(str1, str2));
    }
}
