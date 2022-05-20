
// bfs
import java.util.*;

public class prob99 {
    private int V;
    private LinkedList<Integer> adj[];

    prob99(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
    }

    void BFS(int s) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        while (!q.isEmpty()) {
            s = q.poll();
            System.out.println(s);

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
    }

    void DFS(int s, boolean[] visited) {
        visited[s] = true;
        System.out.println(s);
        Iterator<Integer> i = adj[s].listIterator();

        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFS(n, visited);
            }
        }

    }

    public static void main(String[] args) {
        prob99 g = new prob99(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        // System.out.println("Following is Breadth First Traversal " + "(starting from
        // vertex 2)");
        // g.BFS(2);
        boolean visited[] = new boolean[g.V];
        System.out.println("Following is Depth First Traversal ");

        g.DFS(2, visited);

    }
}
