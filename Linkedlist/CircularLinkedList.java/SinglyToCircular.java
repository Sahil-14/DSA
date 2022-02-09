public class SinglyToCircular {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node head = null;

    void  circular() {
      
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        
    }

    void push(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    void printList() {
        Node tnode = head;
        if (tnode == null) {
            System.out.println("Linkedlist is empty");
        }
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    void display(Node node) {
        Node start = node;

        while (node.next != start) {
            System.out.print(" " + node.data);
            node = node.next;
        }

        // Display the last node of
        // circular linked list.
        System.out.print(" " + node.data);
    }

    public static void main(String arg[]) {
        SinglyToCircular ll = new SinglyToCircular();

        ll.push(10);
        ll.push(11);
        ll.push(12);
        ll.push(13);
        ll.push(14);
        ll.push(15);
        // ll.printList();
        // System.out.println(head.data+" ");
        ll.circular();
        ll.display(ll.head);
    }
}
