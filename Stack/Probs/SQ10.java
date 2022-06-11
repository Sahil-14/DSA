package Probs;

/**
 * 
 * 
 * Design a stack with operations on middle element
 * 
 */
public class SQ10 {
  class DLLNode {
    DLLNode prev;
    int data;
    DLLNode next;

    DLLNode(int data) {
      this.data = data;
      this.prev = null;
      this.prev = null;
    }
  }

  DLLNode head;
  DLLNode mid;
  int count;

  /* Function to push an element to the stack */
  void push(int new_data) {

    /* allocate DLLNode and put in data */
    DLLNode new_DLLNode = new DLLNode(new_data);

    /*
     * Since we are adding at the beginning,
     * prev is always NULL
     */
    new_DLLNode.prev = null;

    /* link the old list off the new DLLNode */
    new_DLLNode.next = head;

    /* Increment count of items in stack */
    count += 1;

    /*
     * Change mid pointer in two cases
     * 1) Linked List is empty
     * 2) Number of nodes in linked list is odd
     */
    if (count == 1) {
      mid = new_DLLNode;
    } else {
      head.prev = new_DLLNode;

      if ((count % 2) != 0) // Update mid if ms->count is odd
        mid = mid.prev;
    }

    /* move head to point to the new DLLNode */
    head = new_DLLNode;

  }

  /* Function to pop an element from stack */
  int pop() {
    /* Stack underflow */
    if (count == 0) {
      System.out.println("Stack is empty");
      return -1;
    }

    DLLNode head = head;
    int item = head.data;
    head = head.next;

    // If linked list doesn't become empty, update prev
    // of new head as NULL
    if (head != null)
      head.prev = null;

    count -= 1;

    // update the mid pointer when we have even number of
    // elements in the stack, i,e move down the mid pointer.
    if (count % 2 == 0)
      mid = mid.next;

    return item;
  }

  // Function for finding middle of the stack
  int findMiddle() {
    if (count == 0) {
      System.out.println("Stack is empty now");
      return -1;
    }
    return mid.data;
  }
}
