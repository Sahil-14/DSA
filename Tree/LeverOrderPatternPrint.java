import java.util.LinkedList;
import java.util.Queue;

import BinaryTree.*;
public class LeverOrderPatternPrint {
    void levelOrderBy2Queue(Node root){
        if(root == null){
            return ;
        }
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty() || !q2.isEmpty()){
            while(!q1.isEmpty()){
                Node node = q1.poll();
                System.out.print(node.data+" ");
                if(node.left != null){
                    q2.add(node.left);
                }
                if(node.right != null){
                    q2.add(node.right);
                }
            }
            System.out.println();
            while(!q2.isEmpty()){
                Node node = q2.poll();
                System.out.print(node.data+" ");
                if(node.left != null){
                    q1.add(node.left);
                }
                if(node.right != null){
                    q1.add(node.right);
                }
            }
            System.out.println();
        }
    }
    void levelOrderBySingleQueue(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node != null){
                System.out.print(node.data+" ");
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right!= null){
                    q.offer(node.right);
                }
            }else{
                if(!q.isEmpty()){
                    System.out.println();
                    q.offer(null);
                }
                
            }
        }

    }
    public static void main(String arg[]){
        BinaryTree bt = new BinaryTree();
        Node root = null;
        LeverOrderPatternPrint lopp = new LeverOrderPatternPrint();
        root = bt.addNode(10, root);
        root = bt.addNode(15, root);
        root = bt.addNode(5, root);
        root = bt.addNode(7, root);
        root = bt.addNode(19, root);
        root = bt.addNode(20, root);
        root = bt.addNode(4, root);
        root = bt.addNode(3, root);
        System.out.println("By 2 Queue");
        lopp.levelOrderBy2Queue(root);
        System.out.println("By 1 Queue");
        lopp.levelOrderBySingleQueue(root);

    }
}
