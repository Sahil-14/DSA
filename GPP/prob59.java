// Height balanced binary tree
/**
 * Differece between left subtree and right subtree is less than or equal to 1
 * 
 */
class Height {
    int height = 0;
}

public class prob59 {
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

    int height(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        if (!isBalanced(root.left)) {
            return false;
        }
        if (!isBalanced(root.right)) {
            return false;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if (Math.abs(lh - rh) <= 1) {
            return true;
        }
        return false;
    }

    boolean isBalanced2(Node root, Height height) {
        if (root == null) {
            height.height = 0;
            return true;
        }
        Height lHeight = new Height();
        Height rHeight = new Height();
        boolean l = isBalanced2(root.left, lHeight);
        boolean r = isBalanced2(root.right, rHeight);
        int lh = lHeight.height;
        int rh = rHeight.height;
        height.height = (lh > rh ? lh : rh) + 1;
        if (Math.abs(lh - rh) >= 2)
            return false;
        else
            return l && r;

    }

    public static void main(String[] args) {
        prob59 bt = new prob59();
        Height height = new Height();
        Node root = bt.new Node(1);

        root.left = bt.new Node(2);
        // root.right = bt.new Node(3);
        root.left.left = bt.new Node(4);
        root.left.right = bt.new Node(5);
        // root.right.left = bt.new Node(6);
        // root.right.right = bt.new Node(7);
        System.out.println(bt.isBalanced(root));

        System.out.println(bt.isBalanced2(root, height));

    }
}
