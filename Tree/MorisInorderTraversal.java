import BinaryTree.*;

public class MorisInorderTraversal {
   

    void MorisInorder(Node root) {
        Node current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                Node prec = current.left;
                while(prec.right != null && prec.right != current){
                    prec = prec.right;
                }
                if (prec.right == null) {
                    prec.right = current;
                    current = current.left;
                } else {
                    prec.right = null;
                    System.out.print(current.data+" ");
                    current = current.right;
                }
            }

        }

    }

    public static void main(String arg[]) {
        BinaryTree bt = new BinaryTree();
        Node root = null;
        MorisInorderTraversal miot = new MorisInorderTraversal();
        root = bt.addNode(10, root);
        root = bt.addNode(5, root);
        root = bt.addNode(15, root);
        root = bt.addNode(2, root);
        root = bt.addNode(7, root);
        root = bt.addNode(30, root);
        miot.MorisInorder(root);
    }
}
