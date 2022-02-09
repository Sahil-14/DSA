
public class prob32 {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head1 = null;
    Node head2 = null;

    int length(Node head) {
        Node temp = head;
        int l = 0;
        while (temp != null) {
            temp = temp.next;
            l++;
        }
        return l;
    }

    void intersect(int p) {
        Node temp1 = head1;
        int c = 1;
        while (c != p) {
            c++;
            temp1 = temp1.next;
        }

        Node temp2 = head2;
        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        temp2.next = temp1;
    }

    int intersection() {
        int l1 = length(head1);
        int l2 = length(head2);
        int d = 0;
        Node ptr1;
        Node ptr2;
        if (l1 > l2) {
            d = l1 - l2;
            ptr1 = head1;
            ptr2 = head2;
        } else {
            d = l2 - l1;
            ptr1 = head2;
            ptr2 = head1;
        }
        while (d != 0) {
            ptr1 = ptr1.next;
            if (ptr1 == null) {
                return -1;
            }
            d--;
        }
        while (ptr1 != null && ptr2 != null) {
            if (ptr1 == ptr2) {
                return ptr1.data;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return -1;
    }
    Node insertAtTail(int data,Node head){
        Node n = new Node(data);
        if(head == null){
            head = n;
            return head;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = n;
        return head;
    }
    void display(Node head){
        Node temp = head;
        if(temp == null){
            System.out.println("list is null");
        }
        while(temp != null){
            System.out.print(temp.data+" ");
        }
        System.out.println();
    }
    public static void main(String arg[]){
        prob32 ll = new prob32();
       ll.head1 =  ll.insertAtTail(1, ll.head1);
       ll.head1 =  ll.insertAtTail(2, ll.head1);
       ll.head1 =  ll.insertAtTail(3, ll.head1);
       ll.head1 =  ll.insertAtTail(4, ll.head1);
       ll.head1 =  ll.insertAtTail(5, ll.head1);
       ll.head1 = ll.insertAtTail(6, ll.head1);
    ll.display(ll.head1);
    }
}
