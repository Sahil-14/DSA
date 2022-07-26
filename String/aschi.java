public class aschi {
  public static void main(String[] args) {

    String str = "abcdefghijklmnopqrstuvwzyz";
    String str2 = "defghijklmnopqrstuvwzyzabc";
    String s = "abz";
    String result = "";
    for (int i = 0; i < s.length(); i++) {
      result += str2.charAt(s.charAt(i) - 'a');
    }
    System.out.println(result);

  }
}
