import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import BinaryTree.*;
public class SpiralOrderTraversal {
    void spiralOrderByTwoStack(Node root){
        if(root == null){
            return;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                root = s1.pop();
                System.out.print(root.data+" ");
                if(root.left != null){
                    s2.push(root.left);
                }
                if(root.right != null){
                    s2.push(root.right);
                }
            }
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
    void spiralOrderByOneDeque(Node root){
        if(root == null){
            return;
        }
        Deque<Node> q = new LinkedList<>();
        q.offer(null);
        q.offerFirst(root);
        while(q.size() > 1){
            root = q.peekFirst();
            while(root != null){
                root = q.pollFirst();
                System.out.print(root.data+" ");
                if(root.left != null){
                    q.offerLast(root.left);
                }
                if(root.right != null){
                    q.offerLast(root.right);
                }
                root = q.peekFirst();
            }
            root = q.peekLast();
            while(root != null){
                root = q.pollLast();
                System.out.print(root.data+" ");
                if(root.right != null){
                    q.offerFirst(root.right);
                }
                if(root.left != null){
                    q.offerFirst(root.left);
                }
                root = q.peekLast();
            }

        }

    }
    public static void main(String arg[]){
        BinaryTree bt = new BinaryTree();
        Node root = null;
        SpiralOrderTraversal sot = new SpiralOrderTraversal();
        root = bt.addNode(10, root);
        root = bt.addNode(15, root);
        root = bt.addNode(5, root);
        root = bt.addNode(7, root);
        root = bt.addNode(19, root);
        root = bt.addNode(20, root);
        root = bt.addNode(4, root);
        root = bt.addNode(3, root);
        sot.spiralOrderByTwoStack(root);
        System.out.println();
        sot.spiralOrderByOneDeque(root);
    }
}
