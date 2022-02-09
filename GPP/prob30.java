public class prob30 {
    class Node {
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    void insertAtTail(Node head,int val){
        Node n = new Node(val);
        if(head == null){
            head = n;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = n;
        n.prev = temp;
    }
    void insertAtHead(Node head,int val){
        Node n = new Node(val);
       
        n.next = head;
        if(head != null){
            head.prev = n;
        }
     
        head = n;

    }
    void deleteAtHead(Node head){
        Node todelete = head;
        head = head.next;
        head.prev = null;
        todelete.next = null;
    }
    void delete(Node head,int pos){
        if(head == null || pos <= 0){
            return ;
        }
        if(pos == 1){
            deleteAtHead(head);
        }

        Node temp = head;
        int count = 0;
        while(temp != null && count != pos){
            temp  = temp.next;
            count++;
        }
        
        temp.prev.next = temp.next;

        if(temp.next != null){
            temp.next.prev = temp.prev;
        }
   
    }

    void display(Node head){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public static void main(String arg[]){

    }
}
