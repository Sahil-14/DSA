/**
 * remove loop
 * 
 */

public class prob6 {
  void detectAndRemoveLoop(Node node) {
    if (node == null || node.next == null) {
      return;
    }
    Node slow = node, fast = node;

    // Move slow and fast 1 and 2 steps
    // ahead respectively.
    slow = slow.next;
    fast = fast.next.next;

    while (fast != null && fast.next != null) {
      if (slow == fast) {
        break;
      }
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

}
