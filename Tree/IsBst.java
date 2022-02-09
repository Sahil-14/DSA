import BinaryTree.*;
public class IsBst {
    public boolean isBst(Node root){
        return isBst(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean isBst(Node root,int min,int max){
        if(root == null){
            return true;
        }
        if(root.data <= min ||root.data > max){
            return false;
        }
        return isBst(root.left,min,root.data) && isBst(root.right,root.data,max);
    }

    public static void main(String arg[]){
        IsBst bst = new IsBst();
        BinaryTree bt  = new BinaryTree();
        Node root = null;
        root = bt.addNode(10, root);
        root = bt.addNode(15, root);
        root = bt.addNode(5, root);
        root = bt.addNode(7, root);
        root = bt.addNode(19, root);
        root = bt.addNode(20, root);
        root = bt.addNode(4, root);
        root = bt.addNode(3, root);
        assert bst.isBst(root);
    }
}
