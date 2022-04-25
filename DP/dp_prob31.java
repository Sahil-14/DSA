// string interleavition
//given 3 strings you have to  tell 3rd string is interleaving of not . Interleaving 
//means 3rd string should  be entirely made up of characters of 1st nad 2nd string & order should be preserve

public class dp_prob31 {
    public boolean isInterleaved(char str1[], char str2[], char str3[]) {
        boolean T[][] = new boolean[str1.length + 1][str2.length + 1];

        if (str1.length + str2.length != str3.length) {
            return false;
        }

        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T[i].length; j++) {
                int l = i + j - 1;
                if (i == 0 && j == 0) {
                    T[i][j] = true;
                } else if (i == 0) {
                    if (str3[l] == str2[j - 1]) {
                        T[i][j] = T[i][j - 1];
                    }
                } else if (j == 0) {
                    if (str1[i - 1] == str3[l]) {
                        T[i][j] = T[i - 1][j];
                    }
                } else {
                    T[i][j] = (str1[i - 1] == str3[l] ? T[i - 1][j] : false)
                            || (str2[j - 1] == str3[l] ? T[i][j - 1] : false);
                }
            }
        }
        return T[str1.length][str2.length];
    }

    public static void main(String args[]) {
        String str1 = "XXYM";
        String str2 = "XXZT";
        String str3 = "XXXZXYTM";
        dp_prob31 sti = new dp_prob31();
        System.out.println(sti.isInterleaved(str1.toCharArray(), str2.toCharArray(), str3.toCharArray()));
    }
}
