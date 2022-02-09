import java.util.*;
import java.util.Map.Entry;

//print  vertical order of binary tree
// step1 : starting from root node
// step2 : recursively call left and right with (hd-1) and (hd+1) as a arguments
//base case : if current node == null return
public class prob89 {
    static class Node{
        int key ;
        Node left;
        Node right;
        Node(int data){
            this.key = data;
            this.left = null;
            this.right = null;
        }
    };

    static void getVerticalOrder(Node root,int hd,TreeMap<Integer,Vector<Integer>> m){
        if(root == null){
            return;
        }

        Vector<Integer> get = m.get(hd);

        if(get == null){
            get = new Vector<>();
            get.add(root.key);
        }else{
            get.add(root.key);
        }

        m.put(hd,get);

        getVerticalOrder(root.left, hd-1, m);
        getVerticalOrder(root.right, hd+1, m);

    }

    static void print(Node root){
        TreeMap<Integer,Vector<Integer>> m = new TreeMap<>();
        int hd = 0;
        getVerticalOrder(root, hd, m);

        m.forEach((k,v) -> System.out.println(v));
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        print(root);
    }
}
