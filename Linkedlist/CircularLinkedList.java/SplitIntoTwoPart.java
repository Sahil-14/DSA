public class SplitIntoTwoPart {
    Node head, head1, head2;

   static class Node {
        int data;
        Node next, prev;

        Node(int d) {
            data = d;
            next = prev = null;
        }
    }

    void splitList() {
        Node slow_ptr = head;
        Node fast_ptr = head;
  
        if (head == null) {
            return;
        }
  
        /* If there are odd nodes in the circular list then
         fast_ptr->next becomes head and for even nodes 
         fast_ptr->next->next becomes head */
        while (fast_ptr.next != head
                && fast_ptr.next.next != head) {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }
  
        /* If there are even elements in list then move fast_ptr */
        if (fast_ptr.next.next == head) {
            fast_ptr = fast_ptr.next;
        }
  
        /* Set the head pointer of first half */
        head1 = head;
  
        /* Set the head pointer of second half */
        if (head.next != head) {
            head2 = slow_ptr.next;
        }
        /* Make second half circular */
        fast_ptr.next = slow_ptr.next;
  
        /* Make first half circular */
        slow_ptr.next = head;
    }
    void printList(Node node){
        Node temp = node;
        if(node != null){
            do{
                System.out.print(temp.data+" ");
                temp = temp.next;
            }while(temp != node);
        }
        System.out.println();
    }
    public static void main(String arg[]){
        SplitIntoTwoPart ll = new SplitIntoTwoPart();
        ll.head = new Node(12);
        ll.head.next = new Node(56);
        ll.head.next.next = new Node(2);
        ll.head.next.next.next = new Node(11);
        ll.head.next.next.next.next = ll.head;
        System.out.println("Original Circular Linked list ");
        ll.printList(ll.head);
        ll.splitList();
        System.out.println("");
        System.out.println("First Circular List ");
        ll.printList(ll.head1);
        System.out.println("Second Circular List ");
        ll.printList(ll.head2);
    }
}
