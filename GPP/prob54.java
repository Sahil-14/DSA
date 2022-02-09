// build binary tree using preorder and inorder sequence

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class prob54 {

    TreeNode root;
    static int preIndex = 0;
    TreeNode buildTree(int inorder[],int preorder[],int start,int end){
        if(start > end){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preIndex++]);
        if(start == end ){
            return node;
        }
        int index = search(inorder, start, end, node.data);
        node.left = buildTree(inorder, preorder, start, index-1);
        node.right = buildTree(inorder, preorder, index+1, end);
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

    void inorderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderPrint(root.left);
        System.out.println(root.data);
        inorderPrint(root.right);
    }

    public static void main(String[] args) {
        prob54 ob = new prob54();
        int preorder[] = { 1, 2, 4, 3, 5 };
        int inorder[] = { 4, 2, 1, 5, 3 };
        TreeNode root = ob.buildTree(inorder, preorder, 0, 4);
        ob.inorderPrint(root);

    }
}
