
// dijkstras algo for single source shortest path
// fail for negative weighted edges
/**
 * 
 * Algorithm 1) Create a set sptSet (shortest path tree set) that keeps track of
 * vertices included in the shortest-path tree, i.e., whose minimum distance
 * from the source is calculated and finalized. Initially, this set is empty.
 * 
 * 2) Assign a distance value to all vertices in the input graph. Initialize all
 * distance values as INFINITE. Assign distance value as 0 for the source vertex
 * so that it is picked first.
 * 
 * 3) While sptSet doesn’t include all vertices
 * 
 * ….a) Pick a vertex u which is not there in sptSet and has a minimum distance
 * value. ….b) Include u to sptSet.
 * 
 * ….c) Update distance value of all adjacent vertices of u. To update the
 * distance values, iterate through all adjacent vertices. For every adjacent
 * vertex v, if the sum of distance value of u (from source) and weight of edge
 * u-v, is less than the distance value of v, then update the distance value of
 * v.
 */

import java.util.*;

public class prob108 {
    static final int V = 9;

    int minDistance(int dist[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int i = 0; i < V; i++) {
            if (sptSet[i] == false && dist[i] <= min) {
                min = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }

    void printSol(int dist[], int[] parent) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.print(i + " \t\t " + dist[i] + " \t\t ");
            printPath(i, parent);
            System.out.println();
        }

    }

    void printPath(int currentIndex, int[] parent) {
        if (currentIndex == -1)
            return;
        printPath(parent[currentIndex], parent);
        System.out.print(currentIndex + " ");
    }

    void dijkstra(int graph[][], int src) {
        int dist[] = new int[V];
        int parent[] = new int[V];
        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;
        parent[src] = -1;

        for (int count = 0; count < V - 1; count++) {
            // find min distance vetex
            int u = minDistance(dist, sptSet);
            // mark picked vetex as true
            sptSet[u] = true;
            // update distance value;
            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[v] > graph[u][v] + dist[u]) {
                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                }
            }

        }

        printSol(dist, parent);
    }

    public static void main(String[] args) {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        prob108 t = new prob108();
        t.dijkstra(graph, 0);
    }
}
