
/**
 * 
 * check if list is palindrome or not
 */

import java.util.Stack;

public class prob14 {
  Node head = null;

  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      next = null;
    }
  }

  // Method : 1 usig stack
  boolean isPalindrome() {
    Stack<Integer> s = new Stack<>();
    Node temp = head;
    boolean flag = false;
    while (temp != null) {
      s.push(temp.data);
      temp = temp.next;
    }

    while (!s.isEmpty()) {
      int i = s.pop();
      if (i == head.data) {
        flag = true;

      } else {
        flag = false;
        break;
      }
      head = head.next;
    }
    return flag;
  }

  public void push(int data) {
    Node new_node = new Node(data);
    new_node.next = head;
    head = new_node;
  }

  public static void main(String arg[]) {
    Palindrome ll = new Palindrome();
    ll.push(1);
    ll.push(2);
    ll.push(3);
    ll.push(3);
    ll.push(2);
    ll.push(1);
    System.out.println("Linked palindrome :" + ll.isPalindrome());
  }
}
