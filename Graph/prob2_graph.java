import java.util.Iterator;
import java.util.LinkedList;

//bfs
public class prob2_graph {
  int V = 5;
  LinkedList<Integer> adj[];

  prob2_graph(int v) {
    V = v;
    adj = new LinkedList[V];
    for (int i = 0; i < V; i++) {
      adj[i] = new LinkedList<>();
    }
  }

  void addEdge(int u, int v) {
    adj[u].add(v);
  }

  public void bfs(int s) {
    boolean visited[] = new boolean[V];
    LinkedList<Integer> q = new LinkedList<>();
    visited[s] = true;
    q.add(s);
    while (!q.isEmpty()) {
      int ele = q.poll();
      System.out.println(ele);
      Iterator<Integer> i = adj[ele].listIterator();
      while (i.hasNext()) {
        int n = i.next();
        if (!visited[n]) {
          visited[n] = true;
          q.add(n);
        }
      }
    }

  }

  public static void main(String[] args) {
    prob2_graph g = new prob2_graph(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    System.out.println("Following is Breadth First Traversal ");
    g.bfs(2);

  }

}
