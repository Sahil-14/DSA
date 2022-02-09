
public class Prob20 {
    // reverse a string
    static void reverse(String s) {
        if (s.length() == 0) {
            return;
        }

        String ros = s.substring(1);
        reverse(ros);
        System.out.println(s.charAt(0));
    }

    // pi
    static void replaceWithPI(String s) {
        if (s.length() == 0) {
            return;
        }
        if (s.charAt(0) == 'p' && s.charAt(1) == 'i') {
            System.out.print("3.14");
            replaceWithPI(s.substring(2));
        } else {
            System.out.print(s.charAt(0));
            replaceWithPI(s.substring(1));
        }

    }

    // tower of hanoi
    static void towerOfHanoi(int n, char src, char dest, char help) {
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, src, help, dest);
        System.out.println("Move from " + src + " to " + dest);
        towerOfHanoi(n - 1, help, dest, src);

    }

    // remove adjacent duplicates from string
    static String removeDuplicates(String s) {
        if (s.length() == 0) {
            return " ";
        }
        char ch = s.charAt(0);
        String ans = removeDuplicates(s.substring(1));
        if (ans.charAt(0) == ch) {
            return ans;
        }

        return ch + ans;

    }

    // move x to the end
    static String moveAllX(String s) {
        if (s.length() == 0) {
            return "";
        }
        char ch = s.charAt(0);
        String ans = moveAllX(s.substring(1));
        if (ch == 'x') {
            return ans + ch;
        }
        return ch + ans;

    }

    // generate all substring
    static void subSeq(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = s.charAt(0);
        String ros = s.substring(1);
        subSeq(ros, ans);
        subSeq(ros, ans + ch);
    }

    // generate all substring with ascii
    static void subSeqAsc(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = s.charAt(0);
        int code = ch;
        String ros = s.substring(1);

        subSeqAsc(ros, ans);
        subSeqAsc(ros, ans + ch);
        subSeqAsc(ros, ans + code);
    }

    public static void main(String arg[]) {
        // reverse("sahil");
        // replaceWithPI("pippppiiitpi");
        // towerOfHanoi(3, 'A', 'C', 'B');
        // System.out.println(removeDuplicates("aaabbbccccddddea"));
        // System.out.println(moveAllX("axeefdsfxrxyuxx"));
        // subSeq("ABC", "");
        subSeqAsc("AB","");

    }
}
