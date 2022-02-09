/**
 * 
 * Why Circular? In a singly linked list, for accessing any node of the linked
 * list, we start traversing from the first node. If we are at any node in the
 * middle of the list, then it is not possible to access nodes that precede the
 * given node. This problem can be solved by slightly altering the structure of
 * a singly linked list. In a singly linked list, the next part (pointer to next
 * node) is NULL. If we utilize this link to point to the first node, then we
 * can reach the preceding nodes. Refer to this for more advantages of circular
 * linked lists.
 * 
 * To implement a circular singly linked list, we take an external pointer that
 * points to the last node of the list. If we have a pointer last pointing to
 * the last node, then last -> next will point to the first node.
 * 
 * Why have we taken a pointer that points to the last node instead of the first
 * node? For the insertion of a node at the beginning, we need to traverse the
 * whole list. Also, for insertion at the end, the whole list has to be
 * traversed. If instead of start pointer, we take a pointer to the last node,
 * then in both cases there won’t be any need to traverse the whole list. So
 * insertion at the beginning or at the end takes constant time, irrespective of
 * the length of the list.
 * 
 * Insertion A node can be added in three ways:
 * 
 * Insertion in an empty list Insertion at the beginning of the list Insertion
 * at the end of the list Insertion in between the nodes
 * 
 */

public class CircularSignlyLinkedList {
    class Node {
        int data;
        Node next;
    }

    Node addToEmpty(Node last, int data) {
        if (last != null) {
            return last;
        }
        Node temp = new Node();
        temp.data = data;
        last = temp;
        last.next = last;
        return last;
    }

    Node addToBegining(Node last, int data) {
        if (last == null) {
            return addToEmpty(last, data);
        }
        Node temp = new Node();
        temp.data = data;
        temp.next = last.next;
        last.next = temp;
        return last;
    }

    Node addToEnd(Node last, int data) {
        if (last == null) {
            return addToEmpty(last, data);
        }
        Node temp = new Node();
        temp.data = data;
        temp.next = last.next;
        last.next = temp;
        last = temp;
        return last;
    }

    Node addAfter(Node last, int data, int item) {
        if (last == null)
            return null;
        Node temp, p;
        p = last.next;
        do {
            if (p.data == item) {
                temp = new Node();
                temp.data = item;
                temp.next = p.next;
                p.next = temp;
                if (p == last)
                    last = temp;
                return last;
            }
            p = p.next;
        } while (p != last.next);
        System.out.println(item + " not present in the list.");
        return last;
    }

    void traverse(Node last) {
        Node p;
        if (last == null) {
            System.out.println("List is empty.");
            return;
        }
        p = last.next;
        do {
            System.out.print(p.data + " ");
            p = p.next;
        } while (p != last.next);
    }

    public static void main(String arg[]) {
        CircularSignlyLinkedList ll = new CircularSignlyLinkedList();
        Node last = null;
        last = ll.addToEmpty(last, 6);
        last = ll.addToBegining(last, 4);
        last = ll.addToBegining(last, 2);
        last = ll.addToEnd(last, 8);
        last = ll.addToEnd(last, 12);
        last = ll.addAfter(last, 10, 8);
    }
}
