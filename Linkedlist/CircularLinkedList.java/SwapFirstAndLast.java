public class SwapFirstAndLast {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node push(Node head, int data) {
        Node ptr1 = new Node(data);
        Node temp = head;
        ptr1.next = head;

        if (head != null) {
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = ptr1;
        } else {
            ptr1.next = ptr1;
        }
        head = ptr1;
        return head;
    }

    Node exchangeNode(Node head) {
        // if length of list is 2
        if (head.next.next == head) {
            head = head.next;
            return head;
        }
        Node p = head;
        while (p.next.next != head) {
            p = p.next;
        }
        p.next.next = head.next;
        head.next = p.next;
        p.next = head;
        head = head.next;
        return head;
    }

    void printList(Node head) {
        Node temp = head;
        if(head != null){
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
        }
       
    }

    public static void main(String arg[]) {
        SwapFirstAndLast ll = new SwapFirstAndLast();
        Node head = null;
        head = ll.push(head, 6);
        head = ll.push(head, 5);
        head = ll.push(head, 4);
        head = ll.push(head, 3);
        head = ll.push(head, 2);
        head = ll.push(head, 1);
        head = ll.exchangeNode(head);
        ll.printList(head);
    }
}
