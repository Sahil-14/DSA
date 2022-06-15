
//level order traversal
public class prob5 {
  public void levelOrder(Node root) {
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      Node node = q.poll();
      System.out.println(node.data);
      if (node.left != null) {
        q.add(node.left);
      }
      if (node.right != null) {
        q.add(node.right);
      }
    }
  }

}
