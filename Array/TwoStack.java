//method :1
// public class TwoStack {
//     int arr[];
//     int size;
//     int top1, top2;

//     TwoStack(int n) {
//         size = n;
//         arr = new int[n];
//         top1 = n / 2 + 1;
//         top2 = n / 2;
//     }

//     void push1(int n) {
//         if (top1 > 0) {
//             top1--;
//             arr[top1] = n;
//         } else {
//             System.out.println("Stack overflow by element :" + n);
//             return;
//         }
//     }

//     void push2(int n) {
//         if (top2 < arr.length - 1) {
//             top2++;
//             arr[top2] = n;
//         } else {
//             System.out.println("Stack overflow by element :" + n);
//             return;
//         }
//     }

//     int pop1() {
//         if (top1 <= size / 2) {
//             int data = arr[top1];
//             top1++;
//             return data;
//         } else {
//             System.out.print("Stack UnderFlow");
//             System.exit(1);
//         }
//         return 0;

//     }

//     int pop2() {
//         if (top2 >= size / 2 + 1) {
//             int data = arr[top2];
//             top2--;
//             return data;
//         } else {
//             System.out.print("Stack UnderFlow");
//             System.exit(1);
//         }
//         return 0;
//     }

//     public static void main(String arg[]) {
//         TwoStack ts = new TwoStack(5);
//         ts.push1(5);

//         ts.push2(10);
//         ts.push2(15);
//         ts.push1(11);
//         ts.push2(7);
//         System.out.print("Popped element from stack1 is " + " : " + ts.pop1() + "\n");
//         ts.push2(40);
//         System.out.print("Popped element from stack2 is " + ": " + ts.pop2() + "\n");
//     }

// }

class TwoStack {
    int size;
    int top1, top2;
    int arr[];

    TwoStack(int n) {
        size = n;
        arr = new int[n];
        top1 = -1;
        top2 = size;
    }

    void push1(int n) {
        if (top1 < top2 - 1) {
            arr[++top1] = n;
        } else {
            System.out.print("Stack UnderFlow");
            System.exit(1);
        }
    }

    void push2(int n) {
        if (top1 < top2 - 1) {
            arr[--top2] = n;
        } else {
            System.out.print("Stack UnderFlow");
            System.exit(1);
        }
    }

    int pop1() {
        if (top1 >= 0) {
            int data = arr[top1--];
            return data;
        } else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }

    int pop2() {
        if (top2 < size) {
            int data = arr[top2++];
            return data;
        } else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }

    public static void main(String args[]) {
        TwoStack ts = new TwoStack(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        System.out.println("Popped element from" + " stack1 is " + ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from" + " stack2 is " + ts.pop2());
    }
}
