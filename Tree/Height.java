import BinaryTree.*;

public class Height {
    public int TreeHeight(Node root){
        if(root == null){
            return 0;
        }
        int left = TreeHeight(root.left);
        int right = TreeHeight(root.right);
        return 1 + Math.max(left,right);
    }
    public static void main(String arg[]){
        BinaryTree bt = new BinaryTree();
        Node root = null;
        root = bt.addNode(10, root);
        root = bt.addNode(-10, root);
        root = bt.addNode(5, root);
        root = bt.addNode(-3, root);
        root = bt.addNode(6, root);
        root = bt.addNode(11, root);
       Height ht = new Height();
       int h = ht.TreeHeight(root);
       System.out.println(h);

    }
}
