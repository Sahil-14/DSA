// linked list implementaion
public class prob42 {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class Queue {
        public Node front;
        public Node back;

        Queue() {
            this.front = null;
            this.back = null;
        }

        public void push(int data) {
            Node n = new Node(data);
            if (front == null) {
                back = n;
                front = n;
            }
            back.next = n;
            back = n;
        }

        public void pop() {
            if (front == null) {
                System.out.println("Queue underflow");
                return;
            }
            System.out.println("Pop :" + front.data);
            Node temp = front;

            front = front.next;
            temp.next = null;
        }

        public int peek() {
            if (front == null) {
                System.out.println("No element in queue");
                return -1;
            }
            return front.data;
        }

        public boolean empty() {
            if (front == null) {
                return true;
            }
            return false;
        }
    }

    public static void main(String arg[]) {
        prob42 ob = new prob42();
        Queue q = ob.new Queue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println(q.peek());
        q.pop();
        q.pop();
        q.pop();
        q.pop();
        System.out.println(q.peek());
    }
}
