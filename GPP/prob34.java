// merge sorted ll
public class prob34 {
    Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    public void addToLast(int data){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new_node;
        }
    }
    Node merge(Node head1,Node head2){
        Node p1 = head1;
        Node p2 = head2;
        Node dummyNode = new Node(-1);
        Node p3 = dummyNode;
        while(p1 != null && p2 != null){
            if(p1.data < p2.data){
                p3.next = p1;
                p1 = p1.next;
             
            }else{
                p3.next = p2;
                p2 = p2.next;
            }
            p3 = p3.next;
        }
        while(p1 != null){
            p3.next = p1;
            p1 = p1.next;
            p3 = p3.next;
        }
        while(p2 != null){
            p3.next = p2;
            p2 = p2.next;
            p3 = p3.next;
        }
        return dummyNode.next;
    }
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static void main(String arg[]){
        prob34 ll1 = new prob34();
        prob34 ll2 = new prob34();
        ll1.addToLast(5);
        ll1.addToLast(10);
        ll1.addToLast(15);
    
        // list 2
        ll2.addToLast(2);
        ll2.addToLast(3);
        ll2.addToLast(20);
  
        ll1.head = ll1.merge(ll1.head, ll2.head);
        ll1.printList();

    }
}
