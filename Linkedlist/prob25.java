/**
 * 12->15->10->11->5->6->2->3->NULL
 * 11-10-15-12
 * 15->11->6->3->NULL
 * 
 * delete node having greater value on right
 * 
 * revese and small
 * 
 */


/*
 * 2) In the reversed list, delete nodes which
 * have a node with greater value node on left
 * side. Note that head node is never deleted
 * because it is the leftmost node.
 */
public class prob25 {
  Node head; // head of list

  /* Linked list Node */
  class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  void reverseList() {

    Node current = head, prev = null, next = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    head = prev;

  }

  void delLesserNodes() {
    /* 1.Reverse the linked list */
    reverseList();

    /*
     * 2) In the reversed list, delete nodes which
     * have a node with greater value node on left
     * side. Note that head node is never deleted
     * because it is the leftmost node.
     */
    _delLesserNodes2();

    /*
     * 3) Reverse the linked list again to retain
     * the original order
     */
    reverseList();
  }

  void _delLesserNodes() {
    Node current = head;
    Node maxNode = head;
    Node temp;
    while (current != null && current.next != null) {
      if (current.next.data < maxNode.data) {
        temp = current.next;
        current.next = temp.next;
        temp = null;
      } else {
        current = current.next;
        maxNode = current;
      }
    }
  }

 

  void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  void push(int new_data) {
    /*
     * 1 & 2: Allocate the Node &
     * Put in the data
     */
    Node new_node = new Node(new_data);

    /* 3. Make next of new Node as head */
    new_node.next = head;

    /* 4. Move the head to point to new Node */
    head = new_node;
  }

  public static void main(String args[]) {
    prob25 llist = new prob25();

    /*
     * Constructed Linked List is 12->15->10->11->
     * 5->6->2->3
     */
    llist.push(3);
    llist.push(2);
    llist.push(6);
    llist.push(5);
    llist.push(11);
    llist.push(10);
    llist.push(15);
    llist.push(12);

    System.out.println("Given Linked List");
    llist.printList();

    llist.delLesserNodes();

    System.out.println("Modified Linked List");
    llist.printList();
  }
}
