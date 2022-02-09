import java.util.LinkedList;
import java.util.Stack;

import BinaryTree.*;
public class PostorderWithOneStack {
    void postOrder(Node root){
       
        Node current = root;
        Stack<Node> s = new Stack<>();
        while(current != null || !s.isEmpty()){
            if(current != null){
                s.push(current);
                current = current.left;
            }else{
                Node temp = s.peek().right;
                if(temp == null){
                    temp = s.pop();
                    System.out.println(temp.data);
                    while(!s.isEmpty() && temp == s.peek().right){
                        temp = s.pop();
                        System.out.println(temp.data);
                    }
                }else{
                    current = temp;
                }
            }
        }
    }
    public static void main(String arg[]){
        BinaryTree bt = new BinaryTree();
        Node root = null;
        PostorderWithOneStack pos = new PostorderWithOneStack();
        root = bt.addNode(10, root);
        root = bt.addNode(15, root);
        root = bt.addNode(5, root);
        root = bt.addNode(7, root);
        root = bt.addNode(19, root);
        root = bt.addNode(20, root);
        root = bt.addNode(4, root);
        root = bt.addNode(3, root);
        pos.postOrder(root);
    }
}
