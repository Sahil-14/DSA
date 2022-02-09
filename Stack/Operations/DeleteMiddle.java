package Operations;

import java.util.Stack;

public class DeleteMiddle {
    static void deleteMiddle(Stack<Character> st, int n, int curr) {
        // if empty return
        // peek
        // pop
        // delete
        // push
        if (st.isEmpty()) {
            return;
        }
        char x = st.peek();
        st.pop();
        deleteMiddle(st, n, curr + 1);
        if (curr != n / 2) {
            st.push(x);
        }
    }

    public static void main(String arg[]) {
        Stack<Character> st = new Stack<>();
        st.push('1');
        st.push('2');
        st.push('3');
        st.push('4');
        st.push('5');
        st.push('6');
        
        System.out.println(st);
        deleteMiddle(st, st.size(), 0);
        System.out.println(st);

        

    }
}

// 0 1
// 1 2
// 2 3 -> middle
// 3 4
// 4 5

// 5/2 = 2;

// n/2 = 2

// x delete(st,size,curr) line stack new_stack
// 1 delete(st,5,0) 3,4 2,3,4,5 1,2,4,5
// 2 delete(st,5,1) 3,4 3,4,5 2,4,5
// 3 delete(st,5,2) 3,4 4,5 4,5
// 4 delete(st,5,3) 3,4 5 4,5
// 5 delete(st,5,4) 3,4 - 5
