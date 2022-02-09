import java.util.ArrayList;

import java.util.List;

import BinaryTree.*;

public class LeafToRootSum {
    public boolean printPath(Node root, int sum, List<Node> path) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            if (root.data == sum) {
                path.add(root);
                return true;
            }else{
                return false;
            }
        }
        if (printPath(root.left, sum - root.data, path) || printPath(root.right, sum - root.data, path)) {
            path.add(root);
            return true;
        }
        return false;
    }

    public static void main(String arg[]) {
        LeafToRootSum ltr = new LeafToRootSum();
        BinaryTree bt = new BinaryTree();
        Node root = null;
        root = bt.addNode(10, root);
        root = bt.addNode(15, root);
        root = bt.addNode(5, root);
        root = bt.addNode(7, root);
        root = bt.addNode(19, root);
        root = bt.addNode(20, root);
        root = bt.addNode(4, root);
        root = bt.addNode(3, root);
        List<Node> result = new ArrayList<>();
        boolean r = ltr.printPath(root, 22, result);
        if(r){
            result.forEach(node -> System.out.println(node.data + " "));
        }else{
            System.out.println("No path for sum "+ 22);
        }
     }
}
