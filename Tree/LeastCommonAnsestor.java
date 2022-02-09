import BinaryTree.*;

public class LeastCommonAnsestor {

        public Node LCAUsingBST(Node root,int n1,int n2){
            
            if(root.data > n1 && root.data >n2){
                return LCAUsingBST(root.left,n1,n2);
            }else if(root.data < n1 && root.data < n2 ){
                return LCAUsingBST(root.right, n1, n2);
            }else{
                return root;
            }
        }
        public Node LCAusingBT(Node root ,int n1,int n2){
            if(root == null){
                return null;
            }
            if(root.data == n1 || root.data == n2){
                return root;
            }
            Node left = LCAusingBT(root.left, n1, n2);
            Node right = LCAusingBT(root.right, n1, n2);
            if(left != null && right != null){
                return root;
            }
            if(left == null && right == null){
                return null;
            }
            return left != null ? left : right;
        }
        public static void main(String arg[]){
            LeastCommonAnsestor lca = new LeastCommonAnsestor();
            BinaryTree bt = new BinaryTree();
            Node root = null;
            root = bt.addNode(10, root);
            root = bt.addNode(15, root);
            root = bt.addNode(5, root);
            root = bt.addNode(7, root);
            root = bt.addNode(19, root);
            root = bt.addNode(20, root);
            root = bt.addNode(4, root);
            root = bt.addNode(3, root);
            System.out.println(lca.LCAusingBT(root, 4, 7).data);
            System.out.println(lca.LCAusingBT(root, 15, 19).data);
            System.out.println(lca.LCAusingBT(root, 3, 20).data);


        }
}
