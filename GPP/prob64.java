import java.util.Vector;

public class prob64 {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    boolean getPath(Node root, int k, Vector<Integer> path) {
        if (root == null) {
            return false;
        }
        path.add(root.data);
        if (root.data == k) {
            return true;
        }
        if (getPath(root.left, k, path) || getPath(root.right, k, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    int LCA(Node root, int n1, int n2) {
        Vector<Integer> path1 = new Vector<>();
        Vector<Integer> path2 = new Vector<>();
        if (!getPath(root, n1, path1) || !getPath(root, n2, path2)) {
            return -1;
        }
        int pathChage;
        for (pathChage = 0; pathChage < path1.size() && pathChage < path2.size(); pathChage++) {
            if (path1.get(pathChage) != path2.get(pathChage)) {
                break;
            }
        }
        ;
        return path1.get(pathChage - 1);
    }

    // LCA2 optimize
    Node LCA2(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (root.data == n1 || root.data == n2) {
            return root;
        }
        Node left = LCA2(root.left, n1, n2);
        Node right = LCA2(root.right, n1, n2);
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        if (left != null) {
            return left;
        }
        return right;
    }

    public static void main(String[] args) {
        prob64 bt = new prob64();
        Node root = bt.new Node(1);
        root.left = bt.new Node(2);
        root.right = bt.new Node(3);
        root.left.left = bt.new Node(4);
        root.right.left = bt.new Node(5);
        root.right.right = bt.new Node(6);
        root.right.left.right = bt.new Node(7);
        int n1 = 7;
        int n2 = 6;
        int lca = bt.LCA(root, n1, n2);
        if (lca == -1) {
            System.out.println("No lca");
        } else {
            System.out.println(lca);
        }
    }
}
