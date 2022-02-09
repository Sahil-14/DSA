// disjoin set
// read disjoin set
public class prob105 {
    int V, E;
    Edge[] edge;

    prob105(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < E; i++) {
            edge[i] = new Edge();
        }
    }

    class Edge {
        int src, dest;
    }

    class subset {
        int parent;
        int rank;
    }

    // A utility function to find
    // set of an element i (uses
    // path compression technique)
    int find(subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    // A function that does union
    // of two sets of x and y
    // (uses union by rank)
    void Union(subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[xroot].parent = yroot;
            subsets[yroot].rank++;
        }
    }
    // The main function to check whether
    // a given graph contains cycle or not
    int isCycle(prob105 graph){
        int V = graph.V;
        int E = graph.E;
        // if vetices of edges belongs to the same set then there is cycle else not
        subset[] subsets = new subset[V];
        for(int v = 0;v <V;v++){
            subsets[v] = new subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        for (int e = 0; e < E; e++) {
            int x = find(subsets, graph.edge[e].src);
            int y = find(subsets, graph.edge[e].dest);
            if (x == y)
                return 1;
            Union(subsets, x, y);
        }
        return 0;
    }
    public static void main(String[] args)
    {
        /* Let us create the following graph
            0
            | \
            |  \
            1---2 */
 
        int V = 3, E = 3;
        prob105 graph = new prob105(V, E);
 
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
            System.out.println("Graph contains cycle");
        else
            System.out.println(
                "Graph doesn't contain cycle");
    }
}
