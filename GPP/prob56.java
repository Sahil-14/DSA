import java.util.*;

public class prob56 {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    void printLevelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.poll();
            System.out.println(node.data);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }

    void printLevelOrderUsingNull(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node node = q.peek();
            q.poll();
            if (node != null) {
                System.out.println(node.data);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
               
            }
            
            // node is null and q is not empty
            else if (!q.isEmpty()) {
                q.add(null);
            }
        }
    }
    // given the value of k , find the sum of node at kth level
    int sumAtK(Node root, int k) {
        if (root == null) {
            return -1;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = 0;
        int sum = 0;
        while (!q.isEmpty()) {
            Node node = q.peek();
            q.poll();
            if (node != null) {
                if (level == k) {
                    sum += node.data;
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            } else if (!q.isEmpty()) {
                q.add(null);
                level++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        prob56 bt = new prob56();
        Node root = bt.new Node(1);
        root.left = bt.new Node(2);
        root.right = bt.new Node(3);
        root.left.left = bt.new Node(4);
        root.left.right = bt.new Node(5);
        root.right.left = bt.new Node(6);
        root.right.right = bt.new Node(7);
        bt.printLevelOrderUsingNull(root);
        // System.out.println(bt.sumAtK(root, 2));
    }
}
