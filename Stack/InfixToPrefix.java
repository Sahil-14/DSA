import java.util.Stack;

public class InfixToPrefix {

    static boolean isalpha(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

    static boolean isdigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    static boolean isOperator(char c) {
        return (!isalpha(c) && !isdigit(c));
    }

    static int prec(char ch) {
        switch (ch) {
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

    static String reverse(char str[], int start, int end) {
        char temp;
        while (start < end) {
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(str);
    }

    static String infixToPrefix(char infix[]) {
        int l = infix.length;
        String infix1 = reverse(infix, 0, l - 1);
        infix = infix1.toCharArray();
        String result = new String("");
        for (int i = 0; i < l; i++) {
            if (infix[i] == '(') {
                infix[i] = ')';
                // i++;
            } else if (infix[i] == ')') {
                infix[i] = '(';
                // i++;
            }
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < l; i++) {
            char c = infix[i];
            if (Character.isLetterOrDigit(c)) {
                result += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                // remove '('
                stack.pop();
            } else {
                while (!stack.isEmpty() && prec(c) < prec(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            result+=stack.pop();
        }

        return result;// reverse it

    }

    public static void main(String arg[]) {
        String s = ("x+y*z/w+u");
        System.out.println(infixToPrefix(s.toCharArray()));
    }
}
