//dfs
// cycle detection in directed graph
import java.util.*;

public class prob102 {
    // No. of vertices
    private int V;

    // Adjacency List Representation
    private LinkedList<Integer> adj[];

    prob102(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);

    }

    boolean isCycleUtil(int i, boolean[] visited, boolean[] recStack) {
        // if already present in recstack mean cycle
        if (recStack[i]) {
            return true;
        }

        if (visited[i])
            return false;

        // mark true to visited an recStack
        visited[i] = true;
        recStack[i] = true;
        Iterator<Integer> it = adj[i].iterator();
        while (it.hasNext()) {
            int n = it.next();
            if (isCycleUtil(n, visited, recStack))
                return true;
        }
        // if no cycle in tree then mark false;
        recStack[i] = false;
        return false;

    }

    boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (isCycleUtil(i, visited, recStack))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        prob102 g = new prob102(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        if (g.isCyclic())
            System.out.println("Cyclic");
        else
            System.out.println("Non-Cyclic");
        
    }

}
