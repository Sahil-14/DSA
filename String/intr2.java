public class intr2 {
  // 1 2 3 4 5
 
  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = next;
    }
  }

  public static Node NthElementFromLast(Node head,int n) {
    if (head == null) {
      return null;
    }
    int count = 0;
    
    Node temp = head;
    while (temp != null) {
      count++;
      temp = temp.next;
    }
    if (n > count) {
      return null;
    }
    int k = 1;
    temp = head;
    while (k <= n - count) {
      temp = temp.next;
      k++;
    }
    return temp;
  }


}



