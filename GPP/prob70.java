// create balanced bst from sorted array

public class prob70 {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    Node sortedArrayToBst(int arr[],int start,int end){
        if(start > end ){
            return  null;
        }
        int mid = (start +end)/2;
        Node root = new Node(arr[mid]);
        root.left = sortedArrayToBst(arr, start, mid-1);
        root.right = sortedArrayToBst(arr, mid+1, end);
        return root;
    }
    void preorder(Node root){
        if(root == null){
            return ;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        prob70 bst  = new prob70();
        int arr[]= {10,20,30,40,50};
        Node root = bst.sortedArrayToBst(arr, 0, arr.length-1);
        bst.preorder(root);
    }
}
