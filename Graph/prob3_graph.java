import java.util.*;

//dfs -> stack
public class prob3_graph {
  int V;
  LinkedList<Integer> adj[];

  prob3_graph(int v) {
    V = v;
    adj = new LinkedList[V];
    for (int i = 0; i < v; ++i) {
      adj[i] = new LinkedList<>();
    }
  }

  public void addEdge(int u, int v) {
    adj[u].add(v);
  }

  public void dfs(int s, boolean visited[]) {
    visited[s] = true;
    System.out.println(s);
    Iterator<Integer> i = adj[s].listIterator();
    while (i.hasNext()) {
      int n = i.next();
      if (!visited[n]) {
        dfs(n, visited);
      }
    }
  }

  public static void main(String[] args) {
    prob3_graph g = new prob3_graph(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    boolean visited[] = new boolean[g.V];
    System.out.println("Following is Depth First Traversal ");

    g.dfs(2, visited);

  }
}
