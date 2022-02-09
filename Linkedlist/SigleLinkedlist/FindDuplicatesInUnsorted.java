import java.util.HashSet;

public class FindDuplicatesInUnsorted {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    void removeDuplicateByTwoLoops() {
        Node ptr1 = null, ptr2 = null;
        Node dup = null;
        ptr1 = head;
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;
            while (ptr2.next != null) {
                if (ptr1.data == ptr2.next.data) {
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;
                    System.gc();
                } else {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }

    void removeDuplicateUsingHashing() {
        HashSet<Integer> hs = new HashSet<>();
        Node current = head;
        Node prev = null;
        while (current != null) {
            int curval = current.data;
            if (hs.contains(curval)) {
                prev.next = current.next;
            } else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }

    }

    public void push(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    void printdata() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String arg[]) {
        FindDuplicatesInUnsorted ll = new FindDuplicatesInUnsorted();
        ll.push(10);
        ll.push(12);
        ll.push(11);
        ll.push(11);
        ll.push(12);
        ll.push(11);
        ll.push(10);
        ll.push(17);
        // ll.removeDuplicateUsingHashing();
        ll.removeDuplicateByTwoLoops();
        ll.printdata();
    }
}