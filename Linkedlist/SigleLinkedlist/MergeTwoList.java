

public class MergeTwoList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node push(int new_data, Node head) {
        Node new_node = new Node(new_data);

        new_node.next = head;

        head = new_node;
        return head;
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
//  method 1
    Node sort(Node head1,Node head2){
        Node dummyNode = new Node(0);
        Node tail = dummyNode;
        while(true){
            if(head1 == null){
                tail.next = head2;
                break;
            }
            if(head2 == null){
                tail.next = head1;
                break;
            }
            if(head1.data < head2.data){
                tail.next = head1;
                head1 = head1.next;
            }else{
                tail.next = head2;
                head2 = head2.next;
            }   
            tail = tail.next;
        }
        return dummyNode.next;
    }
    // Method 2
    Node sortedMerge2(Node A,Node B){
        if(A == null ){
            return B;
        }
        if(B == null){
            return A;
        }
        if(A.data < B.data){
            A.next = sortedMerge2(A.next, B);
            return A;
        }else{
            B.next = sortedMerge2(A, B.next);
            return B;
        }
    }
    

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    void reverse(Node head){
        Node prev = null;
        Node current = head;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        head = prev;
    }
    // Method 3;
   

    public static void main(String arg[]) {
        MergeTwoList ll1 = new MergeTwoList();
        MergeTwoList ll2 = new MergeTwoList();
        ll1.addToLast(5);
        ll1.addToLast(10);
        ll1.addToLast(15);
       
        // list 2
        ll2.addToLast(2);
        ll2.addToLast(3);
        ll2.addToLast(20);

        ll1.head = ll1.sortedMerge2(ll1.head, ll2.head);
        ll1.printList();
    }
}
