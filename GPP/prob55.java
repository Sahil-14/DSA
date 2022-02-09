class TreeNode2 {
    int data;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class prob55 {
    TreeNode2 root;
    static int postIndex = 4;
    TreeNode2 buildTree(int inorder[],int postOrder[],int start,int end){
        if(start > end){
            return null;
        }
        TreeNode2  node = new TreeNode2(postOrder[postIndex--]);
        if(start == end){
            return node;
        }
        int index = search(inorder, start, end,node.data);
        node.right = buildTree(inorder, postOrder, index+1, end);
        node.left = buildTree(inorder, postOrder, start, index-1);
        return node;
    }
    int search(int inorder[], int start, int end, int curr) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == curr) {
                return i;
            }
        }
        return -1;
    }

    void inorderPrint(TreeNode2 root) {
        if (root == null) {
            return;
        }
        inorderPrint(root.left);
        System.out.println(root.data);
        inorderPrint(root.right);
    }
    public static void main(String[] args) {
        prob55 ob = new prob55();
        int postOrder[] = {4,2,5,3,1};
        int inorder[] = {4,2,1,5,3};
        TreeNode2 root = ob.buildTree(inorder, postOrder, 0, 4);
        ob.inorderPrint(root);
    }
}
