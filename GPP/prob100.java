// topological sort
// a topological ordering is an ordering of the nodes in a directed graph where for each directed edge fromnode a to node b 
//node a appeares before node b in ordering

//topological ordering is not unique
// not every graph has topological sort eg.for cycle graph
// only directed acyclic graph have a valid topological sort
import java.util.*;
public class prob100 {
    private int V;
    private ArrayList<ArrayList<Integer>> adj;

    prob100(int v){
        V = v;
        adj = new ArrayList<ArrayList<Integer>>();

        for(int i = 0;i<v;i++){
            adj.add(new ArrayList<Integer>());
        }
    }

    void addEdge(int u,int v){
        adj.get(u).add(v);
    }
    void topologicalSortUtil(int v,Stack<Integer> stack,boolean[] visited){
        visited[v] = true;
        

        Iterator<Integer> it = adj.get(v).iterator();
        while(it.hasNext()){
            int  n = it.next();
            if(!visited[n]){
                topologicalSortUtil(n, stack, visited);
            }
        }
        stack.push(v);
    }
    void topologicalSort(){
        Stack<Integer> stack = new Stack<Integer>();
        boolean visited[] = new boolean[V];

        for(int i = 0;i<V;i++){
            visited[i]= false;
        }

        for(int i = 0;i<V;i++){
            if(!visited[i]){
                topologicalSortUtil(i,stack,visited);
            }
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop()+" ");
        }
    }

    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        prob100 g = new prob100(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
 
        System.out.println("Following is a Topological "
                           + "sort of the given graph");
        // Function Call
        g.topologicalSort();
    }
}
