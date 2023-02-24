import java.util.Iterator;

//detect cycle in directed graph
public class prob6_graph {
  // No. of vertices
  private int V;

  // Adjacency List Representation
  private LinkedList<Integer> adj[];

  prob102(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

  void addEdge(int u, int v) {
    adj[u].add(v);

  }

  boolean isCycleUtil(int i, boolean[] visited, boolean[] recStack) {
    // if already present in recstack mean cycle
    if (recStack[i]) {
      return true;
    }
    
    if (visited[i])
      return false;

    // mark true to visited an recStack
    visited[i] = true;
    recStack[i] = true;
    Iterator<Integer> it = adj[i].iterator();
    while (it.hasNext()) {
      int n = it.next();
      if (isCycleUtil(n, visited, recStack))
        return true;
    }
    // if no cycle in tree then mark false;
    recStack[i] = false;
    return false;

  }

  boolean isCyclic() {
    boolean visited[] = new boolean[V];
    boolean recStack[] = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        if (isCyclicUtil(i, visited, recStack)) {
          return true;
        }
      }
    }
    return false;
  }
}
