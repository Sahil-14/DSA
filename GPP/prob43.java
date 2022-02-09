import java.util.Stack;

public class prob43 {
    class Queue{
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        public void push(int x){
            s1.push(x);
        }
        public int pop(){
            if(s1.isEmpty() && s2.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            int topval = s2.peek();
            s2.pop();
            return topval;
        }
        public int popBy1Stack(){
            if(s1.isEmpty()){
                System.out.println("Queue is empty");
            }
            int x  = s1.peek();
            s1.pop();
            if(s1.isEmpty()){
                return x;
            }
            int item = popBy1Stack();
            s1.push(x);
            return item;
        }

        public boolean isEmpty(){
            return (s1.isEmpty() && s2.isEmpty());
        }
    }

    public static void main(String[] args) {
        prob43 ob = new prob43();
        Queue q = ob.new Queue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
    }
}
