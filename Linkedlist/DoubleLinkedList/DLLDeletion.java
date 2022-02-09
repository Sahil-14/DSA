

public class DLLDeletion {
    Node head;

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void push(int data) {
        Node new_node = new Node(data);

        if (head == null) {
            head = new_node;

            return;
        }
        new_node.next = head;
        new_node.prev = null;

        if (head != null) {
            head.prev = new_node;
        }
        head = new_node;
    }

    void printList() {
        Node temp = head;
        Node last = null;
        System.out.println("Traversal in forward Direction");
        while (temp != null) {
            System.out.print(temp.data + " ");
            last = temp;
            temp = temp.next;
        }
        System.out.println("Traversal in backword Direction");
        while(last != null){
            System.out.print(last.data + " ");
            last = last.prev;
        }
        System.out.println();
    }

    void deleteNode(Node del) {
        // base case
        if (head == null || del == null) {
            return;
        }
        //head to be delete
        if (head == del) {
            head = head.next;

        }
        // Change next only if node to be deleted
        // is NOT the last node
        if (del.next != null) {
            del.next.prev = del.prev;

        }
        // Change prev only if node to be deleted
        // is NOT the first node
        if (del.prev != null) {
            del.prev.next = del.next;
        }
        return;
    }

    public static void main(String arg[]) {
        DLLDeletion dll = new DLLDeletion();
        dll.push(2);
        dll.push(4);
        dll.push(8);
        dll.push(10);

        System.out.print("Created DLL is: ");
        dll.printList();
        dll.deleteNode(dll.head);
        System.out.print("\nList after deleting first node: ");
        dll.printList();
    }
}


// del.prev.next = del.next
//del.next.prev = del.prev
