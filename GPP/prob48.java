import java.util.Stack;
public class prob48 {
    static boolean redendantParenthesis(char[] s){
        boolean ans = false;
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length;i++){
            if(s[i] == '+' || s[i] == '-' || s[i] == '/' || s[i] == '*'){
                st.push(s[i]);
            }else if(s[i] == '('){
                st.push(s[i]);
            }else if(s[i] == ')'){
                if(!st.isEmpty() && st.peek() == '('){
                   ans = true;
                }
                while(!st.isEmpty() && (st.peek() == '*' || st.peek() == '+' || st.peek() == '-' || st.peek() == '/')){
                    st.pop();
                }
                if(!st.isEmpty()){
                    st.pop();
                }
              
            }
        }
        if(!st.isEmpty()){
            return true;
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "((a+b)))";
        System.out.println(redendantParenthesis(s.toCharArray()));
    }
}
