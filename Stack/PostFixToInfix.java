// Algorithm
// 1.While there are input symbol left
// …1.1 Read the next symbol from the input.
// 2.If the symbol is an operand
// …2.1 Push it onto the stack.
// 3.Otherwise,
// …3.1 the symbol is an operator.
// …3.2 Pop the top 2 values from the stack.
// …3.3 Put the operator, with the values as arguments and form a string.
// …3.4 Push the resulted string back to stack.
// 4.If there is only one value in the stack
// …4.1 That value in the stack is the desired infix string.

import java.util.Stack;

public class PostFixToInfix {
    public static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z');
    }

    public static String postfixToInfix(String exp) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            if (isOperand(exp.charAt(i))) {
                // convert char to string
                stack.push(exp.charAt(i) + "");
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = "(" + op2 + exp.charAt(i) + op1 + ")";
                stack.push(temp);
            }
        }
        return stack.pop();
    }

    public static void main(String args[]) {
        String exp = "ab*c+";
        System.out.println(postfixToInfix(exp));
    }
}
