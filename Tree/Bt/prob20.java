import java.util.*;

public class prob20 {
  private int V; // No. of vertices
  private LinkedList<Integer> adj[]; // Adjacency List

  @SuppressWarnings("unchecked")
  prob20(int v) {
    V = v;
    adj = new LinkedList[V];
    for (int i = 0; i < v; i++) {
      adj[i] = new LinkedList<Integer>();
    }
  }

  // Function to add an edge into the graph
  void addEdge(int v, int w) {
    adj[v].add(w);
    adj[w].add(v);
  }

  boolean isCyclicUtil(int v, boolean visited[], int parent) {
    // Mark the current node as visited
    visited[v] = true;
    Integer i;

    // Recur for all the vertices adjacent to this vertex
    Iterator<Integer> it = adj[v].iterator();
    while (it.hasNext()) {
      i = it.next();

      // If an adjacent is not visited, then recur for
      // that adjacent
      if (!visited[i]) {
        if (isCyclicUtil(i, visited, v))
          return true;
      }

      // If an adjacent is visited and not parent of
      // current vertex, then there is a cycle.
      else if (i != parent)
        return true;
    }
    return false;
  }

  boolean isTree() {
    boolean visited[] = new boolean[V];
    for (int i = 0; i < V; i++)
      visited[i] = false;

    if (isCyclicUtil(0, visited, -1))
      return false;

    for (int u = 0; u < V; u++)
      if (!visited[u])
        return false;

    return true;

  }

  public static void main(String args[]) {
    // Create a graph given in the above diagram
    prob20 g1 = new prob20(5);
    g1.addEdge(1, 0);
    g1.addEdge(0, 2);
    g1.addEdge(0, 3);
    g1.addEdge(3, 4);
    if (g1.isTree())
      System.out.println("Graph is Tree");
    else
      System.out.println("Graph is not Tree");

    prob20 g2 = new prob20(5);
    g2.addEdge(1, 0);
    g2.addEdge(0, 2);
    g2.addEdge(2, 1);
    g2.addEdge(0, 3);
    g2.addEdge(3, 4);

    if (g2.isTree())
      System.out.println("Graph is Tree");
    else
      System.out.println("Graph is not Tree");

  }

}
