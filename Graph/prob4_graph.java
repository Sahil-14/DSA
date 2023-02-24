import java.util.Iterator;
import java.util.*;

//topological sort
/**
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of
 * vertices such that for every directed edge u v, vertex u comes before v in
 * the ordering. Topological Sorting for a graph is not possible if the graph is
 * not a DAG.
 * 
 * For example, a topological sorting of the following graph is “5 4 2 3 1 0”.
 * There can be more than one topological sorting for a graph. For example,
 * another topological sorting of the following graph is “4 5 2 3 1 0”. The
 * first vertex in topological sorting is always a vertex with in-degree as 0 (a
 * vertex with no incoming edges).
 *
 * 
 * 
 * 
 * 
 * 
 */

// dfs
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

  // kahn's algorithm
  public void topologicalSort2() {
    int indegree[] = new int[V];

    for (int i = 0; i < V; i++) {
      ArrayList<Integer> temp = adj.get(i);
      for (int node : temp) {
        indegree[node]++;
      }
    }

    Queue<Integer> q = new LinkedList<Integer>();
    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0)
        q.add(i);
    }

    int cnt = 0;

    Vector<Integer> topOrder = new Vector<>();
    while (!q.isEmpty()) {
      int u = q.poll();
      topOrder.add(u);

      for (int node : adj.get(u)) {
        if (--indegree[node] == 0) {
          q.add(node);
        }
      }
      cnt++;
    }

    // Check if there was a cycle
    if (cnt != V) {
      System.out.println(
          "There exists a cycle in the graph");
      return;
    }

    // Print topological order
    for (int i : topOrder) {
      System.out.print(i + " ");
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
    g.topologicalSort2();
  }
}
