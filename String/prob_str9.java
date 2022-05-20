import java.util.Stack;

public class prob_str9 {
  public static boolean isValidParenthesis(String str) {
    Stack<Character> s = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char x = str.charAt(i);
      if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(') {
        s.push(str.charAt(i));

      }

      if (s.isEmpty()) {
        return false;
      }

      char chek;
      switch (x) {
        case '}':
          chek = s.pop();
          if (chek != '{') {
            return false;
          }
          break;
        case ']':
          chek = s.pop();
          if (chek != '[') {
            return false;
          }
          break;
        case ')':
          chek = s.pop();
          if (chek != '(') {
            return false;
          }
          break;
      }

    }
    return s.isEmpty();
  }

  public static void main(String[] args) {
    String s = "{[(]]}";
    System.out.println(isValidParenthesis(s));

  }
}
