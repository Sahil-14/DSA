//delete node from circular ll
public class prob22 {
  class Node {
    int data;
    Node next;
  }

  Node push(Node head, int data) {
    Node ptr1 = new Node();
    ptr1.data = data;
    ptr1.next = head;

    if (head != null) {
      Node temp = head;
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

  void printList(Node head) {
    Node temp = head;
    if (head != null) {
      do {
        System.out.print(temp.data + " ");
        temp = temp.next;
      } while (temp != head);
    }
  }

  Node deleteNode(Node head, int key) {
    if (head == null)
      return null;

    Node curr = head, prev = new Node();
    while (curr.data != key) {
      if (curr.next == head) {
        System.out.println("Node not found");
        break;
      }
      prev = curr;
      curr = curr.next;
    }
    // if only one node
    if (curr == head && curr.next == head) {
      head = null;
      return head;
    }
    // if there are more than 1 node
    // if first node
    if (curr == head) {
      prev = head;
      while (prev.next != head) {
        prev = prev.next;
      }
      head = curr.next;
      prev.next = head;
    }
    // check if it is last node
    else if (curr.next == head) {
      prev.next = head;
    } else {
      prev.next = curr.next;
    }
    return head;
  }

  public static void main(String arg[]) {
    prob22 ll = new prob22();
    Node head = null;
    head = ll.push(head, 2);
    head = ll.push(head, 5);
    head = ll.push(head, 7);
    head = ll.push(head, 8);
    head = ll.push(head, 10);

    System.out.println("List before deletion");
    ll.printList(head);
    head = ll.deleteNode(head, 70);
    System.out.println("List after deletion");
    ll.printList(head);
  }
}
