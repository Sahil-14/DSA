import java.util.Iterator;

/**
 * Given a sorted dictionary of an alien language, find order of characters
 * Input: words[] = {"baa", "abcd", "abca", "cab", "cad"}
 * Output: Order of characters is 'b', 'd', 'a', 'c'
 * Note that words are sorted and in the given language "baa"
 * comes before "abcd", therefore 'b' is before 'a' in output.
 * Similarly we can find other orders.
 * 
 * Input: words[] = {"caa", "aaa", "aab"}
 * Output: Order of characters is 'c', 'a', 'b'
 * 
 * 
 */
import java.util.*;

public class prob41_grph {

  // An array representing the graph as an adjacency list
  private final LinkedList<Integer>[] adjacencyList;

  prob41_grph(int nVertices) {
    adjacencyList = new LinkedList[nVertices];
    for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
      adjacencyList[vertexIndex] = new LinkedList<>();
    }
  }

  // function to add an edge to graph
  void addEdge(int startVertex, int endVertex) {
    adjacencyList[startVertex].add(endVertex);
  }

  private int getNoOfVertices() {
    return adjacencyList.length;
  }

  // A recursive function used by topologicalSort
  private void topologicalSortUtil(int currentVertex,
      boolean[] visited,
      Stack<Integer> stack) {

    visited[currentVertex] = true;

    for (int adjacentVertex : adjacencyList[currentVertex]) {
      if (!visited[adjacentVertex]) {
        topologicalSortUtil(adjacentVertex, visited, stack);
      }
    }

    stack.push(currentVertex);
  }

  void topologicalSort() {
    Stack<Integer> stack = new Stack<>();

    // Mark all the vertices as not visited
    boolean[] visited = new boolean[getNoOfVertices()];

    for (int i = 0; i < getNoOfVertices(); i++) {
      visited[i] = false;
    }

    // Call the recursive helper function to store
    // Topological Sort starting from all vertices one
    // by one
    for (int i = 0; i < getNoOfVertices(); i++) {
      if (!visited[i]) {
        topologicalSortUtil(i, visited, stack);
      }
    }

    // Print contents of stack
    while (!stack.isEmpty()) {
      System.out.print((char) ('a' + stack.pop())
          + " ");
    }
  }

  private void printOrder(String[] words, int n,
      int alpha) {

    for (int i = 0; i < n - 1; i++) {
      String word1 = words[i];
      String word2 = words[i + 1];
      for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
        // If we find a mismatching character, then
        // add an edge from character of word1 to
        // that of word2
        if (word1.charAt(j) != word2.charAt(j)) {
          addEdge(word1.charAt(j) - 'a',
              word2.charAt(j) - 'a');
          break;
        }
      }
    }

    graph.topologicalSort();

  }

  // This function finds and prints order
  // of character from a sorted array of words.
  // alpha is number of possible alphabets
  // starting from 'a'. For simplicity, this
  // function is written in a way that only
  // first 'alpha' characters can be there
  // in words array. For example if alpha
  // is 7, then words[] should contain words
  // having only 'a', 'b','c' 'd', 'e', 'f', 'g'

  // Driver program to test above functions
  public static void main(String[] args) {
    prob41_grph obj = new prob41_grph(3);
    String[] words = { "caa", "aaa", "aab" };
    obj.printOrder(words, 3, 3);
  }
}
