import java.util.*;

public class prob60 {
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

    void rightView(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node != null) {
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                if (q.peek() == null) {
                    System.out.println(node.data);
                }

            } else if (!q.isEmpty()) {
                q.add(null);
            }
        }
    }

    void rightViewBySize(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 1; i <= n; i++) {
                Node temp = q.peek();
                q.poll();
                if (i == n) {
                    System.out.println(temp.data);
                }
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
        }
    }

    void leftView(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 1; i <= n; i++) {
                Node temp = q.peek();
                q.poll();
                if (i == 1) {
                    System.out.println(temp.data);
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        prob60 bt = new prob60();
        Node root = bt.new Node(1);
        root.left = bt.new Node(2);
        root.right = bt.new Node(3);
        root.left.left = bt.new Node(4);
        root.left.right = bt.new Node(5);
        root.left.right.left = bt.new Node(6);
        // root.right.left = bt.new Node(6);
        root.right.right = bt.new Node(7);
        // bt.rightView(root);
        // bt.rightViewBySize(root);
        bt.leftView(root);
    }
}
