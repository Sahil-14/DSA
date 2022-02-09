import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import BinaryTree.*;
public class ReverseLevelOrder {
    void ReverseLevelOrderByStackAndQueue(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        Stack<Node> s = new Stack<Node>();
        q.offer(root);
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.right != null){
                q.offer(node.right);
            }
            if(node.left != null){
                q.offer(node.left);
            }
            s.push(node);
        }
        while(!s.isEmpty()){

            System.out.print(s.pop().data + " ");
        }
    }
    public static void main(String arg[]){
        BinaryTree bt = new BinaryTree();
        Node root = null;
        root = bt.addNode(10, root);
        root = bt.addNode(15, root);
        root = bt.addNode(5, root);
        root = bt.addNode(7, root);
        root = bt.addNode(19, root);
        root = bt.addNode(20, root);
        root = bt.addNode(4, root);
        root = bt.addNode(3, root);
        ReverseLevelOrder rlo = new ReverseLevelOrder();

        rlo.ReverseLevelOrderByStackAndQueue(root);
    }
}
