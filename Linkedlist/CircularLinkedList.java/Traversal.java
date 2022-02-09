public class  Traversal{
    class Node{
        int data ;
        Node next ;
        
    }

    Node push(Node head,int data){
        Node ptr1 = new Node();
        Node temp = head;
        ptr1.data = data;
        ptr1.next = head;
         /* If linked list is not null
    then set the next of last node */
    if(head != null){
        while(temp.next != head){
            temp = temp.next;
        }
        temp.next = ptr1;
    }else{
        ptr1.next = ptr1;
    }
    head = ptr1;
    return head;
    }

    void printlist(Node head){
        Node temp = head;
        if(head != null){
            do{
                System.out.print(temp.data+" ");
                temp = temp.next;
            }while(temp != head);
        }
    }
    public static void main(String arg[]){
        Node head = null;
        Traversal cll = new Traversal();
        head = cll.push(head, 12);
        head = cll.push(head, 56);
        head = cll.push(head, 2);
        head = cll.push(head, 11);
        System.out.println("Contents of Circular " +
        "Linked List:");
        cll.printlist(head);
    }
    
}