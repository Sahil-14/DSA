
/**]
 * remove duplicates from sorted list
 * 
 */

import java.util.HashMap;

public class RemoveDuplicateFromSortedlist {
  Node head;

  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      next = null;
    }
  }

  // for sorted
  void removeDuplicate() {
    Node current = head;
    while (current != null) {
      Node temp = current;
      while (temp != null && temp.data == current.data) {
        temp = temp.next;
      }
      current.next = temp;
      current = current.next;

    }
  }

  Node removeDuplicateRec(Node head) {
    Node to_free;
    if (head == null)
      return null;
    if (head.next != null) {
      if (head.data == head.next.data) {
        to_free = head.next;
        head.next = head.next.next;
        removeDuplicateRec(head);
      } else {
        /* This is tricky: only advance if no deletion */
        removeDuplicate(head.next);
      }
    }

  }

  // for unsorted
  void removerDuplicateUsingHashing() {
    HashMap<Integer, Boolean> hm = new HashMap<>();
    Node temp = head;
    while (temp != null) {
      if (!hm.containsKey(temp.data)) {
        System.out.print(temp.data + " ");
      }
      hm.put(temp.data, true);
      temp = temp.next;
    }
    return head;
  }

  void removeDuplicatesUsingTwoPointer() {
    Node prev = head, temp = head;
    while (temp != null) {
      if (temp.data != prev.data) {
        prev.next = temp;
        prev = temp;
      }
      temp = temp.next;
    }
    /*
     * This is the edge case if there are more than one occurrences of the last
     * element
     */
    if (prev != temp) {
      prev.next = null;
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
    RemoveDuplicateFromSortedlist llist = new RemoveDuplicateFromSortedlist();
    llist.push(20);
    llist.push(20);
    llist.push(13);
    llist.push(11);
    llist.push(11);
    llist.push(11);
    // llist.printdata();
    // llist.removeDuplicate();
    // llist.removerDuplicateUsingHashing();
    // llist.removeDuplicatesUsingTwoPointer();
    llist.removeDuplicateRec(llist.head);
    System.out.println();
    llist.printdata();
  }
}
