public class Count {
    class Node{
        int data;
        Node next;
    }
    Node push(Node head,int data){
        Node ptr1 = new Node();
        Node temp = head;
        ptr1.data = data;
        ptr1.next = head;
        if(temp != null){
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
    int countNode(Node head){
        Node temp = head;
        int result = 0;
        if(head != null){
            do{
                result++;
                temp = temp.next;
            }while(temp != head);
        }
        return result;
    }
    public static void main(String arg[]){
        Node head = null;
        Count ll = new Count();
        head = ll.push(head, 12); 
        head = ll.push(head, 56); 
        head = ll.push(head, 2); 
        head = ll.push(head, 11);
        System.out.printf("%d", ll.countNode(head)); 
    }
}
