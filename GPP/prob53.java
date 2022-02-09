public class prob53 {
    class Node{
        int data;
        Node left ;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    void inorder(Node node){
        if(node == null){
            return ;
        }
        inorder(node.left);
        System.out.println(node.data);
        inorder(node.right);
    }
    void preorder(Node node){
        if(node == null){
            return ;
        }
        System.out.println(node.data);
        preorder(node.left);
        preorder(node.right);
    }
    void postorder(Node node){
        if(node == null){
            return ;
        }
      
        preorder(node.left);
        preorder(node.right);
        System.out.println(node.data);
    }
    public static void main(String[] args) {
        prob53 bt = new prob53();
        Node root = bt.new Node(1);
        root.left = bt.new Node(2);
        root.right = bt.new Node(3);
        root.left.left = bt.new Node(4);
        root.left.right = bt.new Node(5);
        root.right.left = bt.new Node(6);
        root.right.right = bt.new Node(7);
        // bt.preorder(root);
        bt.inorder(root);
    }
}
