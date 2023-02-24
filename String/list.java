public class list {
  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static Node push(Node head, int data) {
    if (head == null) {
      head = new Node(data);
    }
    Node node = new Node(data);
    node.next = head;
    head = node;
    return head;
  }

  public static Node append(Node head, int data) {
    if (head == null) {
      head = new Node(data);
    }

    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }

    Node node = new Node(data);
    temp.next = node;
    node.next = null;
    return head;
  }

  public static void deleteList(Node head) {
    if (head != null) {
      head = null;
    }
  }


 

  public static void main(String[] args) {
    Node head = new Node(1);
    head = append(head, 2);
    head = append(head, 3);
    head = append(head, 4);
    head = append(head, 5);

    // head = push(head, 3);
    // head = push(head, 4);
    // head = push(head, 5);
    Node temp = head;
    while (temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
  }
}



