public class IntersectionPoint {
    static Node head1, head2;

    static class Node {
        int data;
        Node next;
        int f;

        Node(int data) {
            this.data = data;
            next = null;
            f = 0;
        }
    }

    /*
     * function to get the intersection point of two linked
     * lists head1 and head2
     */
    int getNode() {
        int c1 = getCount(head1);
        int c2 = getCount(head2);
        if (c1 > c2) {
            int d = c1 - c2;
            return getIntersectionNode(d, head1, head2);
        } else {
            int d = c2 - c1;
            return getIntersectionNode(d, head2, head1);
        }
    }

    int getIntersectionNode(int d, Node node1, Node node2) {
        int i;
        Node current1 = node1;
        Node current2 = node2;
        for (i = 0; i < d; i++) {
            if (current1 == null) {
                return 1;
            }
            current1 = current1.next;

        }
        while (current1 != null && current2 != null) {
            if (current1.data == current2.data) {
                return current1.data;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return -1;
    }

    int getCount(Node node) {
        int count = 0;
        Node current = node;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String arg[]) {
        IntersectionPoint list = new IntersectionPoint();
        head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(9);
        head1.next.next.next = new Node(15);
        head1.next.next.next.next = new Node(30);

        head2 = new Node(10);
        head2.next = new Node(15);
        head2.next.next = new Node(30);
        System.out.println("The node of intersection is " + list.getNode());
    }
}
