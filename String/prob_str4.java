//remve adjecent duplicates from string

public class prob_str4 {
  public static String removeDuplicates(String s) {
    if (s.length() <= 1) {
      return s;
    }
    char ch = s.charAt(0);
    String ans = removeDuplicates(s.substring(1));
    if (ch == ans.charAt(0)) {
      return ans;
    }
    return ch + ans;
  }

  public static void main(String[] args) {
    System.out.println(removeDuplicates("aabdgh"));
  }
}
