/**
 * get nth node
 * 
 */

public class prob7 {
  public int getNth(int index) {

    Node current = head;
    if (current == null) {
      return -1;
    }
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    if (current == null) {
      return -1;
    }
    return current.data;
  }


  

  public int getNthRec(Node head, int n) {
    int count = 0;
    if (head == null) // edge case - if head is null
      return -1;
    // if count equal too n return node.data
    if (count == n)
      return head.data;

    // recursively decrease n and increase
    // head to next pointer
    return getNthRec(head.next, n - 1);
  }
}
