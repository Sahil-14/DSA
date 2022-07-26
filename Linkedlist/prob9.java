import java.util.*;

//reverse ll
public class prob9 {
  Node head = null;

  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }

  }

  public void push(int new_data) {
    Node new_node = new Node(new_data);

    new_node.next = head;

    head = new_node;
  }

  void reverse() {
    Node prev = null;
    Node current = head;
    Node next = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    head = prev;
  }

  Node reverseRec(Node head) {
    if (head == null || head.next == null)
      return head;
    /*
     * reverse the rest list and put the first element at the end
     */
    Node rest = reverseRec(head.next);
    head.next.next = head;
    head.next = null;
    return rest;
  }

  void reverseLLUsingStack() {
    Stack<Node> s = new Stack<>();
    Node temp = head;
    while (temp.next != null) {
      s.add(temp);
      temp = temp.next;
    }
    head = temp;
    while (!s.isEmpty()) {
      temp.next = s.peek();
      s.pop();
      temp = temp.next;
    }
    temp.next = null;
  }

  // reverse k node in group
  Node reverseKNodeInGroup(Node head, int k) {
    Node curr = head;
    Node prev = null;
    Node next = null;
    int count = 0;
    while (curr != null && count < k) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      count++;
    }

    if (next != null) {
      head.next = reverseKNodeInGroup(next, k);
    }

    return prev;
  }

  void printList(Node node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
  }

  public static void main(String arg[]) {
    prob9 ll = new prob9();
    ll.push(5);
    ll.push(4);
    ll.push(3);
    ll.push(2);
    ll.push(1);
    ll.printList(ll.head);
    ll.reverse();
    System.out.println();
    ll.printList(ll.head);
  }
}
