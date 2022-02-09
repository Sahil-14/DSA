
// Maximum path sum

public class prob65 {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    class Ans{
        public int ans;
    }

    int maxPathSumUtil(Node root,Ans ans){
        if(root == null){
            return 0;
        }
        int leftSum = maxPathSumUtil(root.left,ans);
        int righSum = maxPathSumUtil(root.right,ans);
        int nodeMax = Math.max(Math.max(root.data, root.data+leftSum+righSum), Math.max(root.data+leftSum, root.data+righSum));
        ans.ans = Math.max(ans.ans, nodeMax);
        // find single path
        int singlePathSum = Math.max(root.data,Math.max(root.data+leftSum, root.data+righSum));
        return singlePathSum;


    }

    int maxPathSum(Node root) {
        Ans ans = new Ans();
         ans.ans = Integer.MIN_VALUE;
        maxPathSumUtil(root, ans);
        return ans.ans;
    }

    public static void main(String[] args) {
        prob65 bt = new prob65();
        Node root = bt.new Node(1);
        root.left = bt.new Node(2);
        root.right = bt.new Node(3);
        root.left.left = bt.new Node(4);
        root.right.right = bt.new Node(5);
        System.out.println(bt.maxPathSum(root));
    }
}
