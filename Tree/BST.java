import BinaryTree.*;

public class BST {
    public Node Search(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (root.data == key) {
            return root;
        } else if (root.data < key) {
            return Search(root.right, key);
        } else {
            return Search(root.right, key);
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node root = null;
        root = bt.addNode(10, root);
        root = bt.addNode(20, root);
        root = bt.addNode(-10, root);
        root = bt.addNode(15, root);
        root = bt.addNode(0, root);
        root = bt.addNode(21, root);
        root = bt.addNode(-1, root);
        BST bstSearch = new BST();
        Node result = bstSearch.Search(root, 21);
        if(result.data == 21){
            System.out.println("present");
        }else{
            System.out.println("Not present");

        }
        // result = bstSearch.Search(root, -1);
        // assert result.data == 21;

        // result = bstSearch.Search(root, 11);
        // assert result == null;
    }
}
