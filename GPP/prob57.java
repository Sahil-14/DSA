public class prob57 {
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

    int count(Node root) {
        if (root == null) {
            return 0;
        }
        int left = count(root.left);
        int right = count(root.right);
        return left + right + 1;
    }

    int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int left = sum(root.left);
        int right = sum(root.right);
        return left + right + root.data;
    }

    int height(Node root) {
        if (root == null) {
            // return -1;
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

    // o(n^2)
    int calDiameter(Node root) {
        if (root == null) {
            return 0;
        }
        int lheight = height(root.left);
        int rheight = height(root.right);
        int currDiameter = lheight + rheight + 1;
        int lDiameter = calDiameter(root.left);
        int rDiameter = calDiameter(root.right);
        return Math.max(currDiameter, Math.max(lDiameter, rDiameter));
    }

    public static void main(String[] args) {
        prob57 bt = new prob57();
        Node root = bt.new Node(1);
        root.left = bt.new Node(2);
        root.right = bt.new Node(3);
        root.left.left = bt.new Node(4);
        root.left.right = bt.new Node(5);
        root.right.left = bt.new Node(6);
        root.right.right = bt.new Node(7);
        System.out.println(bt.count(root));
        System.out.println(bt.sum(root));
        System.out.println(bt.height(root));
        System.out.println(bt.calDiameter(root));
    }
}
