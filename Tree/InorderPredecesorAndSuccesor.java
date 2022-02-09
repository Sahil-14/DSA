import BinaryTree.*;

public class InorderPredecesorAndSuccesor {
    public Node findMaximum(Node root) {
        if (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public Node findMinimum(Node root) {
        if (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public Node predecessor(Node root, Node prec, int key) {
        if (root == null) {
            return prec;
        }
        if (root.data == key) {
            if (root.left != null) {
                return findMaximum(root.left);
            }
        }
        if (key < root.data) {
            return predecessor(root.left, prec, key);
        }
        if (key > root.data) {
            prec = root;
            return predecessor(root.right, prec, key);
        }
        return prec;
    }

    public Node succesor(Node root, Node succ, int key) {
        if (root == null) {
            return succ;
        }
        if (root.data == key) {
            if (root.right != null) {
                return findMinimum(root.right);
            }
        }
        if (key < root.data) {
            succ = root;
            return succesor(root.left, succ, key);
        }
        if (key > root.data) {
            return succesor(root.right, succ, key);
        }
        return succ;
    }

    public static void main(String arg[]) {
        InorderPredecesorAndSuccesor ips = new InorderPredecesorAndSuccesor();
        BinaryTree bt = new BinaryTree();
        Node root = null;
        root = bt.addNode(15, root);
        root = bt.addNode(10, root);
        root = bt.addNode(20, root);
        root = bt.addNode(8, root);
        root = bt.addNode(12, root);
        root = bt.addNode(16, root);
        root = bt.addNode(25,root);
        Node result1 = ips.predecessor(root, null, 25);
        Node result2 = ips.succesor(root, null, 25);
        if(result1 != null){
            System.out.println(result1.data+" ");
        }else{
            System.out.println(" No inorder predecessor for given node");
        }
        if(result2 != null){
            System.out.println(result2.data+" ");
        }else{
            System.out.println(" No inorder successor for given node");
        }
    }
}
