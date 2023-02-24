/**
 * 
 * Input:
 * First List: 5->6->3
 * Second List: 8->4->2
 * Output
 * Resultant list: 1->4->0->5
 */
public class prob29 {
  static class node {
    int val;
    node next;

    public node(int val) {
      this.val = val;
    }
  }

  node head1;
  node head2;

  public node addTwo(node l1, node l2) {
    node dummyNode = new node(0);
    node curr = dummyNode;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      int x = l1 != null ? l1.val : 0;
      int y = l2 != null ? l2.val : 0;

      int sum = x + y + carry;
      carry = sum / 10;
      curr.next = new node(sum % 10);
      curr = curr.next;
      if (l1 != null) {
        l1 = l1.next;

        if (l2 != null) {
          l2 = l2.next;
        }

      }
    }
    return dummyNode.next;

  }

  // Driver program to test above functions
  public static void main(String args[]) {
    prob29 list = new prob29();
    list.head1 = null;
    list.head2 = null;
    list.result = null;
    list.carry = 0;
    int arr1[] = { 9, 9, 9 };
    int arr2[] = { 1, 8 };

    // Create first list as 9->9->9
    for (int i = arr1.length - 1; i >= 0; --i)
      list.push(arr1[i], 1);

    // Create second list as 1->8
    for (int i = arr2.length - 1; i >= 0; --i)
      list.push(arr2[i], 2);

    list.addlists();

    list.printlist(list.result);
  }
}
