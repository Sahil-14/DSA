class GetNthNode {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head = null;

    public void push(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    public int getNth(int index) {

        Node current = head;
        if (current == null) {
            return -1;
        }
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (current == null) {
            return -1;
        }
        return current.data;
    }

    public int getNthRec(Node head, int n) {
        int count = 0;
        if (head == null) // edge case - if head is null
            return -1;
        // if count equal too n return node.data
        if (count == n)
            return head.data;

        // recursively decrease n and increase
        // head to next pointer
        return getNthRec(head.next, n - 1);
    }

    public void printList() {
        Node tnode = head;
        if (tnode == null) {
            System.out.println("Linkedlist is empty");
        }
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    public static void main(String arg[]) {
        GetNthNode ll = new GetNthNode();
        ll.push(10);

        ll.push(20);
        ll.push(30);
        ll.push(40);
        ll.push(50);
        ll.printList();
        System.out.println();
        System.out.printf("Element at index 4 is %d", ll.getNth(4));
        System.out.printf("Element at index 4 is %d", ll.getNthRec(ll.head,4));

    }
}
