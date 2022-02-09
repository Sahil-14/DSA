// circular linked list
public class prob35 {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void insertAtHead(int val) {
        Node node = new Node(val);
        Node temp = head;
        if (head == null) {
            node.next = node;
            head = node;
        }
        while (temp.next != head) {
            temp = temp.next;
        }
        node.next = head;
        temp.next = node;
        head = node;
    }

    void insertAtTail(int val) {
        Node temp = head;
        Node node = new Node(val);
        if (head == null) {
            head = node;
            head.next = head;
            return;
        }
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = node;
        node.next = head;
    }

    void display() {
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
    void  deleteAtHead(){
        Node temp = head;
        while(temp.next != head){
            temp = temp.next;

        }
        Node todelet = head;
        temp.next = head.next;
        head = head.next;
        todelet.next = null;
    }
    void deleteNode(int pos){
        if(head == null){
            return ;
        }
        if(pos == 1){
            deleteAtHead();
            return;
        }
        Node temp = head;
        int count =1;
        while(count != pos -1){
            temp = temp.next;
            count++;
        }
        Node tedelete = temp.next;
        temp.next = temp.next.next;
    tedelete.next = null;

    }

    public static void main(String arg[]) {
        prob35 cll = new prob35();
        cll.insertAtTail(1);
        cll.insertAtTail(2);
        cll.insertAtTail(3);
        cll.insertAtTail(4);
        cll.display();
    }
}
