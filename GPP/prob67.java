public class prob67 {
    class Node {
        int key;
        Node left, right;
 
        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }
    Node root;
    prob67() { root = null; }
    void deleteKey(int key) { root = deleteRec(root, key); }
    Node deleteRec(Node root, int key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;
 
        /* Otherwise, recur down the tree */
        //we are inserting here
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
 
        // if key is same as root's
        // key, then This is the
        // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.key = minValue(root.right);
 
            // Delete the inorder successor by calling delete function 
            root.right = deleteRec(root.right, root.key);
            // as the successor is always greater than root (key > root ) node.right is use to store
        }
 
        return root;
    }
 
    int minValue(Node root)
    {
        int minv = root.key;
        while (root.left != null)
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
 
}
