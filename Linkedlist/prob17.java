/**
 * 
 * Segregate even and odd nodes in a Linked List
 * Input: 17->15->8->12->10->5->4->1->7->6->NULL
 * Output: 8->12->10->4->6->17->15->5->1->7->NULL
 * 
 * Input: 8->12->10->5->4->1->6->NULL
 * Output: 8->12->10->4->6->5->1->NULL
 * 
 * // If all numbers are even then do not change the list
 * Input: 8->12->10->NULL
 * Output: 8->12->10->NULL
 * 
 */

public class prob17 {
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

  public void segregateEvenOdd() {
    Node evenStart = null;
    Node evenEnd = null;
    Node oddStart = null;
    Node oddEnd = null;
    Node current = head;

    while (current != null) {
      int val = current.data;
      // if even
      if (val % 2 == 0) {
        if (evenStart == null) {
          evenStart = current;
          evenEnd = current;
        } else {
          evenEnd.next = current;
          evenEnd = evenEnd.next;
        }
      } else {
        // if odd
        if (oddStart == null) {
          oddStart = current;
          oddEnd = current;
        } else {
          oddEnd.next = current;
          oddEnd = oddEnd.next;
        }
      }
      current = current.next;
    }

    if (oddStart == null || evenStart == null) {
      return;
    }

    evenEnd.next = oddStart;
    oddEnd.next = null;
    head = evenStart;

  }

  // if sorted

  void rearrangeEvenOdd(Node head) {
    Node odd = head;
    Node even = head.next;
    Node evenstart = even;
    while (odd.next != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;

    }
    if (odd != null) {
      odd.next = evenstart;
    }
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

  // Utility function to print a linked list
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
    prob17 llist = new prob17();
    llist.push(11);
    llist.push(10);
    llist.push(9);
    llist.push(6);
    llist.push(4);
    llist.push(1);
    llist.push(0);
    System.out.println("Original Linked List");
    llist.printList();

    llist.segregateEvenOdd();

    System.out.println("Modified Linked List");
    llist.printList();
  }

}
