//bellman ford algo for shortest path
// work for negative weight
//not work for negative weight  cycle 
// it can detect negative weight cycle after relaxation fon V-1 time if the vertices changes means their is negative weight cycle
//time complexit = O(E*V) and for complete graph it is O(n^3) // drawback
public class prob109 {
    class Edge {
        int src, dest, weight;

        Edge() {
            src = dest = weight = 0;
        }
    }

    int V, E;
    Edge edge[];

    prob109(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; i++)
            edge[i] = new Edge();
    }

    void printArr(int dist[], int V) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    void BellmonFord(prob109 graph, int src) {
        int V = graph.V, E = graph.E;
        int dist[] = new int[V];

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        dist[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < E; j++) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;

                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + weight)
                    dist[v] = dist[u] + weight;
            }
        }

        // check for negative weighted cycle in graph
        for (int j = 0; j < E; j++) {
            int u = graph.edge[j].src;
            int v = graph.edge[j].dest;

            int weight = graph.edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + weight) {
                System.out.println("Negative weighted Cycle present");
                return;
            }

        }
        printArr(dist, V);

    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices in graph
        int E = 8; // Number of edges in graph

        prob109 graph = new prob109(V, E);

        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        // add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;

        graph.BellmonFord(graph, 0);
    }
}

/**
 * 1) Negative weights are found in various applications of graphs. For example,
 * instead of paying cost for a path, we may get some advantage if we follow the
 * path. 2) Bellman-Ford works better (better than Dijkstra’s) for distributed
 * systems. Unlike Dijkstra’s where we need to find the minimum value of all
 * vertices, in Bellman-Ford, edges are considered one by one. 3) Bellman-Ford
 * does not work with undirected graph with negative edges as it will declared
 * as negative cycle.
 */
