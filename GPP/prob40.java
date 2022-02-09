import java.util.Stack;
//Note
// if expression is prefix :   reverse the string / or traverse reverse
// for postfix : val2 is first and then val1;
public class prob40 {
    static int prec(Character c) {
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

    static String infixToPostfix(String s) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                result += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!s.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && prec(c) < prec(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }

        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    static String reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(str);
    }

    static String infixToPrefix(char[] infix1) {
        int l = infix1.length;
        String infix = reverse(infix1, 0, l - 1);
        infix1 = infix.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < l; i++) {
            if (infix1[i] == '(') {
                infix1[i] = ')';
            } else if (infix1[i] == ')') {
                infix1[i] = '(';
            }
        }
        String result = "";
        for (int i = l - 1; i >= 0; i++) {
            char c = infix1[i];
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                result += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && prec(c) < prec(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    static String postfixToInfix(String s) {
        Stack<String> stack = new Stack<>();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stack.push(c + "");
            } else {
                String val1 = stack.pop();
                String val2 = stack.pop();
                String temp = "(" + val2 + c + val1 + ")";
                stack.push(temp);
            }
        }
        return stack.pop();
    }

    static String prefixToInfix(String s) {
        int l = s.length();
        Stack<String> stack = new Stack<>();
        String result ="";
        for(int i = l-1;i>=0;i--){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                stack.push(c+"");
            }else{
                String val1 = stack.pop();
                String val2 = stack.pop();
                String temp = "("+val1+c+val2+")";
                stack.push(temp);
            }
        }
        return stack.pop();
    }
    static String prefixToPostfix(String str){
        Stack<String> stack = new Stack<>();
        int l = str.length();
        for(int i = l-1;i>=0;i--){
            char c = str.charAt(i);
            if(Character.isLetterOrDigit(c)){
                stack.push(c+"");
            }else{
                String val1 = stack.pop();
                String val2 = stack.pop();
                String temp = val1+val2+c;
                stack.push(temp);
            }
        }
        return stack.pop();
    }
    static String postfixToPrefix(String str){
        Stack<String> stack = new Stack<>();
        int l = str.length();
        for(int i = 0;i<l;i++){
            char c = str.charAt(i);
            if(Character.isLetterOrDigit(c)){
                stack.push(c+"");
            }else{
                String val1 = stack.pop();
                String val2 = stack.pop();
                String temp = c+val2+val1;
                stack.push(temp);
            }
        }
        return stack.peek();
    }
    static int postfixEvaluation(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String arg[]) {

    }
}
