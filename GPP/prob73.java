public class prob73 {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    boolean isBstIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        else if (root1 == null || root2 == null) {
            return false;
        }

        else {
            boolean cond1 = root1.data == root2.data;
            boolean left = isBstIdentical(root1.left, root2.left);
            boolean right = isBstIdentical(root1.right, root2.right);
            return cond1 && left && right;
        }
    }

    public static void main(String[] args) {
        prob73 bst = new prob73();
        Node root1 = bst.new Node(2);
        root1.left = bst.new Node(1);
        root1.right = bst.new Node(3);
        Node root2 = bst.new Node(2);
        root2.left = bst.new Node(1);
        // root2.right = bst.new Node(3);
        System.out.println(bst.isBstIdentical(root1, root2));

    }
}
