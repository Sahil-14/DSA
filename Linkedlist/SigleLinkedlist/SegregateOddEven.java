public class SegregateOddEven {
    Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    void segregateEvenOdd1(){
        Node end = head;
        Node prev = null;
        Node curr = head;
        while(end.next != null){
            end = end.next;
        }
        Node new_end = end;
        // consider all odd number before even number
        while(curr.data % 2 != 0 && curr != end){
            new_end = curr;
            curr = curr.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }
        //do following steps only if there if even node

    }
}
