// palindrome partition
class dp_prob26 {
    public boolean isPalindrome(char[] arr, int i, int j) {
        while (i < j) {
            if (arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    // space efficient
    public static int minCut(String a) {
        int[] cut = new int[a.length()];
        boolean[][] palindrome = new boolean[a.length()][a.length()];

        for (int i = 0; i < a.length(); i++) {
            int minCut = i;
            for (int j = 0; j <= i; j++) {
                if (a.charAt(i) == a.charAt(j) && (i - j < 2 || palindrome[j + 1][i - 1])) {
                    palindrome[j][i] = true;
                    minCut = Math.min(minCut, j == 0 ? 0 : (cut[j - 1] + 1));
                }
            }
            cut[i] = minCut;
        }

        return cut[a.length() - 1];
    }

    public int palindromePartition(String str) {
        int n = str.length();

        int T[][] = new int[n][n];
        boolean P[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            P[i][i] = true;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;

                if (l == 2) {
                    P[i][j] = str.charAt(i) == str.charAt(j);
                } else {
                    P[i][j] = (str.charAt(i) == str.charAt(j)) && P[i + 1][j - 1];
                }

                if (P[i][j] == true) {
                    T[i][j] = 0;
                } else {

                    T[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k <= j - 1; k++) {
                        T[i][j] = Math.min(T[i][j], 1 + T[i][k] + T[k + 1][j]);
                    }
                }

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(T[i][j] + " ");
            }
            System.out.println();
        }
        return T[0][n - 1];

    }

    public static void main(String[] args) {
        dp_prob26 ob = new dp_prob26();
        // String str = "abcbm";
        String str = "ababbbabbababa";
        System.out.println(ob.palindromePartition(str));
        System.out.println(ob.minCut(str));
    }
}