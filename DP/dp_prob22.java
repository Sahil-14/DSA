// Wildcard matching
// * - 0 or more seqence of any caracter
//?  - any one character
public class dp_prob22 {
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        // replace multiple * with one *
        int writeIndex = 0;
        boolean isFirst = true;
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[writeIndex++] = pattern[i];
                    isFirst = false;
                }
            } else {
                pattern[writeIndex++] = pattern[i];
                isFirst = true;
            }
        }
        boolean T[][] = new boolean[str.length + 1][writeIndex + 1];
        if (writeIndex > 0 && pattern[0] == '*') {
            T[0][1] = true;
        }
        T[0][0] = true;
        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j - 1] == '?' || pattern[j - 1] == str[i - 1]) {
                    T[i][j] = T[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    T[i][j] = T[i - 1][j] || T[i][j - 1]; //[i][j-1] - 0 occurence | [i-1][j] - 1 or more ocurrence ;
                } else {
                    T[i][j] = false;
                }
            }
        }
        return T[str.length][writeIndex];
    }

    public static void main(String args[]) {
        dp_prob22 wcm = new dp_prob22();
        System.out.println(wcm.isMatch("xbylmz", "x?y*z"));
    }
}
