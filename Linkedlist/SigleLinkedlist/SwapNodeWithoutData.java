public class SwapNodeWithoutData {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    void swapNode(int x, int y) {
        if (x == y)
            return;
        // Search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }
        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY; 
            currY = currY.next;
        }
        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;
        // If x is not head of linked list
        if(prevX != null)
            prevX.next = currY;
        else    
            head = currY;
        // If y is not head of linked list
        if(prevY != null)
            prevY.next = currX;
        else    
            head = currX;
        
        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp; 

    }
}
