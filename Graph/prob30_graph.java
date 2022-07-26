/**
 * Find whether it is possible to finish all tasks or not from given
 * dependencies
 * There are a total of n tasks you have to pick, labelled from 0 to n-1. Some
 * tasks may have prerequisites, for example to pick task 0 you have to first
 * pick task 1, which is expressed as a pair: [0, 1]
 * Given the total number of tasks and a list of prerequisite pairs, is it
 * possible for you to finish all tasks?
 * 
 * 
 * Input: 2, [[1, 0]]
 * Output: true
 * Explanation: There are a total of 2 tasks to pick. To pick task 1 you should
 * have finished task 0. So it is possible.
 * Input: 2, [[1, 0], [0, 1]]
 * Output: false
 * Explanation: There are a total of 2 tasks to pick. To pick task 1 you should
 * have finished task 0, and to pick task 0 you should also have finished task
 * 1. So it is impossible.
 * Input: 3, [[1, 0], [2, 1], [3, 2]]
 * Output: true
 * Explanation: There are a total of 3 tasks to pick. To pick tasks 1 you should
 * have finished task 0, and to pick task 2 you should have finished task 1 and
 * to pick task 3 you should have finished task 2. So it is possible.
 * 
 * We can consider this problem as a graph (related to topological sorting)
 * problem. All tasks are nodes of the graph and if task u is a prerequisite of
 * task v, we will add a directed edge from node u to node v. Now, this problem
 * is equivalent to detecting a cycle in the graph represented by prerequisites.
 * If there is a cycle in the graph, then it is not possible to finish all tasks
 * (because in that case there is no any topological order of tasks). Both BFS
 * and DFS can be used to solve it.
 * Since pair is inconvenient for the implementation of graph algorithms, we
 * first transform it to a graph. If task u is a prerequisite of task v, we will
 * add a directed edge from node u to node v.
 * 
 * 
 */

// using dfs
public class prob30_graph {
  // class to store dependencies as a pair
  static class pair {
    int first, second;

    pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  // Returns adjacency list representation from a list
  // of pairs.
  static ArrayList<ArrayList<Integer>> make_graph(int numTasks,
      Vector<pair> prerequisites) {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(numTasks);
    for (int i = 0; i < numTasks; i++) {
      graph.add(new ArrayList<Integer>());
    }

    for (pair pre : prerequisites)
      graph.get(pre.second).add(pre.first);
    return graph;

  }

  // A DFS based function to check if there is a cycle
  // in the directed graph
  static boolean dfs_cycle(ArrayList<ArrayList<Integer>> graph, int node,
      boolean onpath[], boolean visited[]) {

    if (visited[node])
      return false;

    onpath[node] = visited[node] = true;
    for (int neigh : graph.get(node))
      if (onpath[neigh] || dfs_cycle(graph, neigh, onpath, visited))
        return true;

    return onpath[node] = false;

  }

  // Main function to check whether possible to finish all tasks or not
  static boolean canFinish(int numTasks, Vector<pair> prerequisites) {
    ArrayList<ArrayList<Integer>> graph = make_graph(numTasks, prerequisites);

    boolean onpath[] = new boolean[numTasks];
    boolean visited[] = new boolean[numTasks];

    for (int i = 0; i < numTasks; i++)
      if (!visited[i] && dfs_cycle(graph, i, onpath, visited))
        return false;

    return true;
  }

  public static void main(String args[]) {
    int numTasks = 4;

    Vector<pair> prerequisites = new Vector<pair>();
    ;

    // for prerequisites: [[1, 0], [2, 1], [3, 2]]

    prerequisites.add(new pair(1, 0));
    prerequisites.add(new pair(2, 1));
    prerequisites.add(new pair(3, 2));

    if (canFinish(numTasks, prerequisites)) {
      System.out.println("Possible to finish all tasks");
    } else {
      System.out.println("Impossible to finish all tasks");
    }
  }
}

/**
 * Using BFS
 * BFS can be used to solve it using the idea of topological sort. If
 * topological sorting is possible, it means there is no cycle and it is
 * possible to finish all the tasks.
 * BFS uses the indegrees of each node. We will first try to find a node with 0
 * indegree. If we fail to do so, there must be a cycle in the graph and we
 * return false. Otherwise we have found one. We set its indegree to be -1 to
 * prevent from visiting it again and reduce the indegrees of all its neighbors
 * by 1. This process will be repeated for n (number of nodes) times. If we have
 * not returned false, we will return true.
 * 
 * 
 * 
 */

// public class GFG {

//   // class to store dependencies as a pair
//   static class pair {
//     int first, second;

//     pair(int first, int second) {
//       this.first = first;
//       this.second = second;
//     }
//   }

//   // Returns adjacency list representation from a list
//   // of pairs.
//   static ArrayList<ArrayList<Integer>> make_graph(int numTasks, Vector<pair> prerequisites) {
//     ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(numTasks);

//     for (int i = 0; i < numTasks; i++) {
//       graph.add(new ArrayList<Integer>());
//     }

//     for (pair pre : prerequisites)
//       graph.get(pre.second).add(pre.first);

//     return graph;
//   }

//   // Finds in-degree of every vertex
//   static int[] compute_indegree(
//       ArrayList<ArrayList<Integer>> graph) {
//     int degrees[] = new int[graph.size()];

//     for (ArrayList<Integer> neighbors : graph)
//       for (int neigh : neighbors)
//         degrees[neigh]++;

//     return degrees;
//   }

//   // Main function to check whether possible to finish all
//   // tasks or not
//   static boolean canFinish(int numTasks,
//       Vector<pair> prerequisites) {
//     ArrayList<ArrayList<Integer>> graph = make_graph(numTasks, prerequisites);
//     int degrees[] = compute_indegree(graph);

//     for (int i = 0; i < numTasks; i++) {
//       int j = 0;
//       for (; j < numTasks; j++)
//         if (degrees[j] == 0)
//           break;

//       if (j == numTasks)
//         return false;

//       degrees[j] = -1;
//       for (int neigh : graph.get(j))
//         degrees[neigh]--;
//     }

//     return true;
//   }

//   public static void main(String args[]) {
//     int numTasks = 4;
//     Vector<pair> prerequisites = new Vector<pair>();

//     prerequisites.add(new pair(1, 0));
//     prerequisites.add(new pair(2, 1));
//     prerequisites.add(new pair(3, 2));

//     if (canFinish(numTasks, prerequisites)) {
//       System.out.println(
//           "Possible to finish all tasks");
//     } else {
//       System.out.println(
//           "Impossible to finish all tasks");
//     }
//   }
// }
