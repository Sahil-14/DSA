import java.util.*;

public class practice {
  public void deleteMiddle(Stack<Integer> s, int n, int curr) {
    if (s.isEmpty()) {
      return;
    }
    int top = s.peek();
    s.pop();
    deleteMiddle(s, n, curr + 1);
    if (curr != n / 2) {
      s.push(top);
    }
  }

  public void insertAtBottom(Stack<Integer> s, int x) {
    if (s.isEmpty()) {
      s.push(x);
    } else {
      int top = s.peek();
      s.pop();
      insertAtBottom(s, top);

    }
  }

  public void reverse(Stack<Integer> s) {
    if (s.isEmpty()) {
      return;
    }
    int top = s.peek();
    s.pop();
    reverse(s);
    insertAtBottom(s, top);

  }

  public boolean balanceParanthesis(String exp) {
    Stack<Character> s = new Stack<>();
    for (int i = 0; i < exp.length(); i++) {
      char x = exp.charAt(i);
      if (x == '(' || x == '{' || x == '[') {
        s.push(x);
      }

      if (s.isEmpty()) {
        return false;
      }
      char chek;
      switch (x) {

        case '(':
          chek = s.pop();
          if (chek != ')') {
            return false;
          }
          break;
        case '{':
          chek = s.pop();
          if (chek != '}') {
            return false;
          }
          break;
        case '[':
          chek = s.pop();
          if (chek != ']') {
            return false;
          }

      }
    }
    return s.isEmpty();
  }

  public int priority(char c) {

    switch (c) {
      case '+':
      case '-':
        return 1;

      case '*':
      case '/':
        return 2;
      case '^':
        return 3;
    }
    return -1;
  }

  public String infixToPostfix(String exp) {
    Stack<Character> s = new Stack<>();
    String result = "";
    for (int i = 0; i < exp.length(); i++) {
      char c = exp.charAt(i);

      if (c == '(') {
        s.push(c);
      } else if (Character.isLetterOrDigit(c)) {
        result += c;
      } else if (c == ')') {
        while (!s.isEmpty() && s.peek() != ')') {
          result += s.pop();
        }
        s.pop();
      } else {
        while (!s.isEmpty() && priority(c) < priority(s.peek())) {
          result += s.pop();
        }
        s.push(c);
      }
    }
    return result;
  }
}
