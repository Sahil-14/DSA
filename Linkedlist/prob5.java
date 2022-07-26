/**
 * 
 * 
 * /**]
 * find length of loop
 * 
 */

public class prob5 {
  Node head = null;

  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  /**
   * 
   * 1--2--3--4 TEMP= 5 , N = 3 ,RES = 3
   * | |
   * 6--5
   * 
   */

  int countNodes(Node n) {
    int res = 1;
    Node temp = n;
    while (temp.next != n) {
      res++;
      temp = temp.next;
    }
    return res;
  }

  int countNodesInLoop() {
    Node slow_ptr = head;
    Node fast_ptr = head;
    while (slow_ptr != null && fast_ptr != null && fast_ptr.next != null) {
      slow_ptr = slow_ptr.next;
      fast_ptr = fast_ptr.next.next;
      if (slow_ptr == fast_ptr) {
        return countNodes(slow_ptr);
      }
    }
    return 0;
  }

  public void push(int new_data) {
    Node new_node = new Node(new_data);

    new_node.next = head;

    head = new_node;
  }

  public static void main(String arg[]) {
    FindLengthOfLoop ll = new FindLengthOfLoop();
    ll.push(20);
    ll.push(4);
    ll.push(15);
    ll.push(10);
    ll.head.next.next.next.next = ll.head;
    System.out.println(ll.countNodesInLoop());
  }
}
