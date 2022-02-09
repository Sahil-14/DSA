// Read the Postfix expression from left to right
// If the symbol is an operand, then push it onto the Stack
// If the symbol is an operator, then pop two operands from the Stack 
// Create a string by concatenating the two operands and the operator before them. 
// string = operator + operand2 + operand1 
// And push the resultant string back to Stack
// Repeat the above steps until end of Prefix expression.


import java.util.Stack;

public class PostfixToPrefix {
    static boolean isOperator(char c){
        switch(c){
            case '+':
            case '-':
            case '*':
            case '/':
            return true;

        }
        return false;
    }
    static String postToPre(String post_exp){
        Stack<String> stack = new Stack<>();
        int l = post_exp.length();
        for(int i = 0;i<l;i++){
            char c = post_exp.charAt(i);
            if(isOperator(c)){
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = c+op2+op1;
                stack.push(temp);
            }else{
                stack.push(c+"");
            }
        }
        return stack.peek();

    }
    public static void main(String arg[]){
        String post_exp = "ABC/-AK/L-*";
        System.out.println("Prefix : "+postToPre(post_exp));
    }
}
