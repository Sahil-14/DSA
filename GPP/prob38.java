import java.util.Stack;

public class prob38 {

    void reverseStatement(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            String word = "";
            while(s.charAt(i) != ' ' && i < s.length()){
                word+=s.charAt(i);
                
            }
            
            stack.push(word);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.peek()+" ");
         
            stack.pop();
        }
    }

    public static void main(String arg[]) {
        String s = "Hey how are you doing";
        prob38 ob = new prob38();
        ob.reverseStatement(s);
    }
}
