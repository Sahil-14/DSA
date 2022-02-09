// flatter binary tree
//given a binary tree flatten it into linked list in place after flatterning left
// of each node should point to null and right should conatin next node in preorder sequence
// Step 1:recursively flattern left and right subtree
// step 2 : store left tail and right tail
// step 3: store left subtree in temp and make left subtree as right subtree
// step 4: join right subtree with left tail
public class prob62 {
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
    void flattern(Node root){
        if(root == null || (root.left == null && root.right == null)){
            return ;
        } 
        if(root.left != null){
            flattern(root.left);
            Node temp = root.right;
            root.right = root.left;
            root.left = null;

            Node t = root.right;
            while(t.right != null){
                t = t.right;
            }
            t.right = temp;
        }
        flattern(root.right);
    }
    void inorder(Node root){
        if(root == null){
            return ;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    public static void main(String[] args) {
        prob62 bt = new prob62();
        Node root = bt.new Node(4);
        root.left = bt.new Node(9);
        root.right = bt.new Node(5);
        root.left.left = bt.new Node(1);
        root.left.right = bt.new Node(3);
        root.right.right = bt.new Node(6);
        // bt.inorder(root);
        bt.flattern(root);
        bt.inorder(root);
    }
}
