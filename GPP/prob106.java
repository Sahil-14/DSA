
//Minimum spaning tree using kruskals algorithm
//step1: sort the edges in increaseing order of their weight
//step2: iterate through sorted edges
//        if inclusion of edge leads to a cycle then skip this edge
//        else include this edge
//T(O) elogV

/**
 * 
 * Given a connected and undirected graph, a spanning tree of that graph is a subgraph that is a tree and connects all the vertices together. A single graph can have many different spanning trees. A minimum spanning tree (MST) or minimum weight spanning tree for a weighted, connected, undirected graph is a spanning tree with a weight less than or equal to the weight of every other spanning tree. The weight of a spanning tree is the sum of weights given to each edge of the spanning tree.
A minimum spanning tree has (V – 1) edges where V is the number of vertices in the given graph. 
 * 
 */
import java.util.*;

public class prob106 {

    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    class subset {
        int parent, rank;
    }

    int V, E;
    Edge edge[];

    prob106(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; i++)
            edge[i] = new Edge();
    }

    int find(subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void Union(subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[xroot].parent = yroot;
            subsets[yroot].rank++;
        }
    }

    void kruskalsMST() {

        // Tnis will store the resultant MST
        Edge result[] = new Edge[V];

        int e = 0;

        int i = 0;

        for (i = 0; i < V; i++) {
            result[i] = new Edge();
        }
        // step 1 sort all edges
        Arrays.sort(edge);
        // Allocate memory for creating V ssubsets
        subset subsets[] = new subset[V];

        for (int v = 0; v < V; v++) {
            subsets[v] = new subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        i = 0;
        while (e < V - 1) {
            Edge nextEdge = edge[i++];
            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                Union(subsets, x, y);
            }
        }

        System.out.println("Following are the edges in mst");
        int minimumCost = 0;
        for (i = 0; i < e; i++) {
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree " + minimumCost);

    }

    public static void main(String[] args) {

        /*
         * Let us create following weighted graph 10 0--------1 | \ | 6| 5\ |15 | \ |
         * 2--------3 4
         */
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        prob106 graph = new prob106(V, E);

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
        graph.kruskalsMST();
    }
}
