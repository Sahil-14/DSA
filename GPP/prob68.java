public class prob68 {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    class PreorderIndex{
        int preorderIdx = 0;
    }
    Node constructBst(int preorder[],PreorderIndex preorderIdx,int key,int min,int max,int n){
        if(preorderIdx.preorderIdx >= n){
            return null;
        }
        Node root = null;
        if(key > min && key < max){
            root = new Node(key);
            preorderIdx.preorderIdx = preorderIdx.preorderIdx+1;

            if(preorderIdx.preorderIdx < n){
                root.left = constructBst(preorder, preorderIdx, preorder[preorderIdx.preorderIdx], min, key, n);
            }
            if(preorderIdx.preorderIdx < n){
                root.right = constructBst(preorder, preorderIdx, preorder[preorderIdx.preorderIdx], key, max, n);
            }
        }
        return root;
    
    }
    void preorder(Node root){
        if(root == null ){
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        prob68 bst = new prob68();
        int preorder[] ={10,2,1,13,11};
        int n = 5;
        PreorderIndex preorderIdx = bst.new PreorderIndex();
        Node root = bst.constructBst(preorder, preorderIdx, preorder[0], Integer.MIN_VALUE,Integer.MAX_VALUE, 5);
        bst.preorder(root);
    }
}
