import java.util.HashSet;
//detect loop
public class prob2 {
  Node head = null;;

  class Node {
    int data;
    Node next;
    // change for method :2
    int flag;

    Node(int data) {
      this.data = data;
      this.next = null;
      this.flag = 0;
    }
  }

  public void push(int new_data) {
    Node new_node = new Node(new_data);

    new_node.next = head;

    head = new_node;
  }

  // Mathod 1: using hashing
  /**
   * Time complexity: O(n). Only one traversal of the loop is needed. Auxiliary
   * Space: O(n). n is the space required to store the value in hashmap.
   */
  boolean detectLoopUsingHashing() {
    HashSet<Node> hs = new HashSet<>();
    Node temp = head;
    while (temp != null) {
      if (hs.contains(temp))
        return true;
      hs.add(temp);
      temp = temp.next;
    }
    return false;
  }

  // Method :2 By modifying existing datasturcture.
  /*
   * With flag variable Time complexity: O(n). Only one traversal of the loop is
   * needed. Auxiliary
   */
  boolean detectLoopUsingFlag() {
    Node current = head;
    while (current != null) {
      if (current.flag == 1) {
        return true;
      }
      current.flag = 1;
      current = current.next;
    }
    return false;
  }

  // Method 3:Floyd’s Cycle-Finding Algorithm
  /**
   * Traverse linked list using two pointers. Move one pointer(slow_p) by one and
   * another pointer(fast_p) by two. If these pointers meet at the same node then
   * there is a loop. If pointers do not meet then linked list doesn’t have a
   * loop.
   * 
   */
  boolean detectLoopUsingTwoPointer() {
    Node slow_pointer = head;
    Node fast_pointer = head;
    int f = 0;
    while (slow_pointer != null && fast_pointer != null && fast_pointer.next != null) {
      slow_pointer = slow_pointer.next;
      fast_pointer = fast_pointer.next.next;
      if (slow_pointer == fast_pointer) {
        f = 1;
        break;
      }

    }
    if (f == 1) {
      return true;
    } else {
      return false;
    }
  }

  boolean detectLoopUsing4() {
    Node temp = head;
    while (head != null) {
      if (head.next == null)
        return false;
      // Check if next is already
      // pointing to temp
      if (head.next == temp)
        return true;
      // Store the pointer to the next node
      // in order to get to it in the next step
      Node nxt = head.next;
      head.next = temp;
      head = nxt;

    }
    return false;
  }

  public static void main(String arg[]) {
    prob2 ll = new prob2();
    ll.push(20);
    ll.push(4);
    ll.push(15);
    ll.push(10);
    ll.head.next.next.next.next = ll.head;
    // Method :1
    if (ll.detectLoopUsingHashing()) {
      System.out.println("Loop found");
    } else {
      System.out.println("Loop not found");
    }
    // Method :2
    if (ll.detectLoopUsingFlag()) {
      System.out.println("Loop found");
    } else {
      System.out.println("Loop not found");
    }
    // Method :3
    if (ll.detectLoopUsingTwoPointer()) {
      System.out.println("Loop found");
    } else {
      System.out.println("Loop not found");
    }
    // Method :4 without using extra datastructure
    if (ll.detectLoopUsing4()) {
      System.out.println("Loop found");
    } else {
      System.out.println("Loop not found");
    }
  }
}
