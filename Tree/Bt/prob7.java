//print right view
public class prob7 {
  public static void rightView(Node root) {
    if (root == null) {
      return;
    }
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 1; i <= size; i++) {
        Node temp = q.poll;
        if (i == size) {
          System.out.println(temp.data);
        }
        if (temp.left != null) {
          q.add(temp.left);
        }

        if (temp.right != null) {
          q.add(temp.right);
        }

      }
    }
  }
}
