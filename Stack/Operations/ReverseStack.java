package Operations;

import java.util.Stack;

public class ReverseStack {
    static Stack<Character> st = new Stack<>();
    static void insertAtBottom(char x){
        if(st.isEmpty()){
            st.push(x);
        }else{
               // All items are held in Function
            // Call Stack until we reach end
            // of the stack. When the stack becomes
            // empty, the st.size() becomes 0, the
            // above if part is executed and 
            // the item is inserted at the bottom
            char a = st.peek();
            st.pop();
            insertAtBottom(x);
            // push allthe items held 
            // in Function Call Stack
            // once the item is inserted 
            // at the bottom
            st.push(a);
        }
    }

    static void reverse(){
        if(st.size() > 0){
            char x = st.peek() ;
            st.pop();
            reverse();
            insertAtBottom(x);
        }
    }
    public static void main(String arg[]){
        st.push('1');
        st.push('2');
        st.push('3');
        st.push('4');
        System.out.println("Original Stack");
        System.out.println(st);
        reverse();
        System.out.println("Reversed Stack");
        System.out.println(st);

    }
}
