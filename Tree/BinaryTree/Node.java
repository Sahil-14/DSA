package BinaryTree;

public class Node {
    public Node left;
    public Node right;
    public Node next;
    public Node parent;
    public int size;
    public int height;
    public int lis;
    public int data;
    public Color color;
  
    public static Node newNode(int data){
        Node n = new Node();
        n.left = null;
        n.right = null;
        n.parent = null;
        n.data = data;
        n.size = 1;
        n.height = -1;
        n.lis = -1;
        n.color = Color.RED;
        return n;
    }
}
