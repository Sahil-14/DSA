import java.util.ArrayList;
import java.util.*;

/**
 * Minimize count of connections required to be rearranged to make all the
 * computers connected
 * 
 * Given an integer N, denoting the number of computers connected by cables
 * forming a network and a 2D array connections[][], with each row (i, j)
 * representing a connection between ith and jth computer, the task is to
 * connect all the computers either directly or indirectly by removing any of
 * the given connections and connecting two disconnected computers.
 * If it’s not possible to connect all the computers, print -1.
 * Otherwise, print the minimum number of such operations required.
 * 
 * 
 * Input: N = 4, connections[][] = {{0, 1}, {0, 2}, {1, 2}}
 * Output: 1
 * Explanation: Remove the connection between computers 1 and 2 and connect the
 * computers 1 and 3.
 * 
 * Input: N = 5, connections[][] = {{0, 1}, {0, 2}, {3, 4}, {2, 3}}
 * Output: 0
 * 
 * 
 * Initialize an unordered map, say adj to store the adjacency list from the
 * given information about edges.
 * Initialize a vector of boolean datatype, say visited, to store whether a node
 * is visited or not.
 * Generate the adjacency list and also calculate the number of edges.
 * Initialize a variable, say components, to store the count of connected
 * components.
 * Traverse the nodes of the graph using DFS to count the number of connected
 * components and store it in the variable components.
 * Initialize a variable, say redundant, and store the number of redundant edges
 * using the above formula.
 * If redundant edges > components – 1, then the minimum number of required
 * operations is equal to components – 1. Otherwise, print -1.
 * 
 * 
 * 
 */

public class prob18_graph {
  public static void dfs(List<Integer>[] graph, int u, Set<Integer> seen) {
    for (final int v : graph[u]) {
      if (!seen.contains(v)) {
        seen.add(v);
        dfs(graph, v, seen);
      }
    }
  }

  public static int makeConnected(int n, int[][] connections) {
    if (connections.length < n - 1) {
      return -1;
    }
    int numOfConnected = 0;
    List<Integer>[] graph = new List[n];
    Set<Integer> seen = new HashSet<>();

    for (int i = 0; i < n; ++i)
      graph[i] = new ArrayList<>();
    for (int[] conn : connections) {
      graph[conn[0]].add(conn[1]);
      graph[conn[1]].add(conn[0]);
    }

    for (int i = 0; i < n; ++i)
      if (!seen.contains(i)) {
        seen.add(i);
        dfs(graph, i, seen);
        ++numOfConnected;
      }
    return numOfConnected - 1;

  }

  public static void main(String[] args) {
    // Given number of computers
    int N = 4;

    // Given set of connections
    int connections[][] = { { 0, 1 }, { 0, 2 }, { 1, 2 } };

    // Function call to check if it is
    // possible to connect all computers or not
    makeConnected(N, connections);
  }
}
