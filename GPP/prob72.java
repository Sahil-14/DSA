import java.util.Vector;

/**
 * catalan numberes are a sequence of natural numbers that occur 
 * in various counting problems often involiving recursively defined objects
 * their closed form is in terms of binomial coefficients
 * c of n = 1/(n+1) * 2n c n = sum(ci cn-i, i = 0 to n-1)
 * first coefficient increament from 0 to n-1 and second from n-1 to 0
 */

public class prob72 {
     int catalan(int n){
        if(n <= 1){
            return 1;
        }
        int res = 0;
        for(int i = 0;i<=n-1;i++){
            res+= catalan(i)*catalan(n-i-1);
        }
        return res;
    }
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    Vector<Node>  constructTrees(int start ,int end){
        Vector<Node> trees = new Vector<>();
        if(start > end){
            trees.add(null);
            return trees;
        }
        for(int i = start;i<=end;i++){
            Vector<Node> leftSubtrees = constructTrees(start, i-1);
            Vector<Node> rightSubtree = constructTrees(i+1, end);
            for(int j = 0;j<leftSubtrees.size();j++){
                Node left = leftSubtrees.get(j);
                for(int k = 0;k<rightSubtree.size();k++){
                    Node right = rightSubtree.get(k);
                    Node node = new Node(i);
                    node.left = left;
                    node.right = right;
                    trees.add(node);
                }
            }
        }
        return trees;
    }
    void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        // for(int i = 0;i<10;i++){
        //     System.out.println(catalan(i));
        // }
        prob72 bst = new prob72();
         Vector<Node> totalTrees = bst.constructTrees(1, 3);
         for(int i = 0;i<totalTrees.size();i++){
            System.out.print(i+1+" :");
            bst.preorder(totalTrees.get(i));
            System.out.println();
         }
    }
}

// applications 
//1. possible bst
//2. paranthesis / brackets combination
//3. possible forests
//4. ways of triangulation
//5. possible paths in matrix
//6. dividing a circle using n chords
//7. Dyck words of gibben length 