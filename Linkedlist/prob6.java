
/**
 * remove loop
 * 
 */
import java.util.*;

public class prob6 {

  static Node head;

  static class Node {

    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  // Function that detects loop in the list
  void detectAndRemoveLoop(Node node) {

    // If list is empty or has only one node
    // without loop
    if (node == null || node.next == null)
      return;

    Node slow = node, fast = node;

    // Move slow and fast 1 and 2 steps
    // ahead respectively.
    slow = slow.next;
    fast = fast.next.next;

    // Search for loop using slow and fast pointers
    while (fast != null && fast.next != null) {
      if (slow == fast)
        break;

      slow = slow.next;
      fast = fast.next.next;
    }

    /* If loop exists */
    if (slow == fast) {
      slow = node;
      if (slow != fast) {
        while (slow.next != fast.next) {
          slow = slow.next;
          fast = fast.next;
        }
        /* since fast->next is the looping point */
        fast.next = null; /* remove loop */
      }
      /* This case is added if fast and slow pointer meet at first position. */
      else {
        while (fast.next != slow) {
          fast = fast.next;
        }
        fast.next = null;
      }
    }
  }

  void detectAndRemoveLoop() {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        Node p1 = slow;
        Node p2 = head;

        while (p1.next != p2.next) {
          p1 = p1.next;
          p2 = p2.next;
        }
        p1.next = null;
      }
    }
  }

  // Function to print the linked list
  void printList(Node node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
  }

  // Driver code
  public static void main(String[] args) {
    prob6 list = new prob6();
    list.head = new Node(50);
    list.head.next = new Node(20);
    list.head.next.next = new Node(15);
    list.head.next.next.next = new Node(4);
    list.head.next.next.next.next = new Node(10);

    // Creating a loop for testing
    head.next.next.next.next.next = head.next.next;
    list.detectAndRemoveLoop();
    System.out.println("Linked List after removing loop : ");
    list.printList(head);
  }
}
