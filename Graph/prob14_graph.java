/**
 * Number of Triangles in Directed and Undirected Graphs
 * 
 * Let A[][] be the adjacency matrix representation of the graph. If we
 * calculate A3, then the number of triangles in Undirected Graph is equal to
 * trace(A3) / 6. Where trace(A) is the sum of the elements on the main diagonal
 * of matrix A.
 * 
 * 
 */
public class prob14_graph {
  int V = 4;

  int countTriangle(int graph[][], boolean isDirected) {
    int count = 0;
    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        for (int k = 0; k < V; k++) {
          if (graph[i][j] == 1 && graph[j][k] == 1 && graph[k][i] == 1) {
            count++;
          }
        }
      }
    }

    if (isDirected) {
      return count /= 3;
    } else {
      return count /= 6;
    }

  }

  public static void main(String args[]) {

    // Create adjacency matrix
    // of an undirected graph
    int graph[][] = { { 0, 1, 1, 0 },
        { 1, 0, 1, 1 },
        { 1, 1, 0, 1 },
        { 0, 1, 1, 0 }
    };

    // Create adjacency matrix
    // of a directed graph
    int digraph[][] = { { 0, 0, 1, 0 },
        { 1, 0, 0, 1 },
        { 0, 1, 0, 0 },
        { 0, 0, 1, 0 }
    };

    prob14_graph obj = new prob14_graph();

    System.out.println("The Number of triangles " +
        "in undirected graph : " +
        obj.countTriangle(graph, false));

    System.out.println("\n\nThe Number of triangles" +
        " in directed graph : " +
        obj.countTriangle(digraph, true));

  }
}
