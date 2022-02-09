import BinaryTree.*;
public class Size {
    public int TreeSize(Node root){
        if(root == null){
            return 0;
        }
        int left = TreeSize(root.left);
        int right = TreeSize(root.right);

        return 1+left+right;
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
        Size ts = new Size();
        int s = ts.TreeSize(root);
        System.out.println(s);
    }
}
