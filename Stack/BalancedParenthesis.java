import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParenthesis {
    static boolean areBreketsBalanced(String exp){
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0;i<exp.length();i++){
            char x = exp.charAt(i);
            
            if(x == '(' || x == '{' || x == '['){
                stack.push(x);
            }

            if(stack.isEmpty())
                return false;
            
            char chek ;
            switch(x){
                case ')':
                chek = stack.pop();
                if(chek == '{' || chek == '['){
                    return false;
                }
                break;
                case '}':
                chek = stack.pop();
                if(chek == '(' || chek == '['){
                    return false;
                }
                break;
                case ']':
                chek = stack.pop();
                if(chek == '{' || chek == '('){
                    return false;
                }
                break;
            }
        }
        return (stack.isEmpty());
    }

    public static void main(String arg[]){
        String expr = "([{}]))";
        if(areBreketsBalanced(expr)){
            System.out.println("Balanced");
        }else{
            System.out.println("Not Balanced");
        }
    }
}
