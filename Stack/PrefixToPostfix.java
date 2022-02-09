import java.util.Stack;

// Algorithm for Prefix to Postfix: 

// Read the Prefix expression in reverse order (from right to left)
// If the symbol is an operand, then push it onto the Stack
// If the symbol is an operator, then pop two operands from the Stack 
// Create a string by concatenating the two operands and the operator after them. 
// string = operand1 + operand2 + operator 
// And push the resultant string back to Stack
// Repeat the above steps until end of Prefix expression.

public class PrefixToPostfix {
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
    static String preToPost(String pre_exp){
        Stack<String> stack = new Stack<>();
        for(int i = pre_exp.length() -1;i>=0 ;i--){
            char c = pre_exp.charAt(i);
            if(isOperator(c)){
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = op1+op2+c;
                stack.push(temp);
            }else{
                stack.push(c+"");
            }
        }
        return stack.peek();
    }
    public static void main(String arg[]){
        String pre_exp = "*-A/BC-/AKL";
        System.out.println("Postfix : "
                           + preToPost(pre_exp));
    }
}
