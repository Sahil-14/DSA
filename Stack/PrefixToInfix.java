import java.util.Stack;

/**
 * Note in 1 + 2 (operator if + and operand are 1,2) 
 * Algorithm: 1:Read the
 * prefix expression from right to left; 2:if char is operand the push it into
 * the stack 3:if char is operator then pop two 2 operand into the stack create
 * string by concatinating string = operand1 +operator + operand2 push this
 * string back to the stack; 4:Repeat step 1 to 3 till expression
 */
public class PrefixToInfix {
    static boolean isOperator(char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;

        }
        return false;
    }

    public static String prefixToInfix(String str) {
        Stack<String> stack = new Stack<>();
        int l = str.length();
        for (int i = l - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (isOperator(c)) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = "(" + op1 + c + op2 + ")";
                stack.push(temp);
            } else {
                stack.push(c + "");
            }
        }
        return stack.pop();
    }
   
    public static void main(String arg[]) {
        String exp = "*-A/BC-/AKL";
        System.out.println("Infix : " + prefixToInfix(exp));
    }

}
