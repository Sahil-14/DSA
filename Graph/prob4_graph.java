import java.util.Iterator;
import java.util.*;

//topological sort
//dfs
public class prob4_graph {
  private int V;
  private ArrayList<ArrayList<Integer>> adj;

  prob4_graph(int v) {
    V = v;
    adj = new ArrayList<ArrayList<Integer>>();

    for (int i = 0; i < v; i++) {
      adj.add(new ArrayList<Integer>());
    }
  }

  void addEdge(int u, int v) {
    adj.get(u).add(v);
  }

  public void topologicalSortUtil(int v, Stack<Integer> s, boolean[] visited) {
    visited[v] = true;
    Iterator<Integer> i = adj.get(v).iterator();
    while (i.hasNext()) {
      int n = i.next();
      if (!visited[n]) {
        topologicalSortUtil(n, s, visited);
      }
    }
    s.push(v);
  }

  public void topologicalSort() {
    Stack<Integer> s = new Stack<>();
    boolean visited[] = new boolean[V];

    for (int i = 0; i < V; i++) {
      visited[i] = false;
    }

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        topologicalSortUtil(i, s, visited);
      }
    }

    while (!s.isEmpty()) {
      System.out.println(s.pop());
    }
  }

  public static void main(String args[]) {
    // Create a graph given in the above diagram
    prob4_graph g = new prob4_graph(6);
    g.addEdge(5, 2);
    g.addEdge(5, 0);
    g.addEdge(4, 0);
    g.addEdge(4, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 1);
    System.out.println("Following is a Topological "
        + "sort of the given graph");
    // Function Call
    g.topologicalSort();
  }
}
