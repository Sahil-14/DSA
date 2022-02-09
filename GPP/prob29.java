import org.w3c.dom.Node;

public class prob29 {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void makeCycle(Node head, int pos) {
        Node temp = head;
        Node startNode = null;
        int count = 1;
        while (temp.next != null) {
            if (count == pos) {
                startNode = temp;
            }
            temp = temp.next;
            count++;
        }
        temp.next = startNode;
    }

    boolean detectCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    void removeLoop(Node head) {
        Node slow = head;
        Node fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        fast = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = null;
    }

    public void removeLoop2(Node head) {

        // using two pointers and moving one pointer(slow) by one node and
        // another pointer(fast) by two nodes in each iteration.
        Node fast = head.next;
        Node slow = head;

        while (fast != slow) {
            // if the node pointed by first pointer(fast) or the node
            // next to it is null, then loop is not present so we return 0.
            if (fast == null || fast.next == null)
                return;

            fast = fast.next.next;
            slow = slow.next;
        }
        // both pointers now point to the same node in the loop.

        int size = 1;
        fast = fast.next;
        // we start iterating the loop with first pointer and continue till
        // both pointers point to same node again.
        while (fast != slow) {
            fast = fast.next;
            // incrementing the counter which stores length of loop..
            size += 1;
        }

        // updating the pointers again to starting node.
        slow = head;
        fast = head;

        // moving pointer (fast) by (size-1) nodes.
        for (int i = 0; i < size - 1; i++)
            fast = fast.next;

        // now we keep iterating with both pointers till fast reaches a node such
        // that the next node is pointed by slow. At this situation slow is at
        // the node where loop starts and first at last node so we simply
        // update the link part of first.
        while (fast.next != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        // storing null in link part of the last node.
        fast.next = null;
    }
}
