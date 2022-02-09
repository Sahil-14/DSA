package Operations;

import java.util.Stack;

public class ReverseIndividualWords {
    public static String reverseWords(String str){
        Stack<Character> stack = new Stack<>();
        String result = "";
        for(int i = 0;i<str.length();i++){
         char c = str.charAt(i);
         if(c != ' '){
            stack.push(c);
         }else{
             while(!stack.isEmpty()){
                 result+=stack.pop();
             }
             result+=" ";

         }

        }
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }
    public static void main(String arg[]){
        String str = "Geeks for Geeks";
       System.out.println( reverseWords(str));
    }
}
