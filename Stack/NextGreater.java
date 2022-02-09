public class NextGreater {
    static class stack {
        int top;
        int items[] = new int[100];

        stack() {
            top = -1;
        }

        void push(int x) {
            if (top >= 99) {
                System.out.println("Stack full");

            } else {
                items[++top] = x;
            }
        }

        int pop() {
            if (top == -1) {
                System.out.println("Stack empty");
                return -1;
            } else {
                int item = items[top];
                top--;
                return item;
            }
        }

        boolean isEmpty() {
            return (top == -1);
        }
    }

    static void printNGE(int arr[], int n) {
        int i = 0;
        stack s = new stack();
        int element, next;

        s.push(arr[0]);

        for (i = 1; i < arr.length; i++) {
            next = arr[i];
            if (!s.isEmpty()) {
                element = s.pop();

                while (element < next) {
                    System.out.println(element + " --> " + next);
                    if (s.isEmpty()) {
                        break;
                    }
                    element = s.pop();
                }
                if (element > next) {
                    s.push(element);
                }

            }
            s.push(next);
        }
        while (!s.isEmpty()) {

            System.out.println(s.pop() + " -- " + -1);
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1,2,3,4,5,6 };
        int n = arr.length;
        printNGE(arr, n);
    }

}
