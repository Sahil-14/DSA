package Operations;

import java.util.Stack;

class StackNode {
    int data;
    StackNode next;

    public StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReversestackWithoutExtraSpace {
    StackNode top;

    public void push(int data) {
        if (this.top == null) {
            top = new StackNode(data);
            return;
        }
        StackNode s = new StackNode(data);
        s.next = this.top;
        this.top = s;
    }

    public StackNode pop() {
        StackNode s = this.top;
        this.top = this.top.next;
        return s;
    }

    void display() {
        StackNode s = this.top;
        while (s != null) {
            System.out.print(s.data + " ");
            s = s.next;
        }
        System.out.println();

    }

    public void reverse(){
        StackNode curr,prev,next;
        prev = next = null;
        curr = this.top;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev  = curr;
            curr = next;
        }
        this.top = prev;
    }

    public static void main(String arg[]){
        ReversestackWithoutExtraSpace s = new ReversestackWithoutExtraSpace();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println("Original Stack");
        s.display();
        System.out.println(s.top);
        s.reverse();
        System.out.println("Reversed Stack");
        s.display();
    }
}
