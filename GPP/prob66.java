// binary search tree
public class prob66 {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    Node insertBST(Node root,int val){
        if(root == null){
            return new Node(val);
        }
        if(val < root.data){
            root.left = insertBST(root.left, val);
        }else{
            root.right = insertBST(root.right, val);
        }
        return root;

    }  
    Node search(Node root ,int key){
        if(root == null){
            return null;
        }
        if(root.data == key){
            return root;
        }else if(root.data > key){
            return search(root.left, key);
        }
        return search(root.right, key);  
    }
    void inorder(Node root){
        if(root == null){
            return ;
        }
       

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
      
    }
    Node deleteRec(Node root,int key){
        if(root == null){
            return null;
        }
        if(root.data > key){
            root.left = deleteRec(root.left, key);
        }else if(root.data < key){
            root.right = deleteRec(root.right, key);
        }
        else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
           int minval =  inorderSucc(root.right);
           root
        }
    }
    int inorderSucc(Node root){
        Node temp = root;
        while(temp.left != null){
            temp = temp.left;
        }
        return temp.data;
    }
     public static void main(String[] args) {
         prob66 bst = new prob66();

         Node root = bst.new Node(5);
         root = bst.insertBST(root, 1);
         root = bst.insertBST(root, 3);
         root = bst.insertBST(root, 4);
         root = bst.insertBST(root, 2);
         root = bst.insertBST(root, 7);
         bst.inorder(root);
         if(bst.search(root, 8) == null){
             System.out.println("Not found");
         }else{
            System.out.println(" found");

         }
     }
}
