/**
 * Rotate a Linked List
 * Given a singly linked list, rotate the linked list counter-clockwise by k
 * nodes. Where k is a given positive integer. For example, if the given linked
 * list is 10->20->30->40->50->60 and k is 4, the list should be modified to
 * 50->60->10->20->30->40. Assume that k is smaller than the count of nodes in a
 * linked list.
 * 
 * 
 */

public class prob18 {
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

  void rotate(int k) {
    if (k == 0) {
      return;
    }
    Node current = head;
    int count = 1;
    while (count < k && current != null) {
      count++;
      current = current.next;
    }
    if (current == null) {
      return;
    }

    Node kthNode = current;

    while (current.next != null) {
      current = current.next;
    }

    current.next = head;
    head = kthNode.next;
    kthNode.next = null;
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

  void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  /* Driver program to test above functions */
  public static void main(String args[]) {
    prob18 llist = new prob18();

    // create a list 10->20->30->40->50->60
    for (int i = 60; i >= 10; i -= 10)
      llist.push(i);

    System.out.println("Given list");
    llist.printList();

    llist.rotate(7);

    System.out.println("Rotated Linked List");
    llist.printList();
  }

}
