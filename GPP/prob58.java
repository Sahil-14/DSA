// replace the data of the node with the value of sum of its left subtree and right subtree
public class prob58 {
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
    void sumReplace(Node root){
        if(root == null){
            return ;
        }
        sumReplace(root.left);
        sumReplace(root.right);
        if(root.left != null){
            root.data+=root.left.data;
        }
        if(root.right != null){
            root.data+=root.right.data;
        }
    }
    void preorder(Node root){
        if(root == null){
            return ;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        prob58 bt = new prob58();
        Node root = bt.new Node(1);
        root.left = bt.new Node(2);
        root.right = bt.new Node(3);
        root.left.left = bt.new Node(4);
        root.left.right = bt.new Node(5);
        root.right.left = bt.new Node(6);
        root.right.right = bt.new Node(7);
        bt.sumReplace(root);
        bt.preorder(root);
        
    }
}
