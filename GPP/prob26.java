public class prob26 {
    Node head = null;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    void insertAtTail(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;  
    }
    void insertAtHead(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
    }
    void delete(int key){
        Node temp = head;
        while(temp.next.data != key){
            temp = temp.next;
        }
        Node todelete = temp.next;
        temp.next = temp.next.next;
        todelete = null;
        
    }
    boolean search(int key){
        Node temp = head;
        while(temp != null){
            if(temp.data == key){
            
                return true;
            } 
            temp = temp.next;

        }
        return false;
    }

    void display(){
        Node temp = head;
        while(temp!= null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public static void main(String arg[]){
        
    }
}
