public class prob33 {
    Node head;
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
  
    Node insertAtTail(Node h ,int data){
        Node n = new Node(data);
        if(h == null){
            h = n;
            return h;
        }
        Node temp = h;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = n;
        return h;
    }
    public static void main(String arg[]){
        prob33 ll = new prob33();
        Node head1 = null;
       head1 =  ll.insertAtTail(head1, 1);
       head1 =  ll.insertAtTail(head1, 2);
        head1 = ll.insertAtTail(head1, 3);
        head1 = ll.insertAtTail(head1, 4);
        if(head1 == null){
            System.out.println("nullla");
        }
        System.out.println(head1.next.next.next.data);
       
    }
}
