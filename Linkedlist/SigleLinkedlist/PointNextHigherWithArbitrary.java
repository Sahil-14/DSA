public class PointNextHigherWithArbitrary {
  static Node head;

  /* Link list node */
  static class Node {
    int data;
    Node next, arbit;

    Node(int data) {
      this.data = data;
      next = null;
      arbit = null;
    }
  }

  void printList(Node node, Node anode) {
    System.out.println("Traversal using Next Pointer");
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }

    System.out.println("\nTraversal using Arbit Pointer");
    while (anode != null) {
      System.out.print(anode.data + " ");
      anode = anode.arbit;
    }
  }

  private Node populateArbit(Node start) {
    Node temp = start;
    while (temp != null) {
      temp.arbit = temp.next;
      temp = temp.next;
    }
    return mergeSort(start);
  }

  private Node mergeSort(Node start) {
    if (start == null || start.arbit == null) {
      return start;
    }
    Node middle = getMiddle(start);
    Node nextToMid = middle.arbit;
    middle.arbit = null;

    Node left = mergeSort(start);
    Node right = mergeSort(nextToMid);
    Node sortedlist = SortedMerge(left, right);
    return sortedlist;
  }

  private Node getMiddle(Node source) {
    // Base case
    if (source == null)
      return source;
    Node fastptr = source.arbit;
    Node slowptr = source;

    // Move fastptr by two and slow ptr by one
    // Finally slowptr will point to middle node
    while (fastptr != null) {
      fastptr = fastptr.arbit;
      if (fastptr != null) {
        slowptr = slowptr.arbit;
        fastptr = fastptr.arbit;
      }
    }
    return slowptr;
  }

  private Node SortedMerge(Node a, Node b) {

    if (a == null) {
      return b;
    }
    if (b == null) {
      return a;
    }

    if (a.data < b.data) {
      a.arbit = SortedMerge(a.arbit, b);
      return a;
    } else {
      b.arbit = SortedMerge(a, b.arbit);
      return b;
    }

  }

  public static void main(String[] args) {
    PointNextHigherWithArbitrary list = new PointNextHigherWithArbitrary();

    /* Let us create the list shown above */
    list.head = new Node(5);
    list.head.next = new Node(10);
    list.head.next.next = new Node(2);
    list.head.next.next.next = new Node(3);

    /* Sort the above created Linked List */
    Node ahead = list.populateArbit(head);

    System.out.println("Result Linked List is:");
    list.printList(head, ahead);
  }
}
