public class RearrangeList {
  static Node head; // head of the list

  /* Node Class */
  static class Node {

    int data;
    Node next;

    // Constructor to create a new node
    Node(int d) {
      data = d;
      next = null;
    }
  }

  void printlist(Node node) {
    if (node == null) {
      return;
    }
    while (node != null) {
      System.out.print(node.data + " -> ");
      node = node.next;
    }
  }

  Node reverselist(Node node) {
    Node prev = null, curr = node, next;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    node = prev;
    return node;
  }

  void rearrange(Node node) {
    Node slow_ptr = node, fast_ptr = node;
    while (fast_ptr != null && fast_ptr.next != null) {
      slow_ptr = slow_ptr.next;
      fast_ptr = fast_ptr.next.next;
    }

    Node node1 = node;
    Node node2 = slow_ptr.next;
    slow_ptr.next = null;

    node2 = reverselist(node2);
    // 4) Merge alternate nodes
    node = new Node(0); // Assign dummy Node

    // curr is the pointer to this dummy Node, which
    // will be used to form the new list
    Node curr = node;
    while (node1 != null || node2 != null) {
      if (node1 != null) {
        curr.next = node1;
        curr = curr.next;
        node1 = node1.next;
      }

      if (node2 != null) {
        curr.next = node2;
        curr = curr.next;
        node2 = node2.next;
      }
    }
    node = node.next;

  }

  public static void main(String[] args) {

    RearrangeList list = new RearrangeList();
    list.head = new Node(1);
    list.head.next = new Node(2);
    list.head.next.next = new Node(3);
    list.head.next.next.next = new Node(4);
    list.head.next.next.next.next = new Node(5);

    list.printlist(head); // print original list
    list.rearrange(head); // rearrange list as per ques
    System.out.println("");
    list.printlist(head); // print modified list
  }
}
