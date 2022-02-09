package BinaryTree;


public class Bt_R_Traversal_1{
    
    void Inorder(Node node){
        if(node == null){
            return;
        }
        Inorder(node.left);
        System.out.println(node.data);
        Inorder(node.right);
    }

    void Preorder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.data);
        Preorder(node.left);
        Preorder(node.right);
    }

    void Postorder(Node node){
        if(node == null){
            return;
        }
        Postorder(node.left);
        Postorder(node.right);
        System.out.println(node.data);
    }
    

    public static void main(String arg[]) {
        Bt_R_Traversal_1 t = new Bt_R_Traversal_1();
        BinaryTree tree = new BinaryTree();
        Node root  = null;
        root = tree.addNode(1,root);
        root = tree.addNode(2,root);
        root = tree.addNode(9,root);
        root = tree.addNode(4,root);
        root = tree.addNode(5,root);


        System.out.println("Inorder traversal :");
        t.Inorder(root);
        System.out.println("Preorder traversal :");
        t.Preorder(root);
        System.out.println("Postorder traversal :");
        t.Postorder(root);


    }
}

