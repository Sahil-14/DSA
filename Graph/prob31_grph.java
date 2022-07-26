
/**
 * Vertex Cover Problem
 * 
 * A vertex cover of an undirected graph is a subset of its vertices such that
 * for every edge (u, v) of the graph, either ‘u’ or ‘v’ is in the vertex cover.
 * Although the name is Vertex Cover, the set covers all edges of the given
 * graph. Given an undirected graph, the vertex cover problem is to find minimum
 * size vertex cover.
 * The following are some examples.
 * 
 */
import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class prob31_grph {
  private int V; // No. of vertices

  // Array of lists for Adjacency List Representation
  private LinkedList<Integer> adj[];

  // Constructor
  prob31_grph(int v) {
    V = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i)
      adj[i] = new LinkedList();
  }

  void addEdge(int v, int w) {
    adj[v].add(w); // Add w to v's list.
    adj[w].add(v); // Graph is undirected
  }

  void printVertexCover() {
    // Initialize all vertices as not visited.
    boolean visited[] = new boolean[V];
    for (int i = 0; i < V; i++)
      visited[i] = false;

    Iterator<Integer> i;

    // Consider all edges one by one
    for (int u = 0; u < V; u++) {
      // An edge is only picked when both visited[u]
      // and visited[v] are false
      if (visited[u] == false) {
        // Go through all adjacents of u and pick the
        // first not yet visited vertex (We are basically
        // picking an edge (u, v) from remaining edges.
        i = adj[u].iterator();
        while (i.hasNext()) {
          int v = i.next();
          if (visited[v] == false) {
            // Add the vertices (u, v) to the result
            // set. We make the vertex u and v visited
            // so that all edges from/to them would
            // be ignored
            visited[v] = true;
            visited[u] = true;
            break;
          }
        }
      }
    }

    // Print the vertex cover
    for (int j = 0; j < V; j++)
      if (visited[j])
        System.out.print(j + " ");
  }

  // Driver method
  public static void main(String args[]) {
    // Create a graph given in the above diagram
    prob31_grph g = new prob31_grph(5);
    g.addEdge(0, 2);
    g.addEdge(2, 4);
    g.addEdge(4, 3);
    g.addEdge(4, 1);
    // g.addEdge(3, 4);
    // g.addEdge(4, 5);
    // g.addEdge(5, 6);

    g.printVertexCover();
  }

}
