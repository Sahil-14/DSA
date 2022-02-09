public class MoveLastElementToFirst {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void moveToFirst() {
        Node temp = head, prev = null;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        temp.next = head;
        head = temp;
    }

    void push(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String arg[]) {
        MoveLastElementToFirst ll = new MoveLastElementToFirst();
        ll.push(5);
        ll.push(4);
        ll.push(3);
        ll.push(2);
        ll.push(1);

        ll.printList();
        ll.moveToFirst();
        System.out.println();
        ll.printList();
    }
}
