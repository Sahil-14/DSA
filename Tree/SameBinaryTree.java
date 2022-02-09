import BinaryTree.*;
public class SameBinaryTree {
    public boolean SameTree(Node root1,Node root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        return root1.data == root2.data && SameTree(root1.left,root2.left) && SameTree(root1.right,root2.right);
    }
    public static void main(String arg[]){
        BinaryTree bt1 = new BinaryTree();
        BinaryTree bt2 = new BinaryTree();
        SameBinaryTree st = new SameBinaryTree();
        Node root1 = null;
        Node root2 = null;
        // if(st.SameTree(root1, root2)){
        //     System.out.println("same tree");
        // }else{
        //     System.out.println("not same tree");
        // }
        root1 = bt1.addNode(10, root1);
        root1 = bt1.addNode(20, root1);
        root1 = bt1.addNode(-10, root1);
        root1 = bt1.addNode(15, root1);
        root1 = bt1.addNode(0, root1);
        root1 = bt1.addNode(71, root1);
        root1 = bt1.addNode(-1, root1);

        root2 = bt2.addNode(10, root2);
        root2 = bt2.addNode(20, root2);
        root2 = bt2.addNode(-10, root2);
        root2 = bt2.addNode(15, root2);
        root2 = bt2.addNode(0, root2);
        root2 = bt2.addNode(21, root2);
        root2 = bt2.addNode(-1, root2);
        if(st.SameTree(root1, root2)){
            System.out.println("same tree");
        }else{
            System.out.println("not same tree");
        }
    }
}
