import java.util.LinkedList;
import java.util.Queue;

import BinaryTree.*;
public class LevelOrderTraversal {
    public void LevelOrderTraversalByQueue(Node root){
        if(root == null){
            return ;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.poll();
            System.out.println(node.data);
            if(node.left != null){
                q.add(node.left);
            }
            if(node.right  != null){
                q.add(node.right);
            }
        }
    }
    public static void main(String arg[]){
        BinaryTree bt  = new BinaryTree();
        Node root = null;
        LevelOrderTraversal lot = new LevelOrderTraversal();
        root = bt.addNode(10, root);
        root = bt.addNode(15, root);
        root = bt.addNode(5, root);
        root = bt.addNode(7, root);
        root = bt.addNode(19, root);
        root = bt.addNode(20, root);
        root = bt.addNode(4, root);
        root = bt.addNode(3, root);
        lot.LevelOrderTraversalByQueue(root);
    }
}
