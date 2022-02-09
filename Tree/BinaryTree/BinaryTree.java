package BinaryTree;
class NodeRef{
    Node node;
}

enum Color{
    RED,
    BLACK
}

public class BinaryTree {
    public Node addNode(int data,Node head){
        Node tempHead = head;
        Node n = Node.newNode(data);
        if(head == null){
            head = n;
            return head;
        }
        Node parent = null;
        while(head != null){
            parent = head;
            if(head.data<data){
               head = head.right;
            }else{
                head = head.left;
            }
        }
        if(parent.data < data){
            parent.right = n;
        }else{
            parent.left = n;
        }
        return tempHead;
    }
}
