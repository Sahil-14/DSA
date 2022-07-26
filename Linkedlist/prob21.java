/**
 * swap first and last node of circular ll
 * 
 */

class prob21 {
  Node exchangeNode(Node head) {
    // if length of list is 2
    if (head.next.next == head) {
      head = head.next;
      return head;
    }
    Node p = head;
    while (p.next.next != head) {
      p = p.next;
    }
    p.next.next = head.next;
    head.next = p.next;
    p.next = head;
    head = head.next;
    return head;
  }
}