//reverser string
public class prob_str3 {
  public static void reverse(String s) {
    if (s.length() == 0) {
      return;
    }
    String ros = s.substring(1);
    reverse(ros);
    System.out.print(s.charAt(0));
  }

  public static void reverse2(String s) {
    String reverse = "";
    for (int i = s.length() - 1; i >= 0; i--) {
      char ch = s.charAt(i);
      reverse += ch;
    }
    System.out.println(reverse);
  }

  public static String removeVowel(String s) {
    return s.replaceAll("[aeiouAEIOU]", "");
  }

  public static void reverse3(String s) {
    String input = s;
    byte[] strAsByteArray = input.getBytes();
    byte[] result = new byte[strAsByteArray.length];
    for (int i = 0; i < strAsByteArray.length; i++) {
      result[i] = strAsByteArray[strAsByteArray.length - i - 1];
    }
    System.out.println(new String(result));
  }

  public static void main(String[] args) {
    // reverse("sahil");
    // System.out.println();
    String res = removeVowel("welcome to geeksforgeeks");
    System.out.println(res.length());

  }
}
