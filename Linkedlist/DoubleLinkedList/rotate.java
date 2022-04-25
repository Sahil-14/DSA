package DoubleLinkedList;

public class rotate {

  static class Node {
    char data;
    Node prev;
    Node next;
  }

  static Node head = null;

  public static void rotateDLL(int k) {
    if (k == 0) {
      return;
    }

    Node current = head;
    int count = 1;
    while (count < k && current != null) {
      current = current.next;
      count++;
    }

    if(current == null){
      return ;
    }

    Node kthNode = current;
    while(current.next != null){
      current = current.next;
    }


    current.next  = head;
    head.prev = current;
    head = kthNode.next;
    kthNode.next = null;
    head.prev = null;
  }
}
