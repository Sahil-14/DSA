// RegEx match
// Write a program to perform regex matching with * an . 
public class dp_prob10 {
    public boolean matchReg(char[] text, char[] pattern) {
        boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

        T[0][0] = true;
        // Deals with patterns like a* or a*b* or a*b*c*
        for (int i = 2; i < T[0].length; i++) {
            if (pattern[i - 1] == '*') {
                T[0][i] = T[0][i - 2];
            }
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                    T[i][j] = T[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    // check for 0 occurance of pattern[j-1] go 2 step back
                    T[i][j] = T[i][j - 2];
                    // check for 1 for more occurence for that check wheter j th of pattern matche
                    // to i th of text || j th pattern == '.' then check after excluding ith of text
                    // wherther refular expression exist or not
                    if (pattern[j - 2] == '.' || pattern[j - 2] == text[i - 1]) {
                        T[i][j] = T[i][j] | T[i - 1][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }
        return T[text.length][pattern.length];
    }

    public static void main(String args[]) {
        dp_prob10 rm = new dp_prob10();
        System.out.println(rm.matchReg("Tushar".toCharArray(), "Tushar".toCharArray()));
        System.out.println(rm.matchReg("Tusha".toCharArray(), "Tushar*a*b*".toCharArray()));
        System.out.println(rm.matchReg("".toCharArray(), "a*b*".toCharArray()));
        System.out.println(rm.matchReg("abbbbccc".toCharArray(), "a*ab*bbbbc*".toCharArray()));
        System.out.println(rm.matchReg("abbbbccc".toCharArray(), "aa*bbb*bbbc*".toCharArray()));
        System.out.println(rm.matchReg("abbbbccc".toCharArray(), ".*bcc".toCharArray()));
        System.out.println(rm.matchReg("abbbbccc".toCharArray(), ".*bcc*".toCharArray()));
        System.out.println(rm.matchReg("abbbbccc".toCharArray(), ".*bcc*".toCharArray()));
        System.out.println(rm.matchReg("aaa".toCharArray(), "ab*a*c*a".toCharArray()));

        System.out.println(rm.matchReg("ab".toCharArray(), ".*".toCharArray()));
    }
}

// * - o or any no of occurance of prev
//
