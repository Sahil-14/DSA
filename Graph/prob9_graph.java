import java.util.HashSet;

/**
 * Disjoint Set (Or Union-Find) | Set 1 (Detect Cycle in an Undirected Graph)
 * Find: Determine which subset a particular element is in. This can be used for
 * determining if two elements are in the same subset.
 * 
 * Union: Join two subsets into a single subset. Here first we have to check if
 * the two subsets belong to same set. If no, then we cannot perform union.
 * 
 * For each edge, make subsets using both the vertices of the edge. If both the
 * vertices are in the same subset, a cycle is found.
 * 
 * Initially, all slots of parent array are initialized to -1 (means there is
 * only one item in every subset).
 * 
 * 0 1 2 <----- 2 is made parent of 1 (2 is now representative of subset {0,
 * 1,2})
 * 1 2 -1
 * 
 */
public class prob8_graph {
  int V, E;
  Edge edge[];

  class Edge {
    int src, dest;
  };

  prob8_graph(int v, int e) {
    V = v;
    E = e;
    edge = new Edge[E];
    for (int i = 0; i < e; ++i)
      edge[i] = new Edge();
  }

  // this union and find has time complexity o(n)
  // A utility function to find the subset of an element i
  int find(int parent[], int i) {
    if (parent[i] == -1)
      return i;
    return find(parent, parent[i]);
  }

  void Union(int parent[], int x, int y) {
    parent[x] = y;
  }

  int isCycle(prob8_graph graph) {
    int parent[] = new int[graph.V];

    // Initialize all subsets as single element sets

    for (int i = 0; i < graph.V; ++i)
      parent[i] = -1;

    for (int i = 0; i < graph.E; i++) {
      int x = graph.find(parent, graph.edge[i].src);
      int y = graph.find(parent, graph.edge[i].dest);
      if (x == y)
        return 1;
      graph.Union(parent, x, y);

    }
    return 0;
  }

  public static void main(String[] args) {
    /*
     * Let us create the following graph
     * 0
     * | \
     * | \
     * 1---2
     */
    int V = 3, E = 3;
    prob8_graph graph = new prob8_graph(V, E);

    // add edge 0-1
    graph.edge[0].src = 0;
    graph.edge[0].dest = 1;

    // add edge 1-2
    graph.edge[1].src = 1;
    graph.edge[1].dest = 2;

    // add edge 0-2
    graph.edge[2].src = 0;
    graph.edge[2].dest = 2;

    if (graph.isCycle(graph) == 1)
      System.out.println("graph contains cycle");
    else
      System.out.println("graph doesn't contain cycle");
  }
}
