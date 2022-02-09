import java.util.Stack;

public class prob39 {
    Stack<Integer> st = new Stack<>();
    void insertAtBottom(int ele) {
        if(st.isEmpty()){
            st.push(ele);
            return;
        }
        int top = st.peek();
        st.pop();
        insertAtBottom(ele);
        st.push(top);
        
    }

    void reverse() {
        if(st.isEmpty()){
            return;
        }
        int top = st.peek();
        st.pop();
        reverse();
        insertAtBottom(top);
    }

    public static void main(String arg[]) {
        prob39 ob = new prob39();
        
        ob.st.push(1);
        ob.st.push(2);
        ob.st.push(3);
        ob.st.push(4);
        ob.reverse();
        while(!ob.st.isEmpty()){
            System.out.println(ob.st.pop());
        }
    }
}
