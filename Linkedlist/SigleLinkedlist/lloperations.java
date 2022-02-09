class lloperations {
    Node head = null;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        if (head == null)
            head = new_node;
        else {
            new_node.next = head;
            head = new_node;
        }
    }

    public void append(int new_data) {
        Node new_node = new Node(new_data);

        if (head == null) {
            head = new_node;
            return;
        }
        new_node.next = null;

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
        return;

    }

    public void insertAfter(Node prev_node, int new_data) {
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    public void deleteNode(int key) {
        //
        Node temp = head, prev = null;
        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }
        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            return;
        }
        prev.next = temp.next;
    }
    // delete at givan position
    public void deleteAtK(int position){
        if(head == null)
            return;
        Node temp = head;
        if(position == 0){
            head = temp.next;
            return;
        }

        for(int i = 0;temp != null && i<position-1;i++){
            temp = temp.next;
        }
        if(temp == null || temp.next == null)
            return;
        Node next = temp.next.next;
        temp.next = next;
    }
    public void deleteList(){
        head = null;
    }
    public int getCount(){
        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public int getCountRec(Node node){
        if(node == null){
            return 0;
        }
        return 1+ getCountRec(node.next);
    }
    public void printList() {
        Node tnode = head;
        if(tnode == null){
            System.out.println("Linkedlist is empty");
        }
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    public static void main(String arg[]) {
        lloperations llop = new lloperations();
        llop.append(6);
        llop.push(7);
        llop.push(1);
        llop.append(4);
        llop.insertAfter(llop.head.next, 8);
        System.out.println("\nCreated Linked list is: ");
        llop.printList();
        System.out.println("\nSize of list is "+llop.getCount());
        llop.deleteAtK(4);
        System.out.println("\nSize of list is "+llop.getCountRec(llop.head));
        System.out.println();
        llop.printList();
        // llop.deleteList();
        llop.printList();
    }
}