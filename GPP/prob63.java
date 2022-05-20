// find nodes at distance k
public class prob63 {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    //case 1
    void printSubtreeNodes(Node root,int k){
        if(root == null || k <0){
            return;
        }
        if(k == 0){
            System.out.println(root.data);
        }
        printSubtreeNodes(root.left, k-1);
        printSubtreeNodes(root.right, k-1);
    }

    //case 2
    int printNodeAtk(Node root,Node target,int k){
        if(root == null){
            return -1;
        }
        if(root == target){
            printSubtreeNodes(root, k);
            return 0;
        }
         
        int dl = printNodeAtk(root.left, target, k);
       if(dl != 1){
           //current node is at kth distance form target
           if(dl+1 == k){
               System.out.print(root.data);
           }else{
               printSubtreeNodes(root.right, k-dl-2);
           }
           return 1+dl;
       }
       int dr = printNodeAtk(root.right, target, k);
       if(dr != 1){
           if(dr+1 == k){
               System.out.print(root.data);
           }else{
               printSubtreeNodes(root.left, k-dr-2);
           }
           return 1+dr;
       }
       return -1;
    }
    public static void main(String[] args) {
        prob63 bt = new prob63();
        Node root = bt.new Node(1);
        root.left = bt.new Node(2);
        root.right = bt.new Node(3);
        root.left.left = bt.new Node(4);
        bt.printNodeAtk(root, root.left, 1); 
    }

}
