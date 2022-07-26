
/**]
 * 
 * reverse double linked list
 */
import java.util.Stack;

public class prob16 {
  Node head;

  class Node {
    int data;
    Node next, prev;

    Node(int data) {
      this.data = data;
      prev = next = null;
    }
  }

  void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
  }

  void push(int new_data) {
    Node new_node = new Node(new_data);
    if (head == null) {
      head = new_node;
      return;
    }

    new_node.next = head;
    head.prev = new_node;
    head = new_node;
  }

  // method 1 swap link
  void reverse() {
    Node temp = null;
    Node current = head;
    while (current != null) {
      temp = current.prev;
      current.prev = current.next;
      current.next = temp;
      current = current.prev;
    }

    if (temp != null) {
      head = temp.prev; // imp
    }
  }

  // method :2 swap data;
  void reverse2() {
    Stack<Integer> s = new Stack<>();
    Node temp = head;
    while (temp != null) {
      s.add(temp.data);
      temp = temp.next;
    }
    temp = head;
    while (!s.isEmpty()) {
      temp.data = s.pop();
      temp = temp.next;
    }
  }

  public static void main(String arg[]) {
    prob16 dll = new prob16();
    dll.push(5);
    dll.push(4);
    dll.push(3);
    dll.push(2);
    dll.push(1);
    dll.printList();
    System.out.println();
    System.out.println("The reversed Linked List is ");
    dll.reverse();
    dll.printList();
    System.out.println();
    System.out.println("The reversed Linked List2 is ");
    dll.reverse2();
    dll.printList();
  }
}
