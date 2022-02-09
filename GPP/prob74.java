
// Largest bst
// for each node store infor
//1. min in subtree
//2. max in subtree
//subtree size
//4. size of larest bst
//5. is bst
public class prob74 {
    
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    static class Info{
        int size;
        int max;
        int min;
        int ans;
        boolean isBst;

        Info(){};
        Info(int size,int max,int min,int ans,boolean isBst){
            this.size = size;
            this.max = max;
            this.min = min;
            this.ans = ans;
            this.isBst = isBst;
        }
    }
    static Info largestBst(Node root){
        if(root == null){
            return new Info(0,Integer.MIN_VALUE,Integer.MAX_VALUE,0,true);
        }
        if(root.left == null && root.right == null){
            return new Info(1,root.data,root.data,1,true);
        }
        Info left = largestBst(root.left);
        Info right = largestBst(root.right);

        Info current = new Info();
        //confusion
        current.size = Math.max(left.size, right.size)+1;

        if(left.isBst && right.isBst && left.max < root.data && right.min > root.data){
            current.min = Math.min(left.min, Math.min(right.min, root.data));
            current.max = Math.max(left.max, Math.max(right.max, root.data));
            current.ans = current.size;
            current.isBst = true;
            return current;
        }
        current.ans = Math.max(left.ans,right.ans);
        current.isBst = false;
        return current;

    }
    public static void main(String[] args) {
        Node node = new Node(15);
        node.left = new Node(20);
        node.right = new Node(30);
        node.left.left = new Node(5);
      
        System.out.println(largestBst(node).ans);

    }
}
