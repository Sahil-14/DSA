//Hamiltonian Cycle

/**
 * Hamiltonian Path in an undirected graph is a path that visits each vertex
 * exactly once. A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian
 * Path such that there is an edge (in the graph) from the last vertex to the
 * first vertex of the Hamiltonian Path. Determine whether a given graph
 * contains Hamiltonian Cycle or not. If it contains, then prints the path.
 * Following are the input and output of the required function.
 * Input:
 * A 2D array graph[V][V] where V is the number of vertices in graph and
 * graph[V][V] is adjacency matrix representation of the graph. A value
 * graph[i][j] is 1 if there is a direct edge from i to j, otherwise graph[i][j]
 * is 0.
 * Output:
 * An array path[V] that should contain the Hamiltonian Path. path[i] should
 * represent the ith vertex in the Hamiltonian Path. The code should also return
 * false if there is no Hamiltonian Cycle in the graph.
 * For example, a Hamiltonian Cycle in the following graph is {0, 1, 2, 4, 3,
 * 0}.
 * 
 * 
 * 
 * 
 */

public class prob24_graph {
  final int V = 5;
  int path[];

  boolean isSafe(int v, int graph[][], int path[], int pos) {
    /*
     * Check if this vertex is an adjacent vertex of
     * the previously added vertex.
     */
    if (graph[path[pos - 1]][v] == 0)
      return false;
    /*
     * Check if the vertex has already been included.
     * This step can be optimized by creating an array
     * of size V
     */
    for (int i = 0; i < pos; i++)
      if (path[i] == v)
        return false;

    return true;

  }

  boolean hamCycleUtil(int graph[][], int path[], int pos) {
    /*
     * base case: If all vertices are included in
     * Hamiltonian Cycle
     */
    if (pos == V) {
      // And if there is an edge from the last included
      // vertex to the first vertex
      if (graph[path[pos - 1]][path[0]] == 1)
        return true;
      else
        return false;
    }

    // Try different vertices as a next candidate in
    // Hamiltonian Cycle. We don't try for 0 as we
    // included 0 as starting point in hamCycle()
    for (int v = 1; v < V; v++) {
      /*
       * Check if this vertex can be added to Hamiltonian
       * Cycle
       */
      if (isSafe(v, graph, path, pos)) {
        path[pos] = v;

        /* recur to construct rest of the path */
        if (hamCycleUtil(graph, path, pos + 1) == true)
          return true;

        /*
         * If adding vertex v doesn't lead to a solution,
         * then remove it
         */
        path[pos] = -1;
      }
    }

    /*
     * If no vertex can be added to Hamiltonian Cycle
     * constructed so far, then return false
     */
    return false;
  }

  int hamCycle(int graph[][]) {
    path = new int[V];
    for (int i = 0; i < V; i++)
      path[i] = -1;

    /*
     * Let us put vertex 0 as the first vertex in the path.
     * If there is a Hamiltonian Cycle, then the path can be
     * started from any point of the cycle as the graph is
     * undirected
     */
    path[0] = 0;
    if (hamCycleUtil(graph, path, 1) == false) {
      System.out.println("\nSolution does not exist");
      return 0;
    }

    printSolution(path);
    return 1;
  }

  void printSolution(int path[]) {
    System.out.println("Solution Exists: Following" +
        " is one Hamiltonian Cycle");
    for (int i = 0; i < V; i++)
      System.out.print(" " + path[i] + " ");

    // Let us print the first vertex again to show the
    // complete cycle
    System.out.println(" " + path[0] + " ");
  }

  public static void main(String args[]) {
    prob24_graph hamiltonian = new prob24_graph();
    /*
     * Let us create the following graph
     * (0)--(1)--(2)
     * | / \ |
     * | / \ |
     * | / \ |
     * (3)-------(4)
     */
    int graph1[][] = { { 0, 1, 0, 1, 0 },
        { 1, 0, 1, 1, 1 },
        { 0, 1, 0, 0, 1 },
        { 1, 1, 0, 0, 1 },
        { 0, 1, 1, 1, 0 },
    };

    // Print the solution
    hamiltonian.hamCycle(graph1);

    /*
     * Let us create the following graph
     * (0)--(1)--(2)
     * | / \ |
     * | / \ |
     * | / \ |
     * (3) (4)
     */
    int graph2[][] = { { 0, 1, 0, 1, 0 },
        { 1, 0, 1, 1, 1 },
        { 0, 1, 0, 0, 1 },
        { 1, 1, 0, 0, 0 },
        { 0, 1, 1, 0, 0 },
    };

    // Print the solution
    hamiltonian.hamCycle(graph2);
  }
}
