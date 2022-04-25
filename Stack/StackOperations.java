public class StackOperations {
    static final int MAX =1000;
    int top;
    int a[] = new int[MAX];
    StackOperations(){
        top = -1;
    }
    boolean isEmpty(){
        return (top < 0);
    }
    boolean push(int x){
        if(top >= MAX -1){
            System.out.println("Stack overflow");
            return false ;
        }else{
            a[++top] = x;
            System.out.println("Pushed to stack");
            return true;
        }
    }

    int pop(){
        if(top < 0){
            System.out.println("Stack underflow");
            return 0 ;
        }else{
            int x = a[top--];
            return x;
        }
    }
    

    int peek(){
        if(top < 0){
            System.out.println("Stack underflow");
            return 0 ;
        }
        else{
            return a[top];
        }
    }
    public static void main(String arg[]){
        StackOperations s = new StackOperations();
        if(s.isEmpty()){
            System.out.println("Stack is empty");
        }else{
            System.out.println("Stack is not empty");
        }
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
        System.out.println("Top element is " + s.peek());
    }

}
