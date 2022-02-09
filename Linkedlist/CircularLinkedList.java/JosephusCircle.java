public class JosephusCircle {
    static class Node{
        public int data;
        public Node next;
        public Node(int data){
            this.data = data;
            
        }
    }
    static void getJosePhusPosition(int m,int n){
         // Create a circular linked list of
        // size N.
        Node head = new Node(1);
        Node prev = head;
        for(int i = 2;i<=n;i++){
            prev.next = new Node(i);
            prev = prev.next;
        }

        prev.next = head;
        /* while only one node is left in the
        linked list*/
        Node ptr1 = head,ptr2 = head;
        while(ptr1.next != ptr1){
            // Find m-th nod
            int count = 1;
            while(count != m){
                ptr2 = ptr1;
                ptr1 = ptr1.next;
                count++;
            }
            ptr2.next = ptr1.next;
            ptr1 = ptr1.next;
        }
        System.out.println ("Last person left standing " +
        "(Josephus Position) is " + ptr1.data);
    }
    public static void main(String arg[]){
        int n = 14, m = 2;
        getJosePhusPosition(m, n);
    }
}
