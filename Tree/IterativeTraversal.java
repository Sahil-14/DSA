

import BinaryTree.*;
import java.util.Deque;
import java.util.LinkedList;

/**  -- Hint --
 * Inorder : 1)  Use single stack   **
 *           2)  push root into stack
 *           3)  while loop
 *           4)  Pop node from stack
 *           5)  if node is not null : push that node in the stack and new node = node.left : continue loop
 *           6)  if stack is null exit from loop
 *           7)  now the node is null hence pop item from stack and print it 
 *           8)  new node = node.right :  continue loop
 * 
 * PostOrder : 1) Use 2 stack
 * Preorder :  1) use 1 stack
 */


public class IterativeTraversal {
    void Postorder(Node root) {
        Deque<Node> stack1 = new LinkedList<Node>();
        Deque<Node> stack2 = new LinkedList<Node>();
        System.out.println("Iterative Postorder traversal :");
        stack1.addFirst(root);
        while (!stack1.isEmpty()) {
            Node node = stack1.pollFirst();
            if (node.left != null) {
                stack1.addFirst(node.left);
            }
            if (node.right != null) {
                stack1.addFirst(node.right);
            }
            stack2.addFirst(node);
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pollFirst().data+" ");
        }
    }

    void PreOrder(Node root) {
        Deque<Node> stack = new LinkedList<Node>();
        stack.addFirst(root);
        System.out.println("Iterative Preorder traversal :");

        while(!stack.isEmpty()){
            Node node = stack.pollFirst();
            System.out.println(node.data+" ");
            if(node.right != null){
                stack.addFirst(node.right);
            }
            if(node.left != null){
                stack.addFirst(node.left);
            }
        }

    }

    void Inorder(Node root){
        Deque<Node> stack = new LinkedList<Node>();
        Node node = root;
        System.out.println("Iterative Inorder traversal :");

        while(true){
            if(node != null){
                stack.addFirst(node);
                node = node.left;
            }else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pollFirst();
                System.out.println(node.data+" ");
                node = node.right;
            }
        }
    }

    public static void main(String arg[]){
        BinaryTree bt = new BinaryTree();
        Node root = null;
        IterativeTraversal itr = new IterativeTraversal();
        root = bt.addNode(10, root);
        root = bt.addNode(15, root);
        root = bt.addNode(5, root);
        root = bt.addNode(7, root);
        root = bt.addNode(19, root);
        root = bt.addNode(20, root);
        root = bt.addNode(4, root);
        root = bt.addNode(3, root);
        itr.Inorder(root);
        itr.PreOrder(root);
        itr.Postorder(root);
    }

}