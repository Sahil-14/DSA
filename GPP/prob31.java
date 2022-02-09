//append last k nodes of to start of linked list;

// 1 -> 2 -> 3-> 4-> 5-> 6-> 
//op : (k == 3)
// 4-> 5-> 6-> 1 -> 2 -> 3
public class prob31 {
    Node head = null;

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    int length() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;

        }
        return count;
    }

    Node kappend(int k) {
        Node newHead = null;
        Node newTail = null;
        Node tail = head;
        int l = length();
        // if k > l
        k = k % l;
        int count = 1;
        while (tail.next != null) {
            if (count == l - k) {
                newTail = tail;
            }
            if (count == l - k + 1) {
                newHead = tail;
            }
            tail = tail.next;
            count++;
        }
        System.out.println(newTail.data);
        System.out.println(newHead.data);
        newTail.next = null;
        tail.next = newHead;
        return newHead;

    }

    void display(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    void insertAtHead(int val) {
        Node n = new Node(val);

        n.next = head;
        if (head != null) {
            head.prev = n;
        }

        head = n;

    }

    public static void main(String arg[]) {

        prob31 ll = new prob31();
        ll.insertAtHead(6);
        ll.insertAtHead(5);
        ll.insertAtHead(4);
        ll.insertAtHead(3);
        ll.insertAtHead(2);
        ll.insertAtHead(1);
        // ll.display();
        // System.out.println(ll.length());
        Node nn = ll.kappend(3);
        ll.display(nn);

    }
}
