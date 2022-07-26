
/**
 * Kruskal’s Minimum Spanning Tree Algorithm
 * 
 * What is a Spanning Tree?
 * 
 * A Spanning tree is a subset to a connected graph G, where all the edges are
 * connected, i.e, we can traverse to any edge from a particular edge with or
 * without intermediates. Also, a spanning tree must not have any cycle in it.
 * Thus we can say that if there are n vertices in a connected graph then the
 * no. of edges that a spanning tree may have is n-1.
 * 
 * 
 * What is Minimum Spanning Tree?
 * Given a connected and undirected graph, a spanning tree of that graph is a
 * subgraph that is a tree and connects all the vertices together. A single
 * graph can have many different spanning trees. A minimum spanning tree (MST)
 * or minimum weight spanning tree for a weighted, connected, undirected graph
 * is a spanning tree with a weight less than or equal to the weight of every
 * other spanning tree. The weight of a spanning tree is the sum of weights
 * given to each edge of the spanning tree.
 * How many edges does a minimum spanning tree has?
 * A minimum spanning tree has (V – 1) edges where V is the number of vertices
 * in the given graph.
 * What are the applications of the Minimum Spanning Tree?
 * See this for applications of MST.
 * 
 * 
1. Sort all the edges in non-decreasing order of their weight. 
2. Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far. If cycle is not formed, include this edge. Else, discard it. 
3. Repeat step#2 until there are (V-1) edges in the spanning tree.
 * 
 * 
 */
import java.util.*;
import java.lang.*;
import java.io.*;

public class prob34_grph {
  class Edge implements Comparable<Edge> {
    int src, dest, weight;

    // Comparator function used for
    // sorting edgesbased on their weight
    public int compareTo(Edge compareEdge) {
      return this.weight - compareEdge.weight;
    }
  }

  // A class to represent a subset for
  // union-find
  class subset {
    int parent, rank;
  };

  int V, E; // V-> no. of vertices & E->no.of edges
  Edge edge[]; // collection of all edges

  // Creates a graph with V vertices and E edges
  prob34_grph(int v, int e) {
    V = v;
    E = e;
    edge = new Edge[E];
    for (int i = 0; i < e; ++i)
      edge[i] = new Edge();
  }

  // A utility function to find set of an
  // element i (uses path compression technique)
  int find(subset subsets[], int i) {
    // find root and make root as parent of i
    // (path compression)
    if (subsets[i].parent != i)
      subsets[i].parent = find(subsets, subsets[i].parent);

    return subsets[i].parent;
  }

  // A function that does union of two sets
  // of x and y (uses union by rank)
  void Union(subset subsets[], int x, int y) {
    int xroot = find(subsets, x);
    int yroot = find(subsets, y);

    // Attach smaller rank tree under root
    // of high rank tree (Union by Rank)
    if (subsets[xroot].rank < subsets[yroot].rank)
      subsets[xroot].parent = yroot;
    else if (subsets[xroot].rank > subsets[yroot].rank)
      subsets[yroot].parent = xroot;

    // If ranks are same, then make one as
    // root and increment its rank by one
    else {
      subsets[yroot].parent = xroot;
      subsets[xroot].rank++;
    }
  }

  // The main function to construct MST using Kruskal's
  // algorithm
  void KruskalMST() {
    // This will store the resultant MST
    Edge result[] = new Edge[V];
    // An index variable, used for result[]
    int e = 0;
    // An index variable, used for sorted edges
    int i = 0;
    for (i = 0; i < V; ++i)
      result[i] = new Edge();

    // Step 1: Sort all the edges in non-decreasing
    // order of their weight. If we are not allowed to
    // change the given graph, we can create a copy of
    // array of edges
    Arrays.sort(edge);
    // Allocate memory for creating V subsets
    subset subsets[] = new subset[V];
    for (i = 0; i < V; i++) {
      subsets[i] = new subset();
    }

    // Create V subsets with single elements
    for (int v = 0; v < V; v++) {
      subsets[v].parent = v;
      subsets[v].rank = 0;
    }

    i = 0; // Index used to pick next edge

    // Number of edges to be taken is equal to V-1
    while (e < V - 1) {
      // Step 2: Pick the smallest edge. And increment
      // the index for next iteration
      Edge next_edge = edge[i++];

      int x = find(subsets, next_edge.src);
      int y = find(subsets, next_edge.dest);

      // If including this edge doesn't cause cycle,
      // include it in result and increment the index
      // of result for next edge
      if (x != y) {
        result[e++] = next_edge;
        Union(subsets, x, y);
      }
      // Else discard the next_edge

    }

    // print the contents of result[] to display
    // the built MST
    System.out.println("Following are the edges in "
        + "the constructed MST");

    int minimumCost = 0;
    for (i = 0; i < e; ++i) {
      System.out.println(result[i].src + " -- "
          + result[i].dest
          + " == " + result[i].weight);
      minimumCost += result[i].weight;
    }
    System.out.println("Minimum Cost Spanning Tree "
        + minimumCost);

  }

  // Driver Code
  public static void main(String[] args) {

    /*
     * Let us create following weighted graph
     * 10
     * 0--------1
     * | \ |
     * 6| 5\ |15
     * | \ |
     * 2--------3
     * 4
     */
    int V = 4; // Number of vertices in graph
    int E = 5; // Number of edges in graph
    prob34_grph graph = new prob34_grph(V, E);

    // add edge 0-1
    graph.edge[0].src = 0;
    graph.edge[0].dest = 1;
    graph.edge[0].weight = 10;

    // add edge 0-2
    graph.edge[1].src = 0;
    graph.edge[1].dest = 2;
    graph.edge[1].weight = 6;

    // add edge 0-3
    graph.edge[2].src = 0;
    graph.edge[2].dest = 3;
    graph.edge[2].weight = 5;

    // add edge 1-3
    graph.edge[3].src = 1;
    graph.edge[3].dest = 3;
    graph.edge[3].weight = 15;

    // add edge 2-3
    graph.edge[4].src = 2;
    graph.edge[4].dest = 3;
    graph.edge[4].weight = 4;

    // Function call
    graph.KruskalMST();
  }

}
