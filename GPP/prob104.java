
// Bipartite graph
/**
 * 1) Its vertices can be divided into 2 disjoint and independent sets u and v such 
 * every edge  connects a vetex in u to v 
 * 2) The graph does not contain any odd lenth cycle 
 * 3) the graph is 2 colorable
 * 
 */
import java.util.*;

public class prob104 {
    private int V;
    private LinkedList<Integer> adj[];
 
    boolean isBiparted = true;
    prob104(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<Integer>();
           
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);

    }

    void color(int index, int currColor,boolean[] visited,int[] col) {
        // o = black
        // 1 = red
        // if current not is current and its color is not equal to current color
        //means it is not bipartet graph
        if(col[index] != -1 && col[index] != currColor){
            isBiparted = false;
            return;
        }
        col[index] = currColor;
        if(visited[index])
            return ;
        visited[index] = true;
        Iterator<Integer> it = adj[index].iterator();
        while(it.hasNext()){
            int n = it.next();
            //if curr color is o make it 1 and wise versa
            // simple trik is use xor 
            color(n, currColor ^ 1,visited,col);
        }
    }

    void bipart(boolean[] visited,int[] col) {
        for(int i= 0;i<V;i++){
            visited[i] = false;
            col[i] = -1;
        }
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                color(i, 0,visited,col);
            }
        }
        if(isBiparted)
            System.out.print("Biparted");
        else
            System.out.print("not Biparted");
   
    }

    public static void main(String[] args) {
        prob104 g = new prob104(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2,3);
        g.addEdge(3,0);
         boolean[] visited = new boolean[g.V];
         int[] col = new int[g.V];
        g.bipart(visited,col);
    }
}
