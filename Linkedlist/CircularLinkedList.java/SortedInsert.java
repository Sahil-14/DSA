class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
public class SortedInsert {
   

    Node head = null;

    void sortedInsert(Node new_node) {
        Node current = head;
        // case 1 : head is null
        if(current == null){
            new_node.next = new_node;
            head = new_node;
        }

        // case 2: new node is to be inserted at head;
        else if(current.data >= new_node.data){
            while(current.next != head){
                current = current.next;
            }
            current.next = new_node;
            new_node.next = head;
            head = new_node;
        }
        // case 3 : insert at correct position
        else{
            while(current.next != head && current.next.data < new_node.data){
                current = current.next;
            }
            new_node.next = current.next;
            current.next = new_node;
        }
    }

    void printList(){
        if(head != null){
            Node temp = head;
            do{
                System.out.print(temp.data+" ");
                temp = temp.next;
            }while(temp != head);
        }
    }
    public static void main(String arg[]){
        SortedInsert ll = new SortedInsert();
        int arr[] = new int[] {12, 56, 2, 11, 1, 90};
        Node temp = null;
        for(int i = 0;i<arr.length;i++){
            temp = new Node(arr[i]);

            ll.sortedInsert(temp);
        }
        ll.printList();
    }
}
