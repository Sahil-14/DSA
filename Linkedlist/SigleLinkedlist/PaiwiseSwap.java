/**
 * Given a singly linked list, write a function to swap elements pairwise. Input
 * : 1->2->3->4->5->6->NULL Output : 2->1->4->3->6->5->NULL
 * 
 */

public class PaiwiseSwap {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void swapPairwise() {
        Node temp = head;
        while (temp != null && temp.next != null) {
            int swap = temp.data;
            temp.data = temp.next.data;
            temp.next.data = swap;
            temp = temp.next.next;
        }
    }
    void swapPairwiseRec(Node head){
        if(head != null && head.next != null){
            int temp = head.data;
            head.data = head.next.data;
            head.next.data = temp;
            swapPairwiseRec(head.next.next);
        }
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
        PaiwiseSwap ll = new PaiwiseSwap();
        ll.push(5);
        ll.push(4);
        ll.push(3);
        ll.push(2);
        ll.push(1);
        System.out.println("Linked List before calling pairWiseSwap() ");
        ll.printList();
        // ll.swapPairwise();
        ll.swapPairwiseRec(ll.head);
        System.out.println("\nLinked List after calling pairWiseSwap() ");
        ll.printList();
    }
}
