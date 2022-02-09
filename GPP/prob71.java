import java.util.Stack;

// zig zac traversal

public class prob71 {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    void zigzacTraversal(Node root){
       

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty() ||  !s2.isEmpty()){
            while(!s1.isEmpty()){
          root= s1.pop();
                System.out.print(root.data+" ");
                if(root.left != null){
                    s2.push(root.left);
                }
                if(root.right != null){
                    s2.push(root.right);
                }
            }
       
            System.out.println();
            while(!s2.isEmpty()){
              root = s2.pop();
                System.out.print(root.data+" ");
                if(root.right != null){
                    s1.push(root.right);
                }
                if(root.left != null){
                    s1.push(root.left);
                }
              
            }
        }
    }
    public static void main(String[] args) {
        prob71 bt = new prob71();
        Node root = bt.new Node(1);
        root.left = bt.new Node(2);
        root.left.right = bt.new Node(4);
        root.left.right.left  = bt.new Node(6);
        root.left.right.right  = bt.new Node(7);
        root.right = bt.new Node(3);
        root.right.right = bt.new Node(5);
        bt.zigzacTraversal(root);


        
    }
}
