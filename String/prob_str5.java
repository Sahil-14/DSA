//move all x to the end
public class prob_str5 {
  public static String moveAllX(String s) {
    if (s.length() == 0) {
      return "";
    }
    char ch = s.charAt(0);
    String ros = moveAllX(s.substring(1));
    if (ch == 'x') {
      return ros + ch;
    }
    return ch + ros;
  }

  public static void main(String[] args) {
    System.out.println(moveAllX("axxsdfhxgxas"));
  }
}
