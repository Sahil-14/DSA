public class ZigzagTraversal {
  static class Node {
    int data;
    Node next;
  }

  static Node head = null;
  static int temp = 0;

  static void zigZagList(Node head) {
    // If flag is true, then
    // next node should be greater
    // in the desired output.
    boolean flag = true;

    // Traverse linked list starting from head.
    Node current = head;
    while (current != null && current.next != null) {
      if (flag == true) /* "<" relation expected */
      {
        /*
         * If we have a situation like A > B > C
         * where A, B and C are consecutive Nodes
         * in list we get A > B < C by swapping B
         * and C
         */
        if (current.data > current.next.data) {
          temp = current.data;
          current.data = current.next.data;
          current.next.data = temp;
        }
      } else /* ">" relation expected */
      {
        /*
         * If we have a situation like A < B < C where
         * A, B and C are consecutive Nodes in list we
         * get A < C > B by swapping B and C
         */
        if (current.data < current.next.data) {
          temp = current.data;
          current.data = current.next.data;
          current.next.data = temp;
        }
      }

      current = current.next;

      /* flip flag for reverse checking */
      flag = !(flag);
    }
  }

  // method 2
  public void swap(Node a, Node b) {
    if (a == null || b == null)
      return;
    int temp = a.data;
    a.data = b.data;
    b.data = temp;
  }

  // Rearrange the linked list
  // in zig zag way
  public Node zigZag(Node node, int flag) {
    if (node == null || node.next == null) {
      return node;
    }
    if (flag == 0) {
      if (node.data > node.next.data) {
        swap(node, node.next);
      }
      return zigZag(node.next, 1);
    } else {
      if (node.data < node.next.data) {
        swap(node, node.next);
      }
      return zigZag(node.next, 0);
    }
  }

  static void push(int data) {
    Node node = new Node();
    node.data = data;
    node.next = head;
    head = node;
  }

  static void printList(Node Node) {
    while (Node != null) {
      System.out.print(Node.data + "->");
      Node = Node.next;
    }
    System.out.println("NULL");
  }

  public static void main(String[] args) {
    /* Start with the empty list */
    // Node head = null;

    // create a list 4 -> 3 -> 7 -> 8 -> 6 -> 2 -> 1
    // answer should be -> 3 7 4 8 2 6 1
    push(1);
    push(2);
    push(6);
    push(8);
    push(7);
    push(3);
    push(4);

    System.out.println("Given linked list ");
    printList(head);

    zigZagList(head);

    System.out.println("Zig Zag Linked list ");
    printList(head);
  }
}
