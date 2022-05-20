
/**
 * 
 * Connected Components in an undirected graph
 * Given an undirected graph, print all connected components line by line. For
 * example consider the following graph.
 * 
 * 
 * 
 */
import java.util.ArrayList;

public class prob19_graph {
  int V;
  ArrayList<ArrayList<Integer>> adjListArray;

  prob19_graph(int V) {
    this.V = V;
    adjListArray = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adjListArray.add(i, new ArrayList<>());
    }
  }

  // Adds an edge to an undirected graph
  void addEdge(int src, int dest) {
    // Add an edge from src to dest.
    adjListArray.get(src).add(dest);

    // Since graph is undirected, add an edge from dest
    // to src also
    adjListArray.get(dest).add(src);
  }

  void DFSUtil(int v, boolean[] visited) {
    visited[v] = true;
    System.out.print(v + " ");
    for (int x : adjListArray.get(v)) {
      if (!visited[x]) {
        DFSUtil(x, visited);
      }
    }
  }

  void connectedComponents() {
    boolean[] visited = new boolean[V];
    for (int v = 0; v < V; ++v) {
      if (!visited[v]) {
        DFSUtil(v, visited);
        System.out.println();

      }
    }
  }

  // Driver code
  public static void main(String[] args) {
    // Create a graph given in the above diagram
    prob19_graph g = new prob19_graph(
        5); // 5 vertices numbered from 0 to 4

    g.addEdge(1, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 4);
    System.out.println(
        "Following are connected components");
    g.connectedComponents();
  }
}
