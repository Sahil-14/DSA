//Dijkstra’s shortest path algorithm | Greedy Algo-7
/**
 * Given a graph and a source vertex in the graph, find the shortest paths from
 * the source to all vertices in the given graph.
 * Dijkstra’s algorithm is very similar to Prim’s algorithm for minimum spanning
 * tree. Like Prim’s MST, we generate a SPT (shortest path tree) with a given
 * source as a root. We maintain two sets, one set contains vertices included in
 * the shortest-path tree, other set includes vertices not yet included in the
 * shortest-path tree. At every step of the algorithm, we find a vertex that is
 * in the other set (set of not yet included) and has a minimum distance from
 * the source.
 * Below are the detailed steps used in Dijkstra’s algorithm to find the
 * shortest path from a single source vertex to all other vertices in the given
 * graph.
 * 
 * 
 * O((V+E)LogV)
 * 
 */
public class prob8_graph {
  static final int V = 9;

  int minDistance(int key[], boolean sptSet[]) {
    int min = Integer.MAX_VALUE, min_index = -1;
    for (int v = 0; v < V; v++) {
      if (sptSet[v] == false && key[v] < min) {
        min = key[v];
        min_index = v;
      }
    }
    return min_index;
  }

  void printSolution(int dist[]) {
    System.out.println("Vertex \t\t Distance from Source");
    for (int i = 0; i < V; i++)
      System.out.println(i + " \t\t " + dist[i]);
  }

  public void DijkstraShortestpath(int graph[][], int src) {
    int dist[] = new int[V];

    boolean sptSet[] = new boolean[V];
    for (int i = 0; i < V; i++) {
      dist[i] = Integer.MAX_VALUE;
      sptSet[i] = false;
    }
    dist[src] = 0;
    for (int count = 0; count < V - 1; count++) {
      int u = minDistance(dist, sptSet);
      sptSet[u] = true;
      for (int v = 0; v < V; v++) {
        if (sptSet[v] == false && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
          dist[v] = dist[u] + graph[u][v];
        }
      }
    }
    printSolution(dist);
  }

  public static void main(String[] args) {
    /* Let us create the example graph discussed above */
    int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
        { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
        { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
        { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
        { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
        { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
        { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
        { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
    prob8_graph t = new prob8_graph();
    t.DijkstraShortestpath(graph, 0);
  }
}
