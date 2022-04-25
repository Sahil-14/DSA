public class prob_str6 {
  public static void subSeq(String s, String ans) {
    if (s.length() == 0) {
      System.out.println(ans);
      return;
    }
    char ch = s.charAt(0);
    String ros = s.substring(1);
    subSeq(ros, ans);
    subSeq(ros, ans + ch);
  }

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

  public static void main(String[] args) {
    subSeq("abc", "");
  }
}
