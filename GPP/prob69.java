
public class prob69 {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    boolean isBst(Node root, Node min, Node max) {

        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        }
        if (max != null && root.data >= max.data) {
            return false;
        }
        boolean left = isBst(root.left, min, root);
        boolean right = isBst(root.right, root, max);
        return left && right;

    }

    void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static void main(String[] args) {
        prob69 bst = new prob69();
        Node root = bst.new Node(3);
        root.left = bst.new Node(2);
        root.right = bst.new Node(5);
        root.left.left = bst.new Node(1);
        root.right.left = bst.new Node(4);
        // bst.inorder(root);
        System.out.println(bst.isBst(root, null, null));
    }
}
