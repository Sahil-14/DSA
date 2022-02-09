//highest palindromic subsequence
//eg = agbdba 
//ans = 5 abdba
/**
 *
 * Given a string find longest palindromic subsequence in this string.
 *
 * Time complexity - O(n2)
 * Space complexity - O(n2
 *
 * Youtube link - https://youtu.be/_nCsPn7_OgI
 *
 * References
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 */
public class dp_prob9 {
    public int calculateLength(char[] str) {
        int T[][] = new int[str.length][str.length];
        for (int i = 0; i < str.length; i++) {
            T[i][i] = 1;
        }

        for (int l = 2; l <= str.length; l++) {
            for (int i = 0; i <= str.length - l; i++) {
                int j = i + l - 1;
                if (l == 2 && str[i] == str[j]) {
                    T[i][j] = 2;
                } else if (str[i] == str[j]) {
                    T[i][j] = T[i + 1][j - 1] + 2;
                } else {
                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                    //maximum of excluding i or excluding j
                }
            }
        }
        return T[0][str.length - 1];
    }

    public static void main(String arg[]) {
        String str = "agbdba";
        dp_prob9 ob = new dp_prob9();
        int r1 = ob.calculateLength(str.toCharArray());
        System.out.println(r1);

    }
}
