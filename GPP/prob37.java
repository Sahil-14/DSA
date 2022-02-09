public class prob37 {
    int n = 10;
    public class Stack{
        int arr[];
        int top;
        Stack(){
            this.arr = new int[n];
            this.top = -1;
        }

        public void push(int data){
            if(top == n-1){
                System.out.println("Stack overflow");
                return ;
            }
            top++;
            arr[top] = data;
        }

        public int pop(){
            if(top == -1){
                System.out.println("Stack underflow");
                return -1;
            }
            int data = arr[top--];
            return data;
        }

        public boolean isEmpty(){
            return top ==-1;
        }

    }
    public static void main(String arg[]){
        prob37 ob = new prob37();
        Stack s  = ob.new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
