import java.util.HashSet;

public class practice {
  Node head;

  class Node {
    int data;
    Node next;
    int flag;

    Node(int data) {
      this.data = data;
      this.next = null;
      this.flag = 0;
    }
  }

  public void push(int data) {
    Node node = new Node(data);
    if (head == null) {
      head = node;
    } else {
      node.next = head;
      head = node;

    }
  }

  public void append(int data) {
    Node new_node = new Node(data);
    if (head == null) {
      head = new_node;
      return;
    }
    Node last = head;
    while (last.next != null) {
      last = last.next;
    }
    last.next = new_node;
  }

  public void delete(int key) {
    // if head == null
    if (head == null) {
      return;
    }
    Node temp = head;
    // if deleted node is head
    if (temp.data == key) {
      head = temp.next;
      return;
    }
    // traverse till key
    Node prev = null;
    while (temp != null && temp.data != key) {
      prev = temp;
      temp = temp.next;
    }

    // chek if it is null
    if (temp == null) {
      return;
    }
    // change link
    prev.next = temp.next;
  }

  public void deleteAtK(int position) {
    if (head == null) {
      return;
    }
    Node temp = head;
    if (position == 1) {
      head = temp.next;
      return;
    }

    for (int i = 0; temp != null && i < position - 1; i++) {
      temp = temp.next;
    }

    if (temp == null || temp.next == null) {
      return;
    }

    Node next = temp.next.next;
    temp.next = next;
  }

  public int countFreq(int item) {
    Node temp = head;
    int count = 0;
    while (temp != null) {
      if (temp.data == item)
        count++;
      temp = temp.next;

    }
    return count;
  }

  public boolean isLoopHashing() {
    HashSet<Node> hs = new HashSet<>();

    Node temp = head;
    while (temp != null) {
      if (hs.contains(temp)) {
        return true;
      }
      hs.add(temp);
      temp = temp.next;

    }
    return false;

  }

  public boolean isLoopFlag() {
    Node temp = head;
    while (temp != null) {
      if (temp.flag == 1) {
        return true;
      }
      temp.flag = 1;
      temp = temp.next;
    }
    return false;
  }

  public boolean isLoopFludMethod() {
    Node slowPtr = head;
    Node fastPtr = head;
    boolean flag = false;
    while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
      if (slowPtr == fastPtr) {
        flag = true;
        break;
      }
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next.next;
    }

    if (flag) {
      return true;
    }
    return false;

  }

  public removeDuplicateInsorted(){
    Node current = head;
    while(current != null){
      Node temp = current;
      while(temp != null && temp.data != current.data){
        temp  = temp.next;
      }
      current.next = temp;
      current = current.next;

    }
  }

  public void reverse() {
    Node prev = null;
    Node current = head;
    Node next = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    head = prev;
  }

  public Node reverseK(Node head, int k) {
    Node prev = null;
    Node curr = head;
    Node next = null;
    int count = 0;
    while (curr != null && count < k) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      count++;
    }
    if (next != null) {
      head = reverseK(next, k);
    }
    return head;
  }

  public void moveFirstToLast() {
    Node temp = head;
    Node prev = null;
    while (temp.next != null) {
      prev = temp;
      temp = temp.next;
    }
    prev.next = temp.next;
    temp.next = head;
    head = temp;
  }

  public void swapNode(int x, int y) {
    Node prevX = null, currentX = head;
    Node prevY = null, currentY = head;

    // reach to x
    while (currentX != null && currentX.data != x) {
      prevX = currentX;
      currentX = currentX.next;
    }
    // reach to y
    while (currentY != null && currentY.data != y) {
      prevY = currentY;
      currentY = currentY.next;
    }
    // check if x or y is null
    if (currentX == null || currentY == null) {
      return;
    }
    // check if x is head;
    if (prevX == null) {
      head = currentY;
    } else {
      prevX.next = currentY;
    }
    // check if y is head;
    if (prevY == null) {
      head = currentX;
    } else {
      prevY.next = currentY;
    }
    // swap

    Node temp = currentX.next;
    currentX.next = currentY.next;
    currentY.next = temp;
  }

  public void pairwieseSwap() {
    Node temp = head;

    while (temp != null && temp.next != null) {
      int swap = temp.data;
      temp.data = temp.next.data;
      temp.next.data = swap;
      temp = temp.next.next;
    }
  }

  public void reverseDl() {
    Node current = head;
    while (current != null) {

    }
  }

  public void withoutSwap(int x, int y) {
    if (x == y) {
      return;
    }
    Node prevX = null, currX = head;
    while (currX != null || currX.data != x) {
      prevX = currX;
      currX = currX.next;
    }

    Node prevY = null, currY = head;
    while (currY != null || currY.data != x) {
      prevY = currY;
      currY = currY.next;
    }

    if (currY == null || currY == null) {
      return;
    }
    if (prevX == null) {
      head = currY;
    } else {
      prevX.next = currY;
    }

    if (prevY == null) {
      head = currX;
    } else {
      prevY.next = currX;
    }

    Node temp = currX.next;
    currX.next = currY.next;
    currY.next = temp;
  }

  public Node rotateK(int k) {
    int count = 1;
    Node current = head;

    while (current != null && count < k) {
      current = current.next;
      count++;
    }
    if (current == null) {
      return head;
    }

    Node kthNode = current;
    while (current.next != null) {
      current = current.next;
    }

    current.next = head;
    head = kthNode.next;
    kthNode.next = null;
    return head;
  }

}
