//primes algo for mst
public class prob7_graph {
  private static final int V = 5;

  int findMinkey(int key[], Boolean mstSet[]) {
    int min = Integer.MAX_VALUE, min_index = -1;
    for (int v = 0; v < V; v++) {
      if (mstSet[v] == false && key[v] < min) {
        min = key[v];
        min_index = v;
      }
    }
    return min_index;
  }

  void printMst(int parent[], int graph[][]) {
    System.out.println("Edge \tWeight");
    for (int i = 1; i < V; i++) {
      System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }
  }

  void primsMst(int graph[][]) {
    // Array to store constructed MST
    int parent[] = new int[V];
    // Key values used to pick minimum weight edge in cut
    int key[] = new int[V];
    // To represent set of vertices included in MST
    Boolean mstSet[] = new Boolean[V];

    // Initialize all keys as INFINITE
    for (int i = 0; i < V; i++) {
      key[i] = Integer.MAX_VALUE;
      mstSet[i] = false;
    } 

    // Always include first 1st vertex in MST.
    key[0] = 0; // Make key 0 so that this vertex is
    // picked as first vertex
    parent[0] = -1; // First node is always root of MST

    for (int count = 0; count < V - 1; count++) {
      // Pick thd minimum key vertex from the set of vertices
      // not yet included in MST
      int u = findMinkey(key, mstSet);
      mstSet[u] = true;
      // Update key value and parent index of the adjacent
      // vertices of the picked vertex. Consider only those
      // vertices which are not yet included in MST
      for (int v = 0; v < V; v++)
        // graph[u][v] is non zero only for adjacent vertices of m
        // mstSet[v] is false for vertices not yet included in MST
        // Update the key only if graph[u][v] is smaller than key[v]
        if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
          parent[v] = u;
          key[v] = graph[u][v];
        }

    }
    printMst(parent, graph);

  }

  public static void main(String[] args) {
    /*
     * Let us create the following graph
     * 2 3
     * (0)--(1)--(2)
     * | / \ |
     * 6| 8/ \5 |7
     * | / \ |
     * (3)-------(4)
     * 9
     */
    prob7_graph t = new prob7_graph();
    int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
        { 2, 0, 3, 8, 5 },
        { 0, 3, 0, 0, 7 },
        { 6, 8, 0, 0, 9 },
        { 0, 5, 7, 9, 0 } };

    // Print the solution
    t.primsMst(graph);
  }

}
