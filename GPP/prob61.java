// shortest distance between 2 nodes
// step1 : find lca
// step2 :find distance bet lca and n1, and lca and n2
// step3 : return d1+d2
public class prob61 {
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

    Node lca(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (root.data == n1 || root.data == n2) {
            return root;
        }
        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        if (left != null) {
            return lca(root.left, n1, n2);
        }
        return lca(root.right, n1, n2);
    }

    int findDist(Node root, int k, int dist) {
        if (root == null) {
            return -1;
        }
        if (root.data == k) {
            return dist;
        }
        int left = findDist(root.left, k, dist + 1);
        if (left != -1) {
            return left;
        }
        return findDist(root.right, k, dist + 1);
    }

    int distanceBetNodes(Node root, int n1, int n2) {
        Node lca = lca(root, n1, n2);
        int d1 = findDist(lca, n1, 0);
        int d2 = findDist(lca, n2, 0);
        return d1 + d2;
    }

    public static void main(String[] args) {
        prob61 bt = new prob61();
        Node root = bt.new Node(1);
        root.left = bt.new Node(2);
        root.right = bt.new Node(3);
        root.left.left = bt.new Node(4);
        root.right.right = bt.new Node(5);
       System.out.println(bt.distanceBetNodes(root, 4, 5));
    }

}
