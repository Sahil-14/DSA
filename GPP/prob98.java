
// graphs
import java.util.*;

public class prob98 {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    
    static void printList(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex :" + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print("->" + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    static void printMatrix(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] convert(ArrayList<ArrayList<Integer>> adjL, int[][] adjM) {
        int size = adjL.size();
        for (int i = 0; i < size; i++) {
            for (int j : adjL.get(i)) {
                adjM[i][j] = 1;
            }
        }
        return adjM;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        printList(adj);
        int[][] matrix = new int[V][V];
        matrix = convert(adj, matrix);
        printMatrix(matrix);
    }
}
