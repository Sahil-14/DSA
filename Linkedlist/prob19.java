/**
 * circular ll traversal and counting
 * 
 */

public class prob19 {
  Node push(Node head, int data) {
    Node ptr1 = new Node();
    Node temp = head;
    ptr1.data = data;
    ptr1.next = head;
    /*
     * If linked list is not null
     * then set the next of last node
     */
    if (head != null) {
      while (temp.next != head) {
        temp = temp.next;
      }
      temp.next = ptr1;
    } else {
      ptr1.next = ptr1;
    }
    head = ptr1;
    return head;
  }

  void printlist(Node head) {
    Node temp = head;
    if (head != null) {
      do {
        System.out.print(temp.data + " ");
        temp = temp.next;
      } while (temp != head);
    }
  }

  int countNode(Node head) {
    Node temp = head;
    int result = 0;
    if (head != null) {
      do {
        result++;
        temp = temp.next;
      } while (temp != head);
    }
    return result;
  }
}
