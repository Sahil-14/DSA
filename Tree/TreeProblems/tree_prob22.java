// print all bst from start to end
public class tree_prob22 {
  class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = this.right = null;
    }
  }

  Vector<Node> constructTrees(int start, int end) {
    Vector<Node> trees = new Vector<>();
    if (start > end) {
      trees.add(null);
      return trees;
    }
    for (int i = start; i <= end; i++) {
      Vector<Node> leftSubtrees = constructTrees(start, i - 1);
      Vector<Node> rightSubtree = constructTrees(i + 1, end);
      for (int j = 0; j < leftSubtrees.size(); j++) {
        Node left = leftSubtrees.get(j);
        for (int k = 0; k < rightSubtree.size(); k++) {
          Node right = rightSubtree.get(k);
          Node node = new Node(i);
          node.left = left;
          node.right = right;
          trees.add(node);
        }
      }
    }

  }
}
