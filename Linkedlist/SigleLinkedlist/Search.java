public class Search {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    public void push(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean searchRec(Node head,int data){
        Node current = head;
        if(current == null){
            return false;
        }
        if(current.data == data){
            return true;
        }
        return searchRec(current.next, data);
        
    }

    public static void main(String arg[]) {
        Search ll = new Search();
        ll.push(10);
        ll.push(20);
        ll.push(30);
        ll.push(40);
        ll.push(50);
        if (ll.searchRec( ll.head,23))
        System.out.println("Yes");
    else
        System.out.println("No");
    }
}
