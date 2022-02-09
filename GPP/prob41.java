// Array implementation of queue
public class prob41 {
    int n = 10;

    class queue {
        int arr[];
        int front;
        int back;

        queue() {
            arr = new int[n];
            front = -1;
            back = -1;
        }

        public void push(int x) {
            if (back == n - 1) {
                System.out.println("queue overflow");
                return;
            }
            back++;
            arr[back] = x;
            if (front == -1) {
                front++;
            }
        }

        public int pop() {
            if (front == -1 || front > back) {
                System.out.println("No element in queue");
                return -1;
            }
            int data = arr[front];
            front++;
            return data;
        }

        public int peek() {
            if (front == -1 || front > back) {
                System.out.println("No element in queue");
                return -1;
            }
            return arr[front];

        }

        public boolean empty() {
            if (front == -1 || front > back) {
                System.out.println("No element in queue");
                return true;
            }
            return false;

        }
    }

    public static void main(String arg[]) {
        prob41 ob = new prob41();
        queue q = ob.new queue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println(q.pop());
        System.out.println(q.peek());
        System.out.println(q.pop());

        System.out.println(q.pop());

        System.out.println(q.pop());


        System.out.println(q.pop());

    }
}
