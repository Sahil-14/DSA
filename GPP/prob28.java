//reverse k nodes in liked list;
//Reverse a Linked List in groups of given size | Set 1
public class prob28 {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node reverseK(Node head, int k) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null) {
            head.next = reverseK(next, k);
        }
        return prev;

    }

    public Node push(Node head, int new_data) {

        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
        return head;
    }

    public void printList(Node head) {
        Node tnode = head;
        if (tnode == null) {
            System.out.println("Linkedlist is empty");
        }
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    public static void main(String arg[]) {
        prob28 ob = new prob28();
        Node head = null;
        head = ob.push(head, 6);
        head = ob.push(head, 5);
        head = ob.push(head, 4);
        head = ob.push(head, 3);
        head = ob.push(head, 2);
        head = ob.push(head, 1);
        ob.printList(head);
        System.out.println();
        head = ob.reverseK(head, 2);
        ob.printList(head);
    }
}
