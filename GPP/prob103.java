import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
// connected components
public class prob103 {
    private int V;
    private LinkedList<Integer> adj[];
    private Vector<Integer> components;
    prob103(int v){
        V = v;
        components = new Vector<Integer>();
        adj = new LinkedList[V];
        for(int i = 0;i<V;i++){
            adj[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int u,int v){
        adj[u].add(v);
        adj[v].add(u);
    }

    int getComponentes(int index,boolean[] visited){
        if(visited[index])
            return 0;
        visited[index] = true;
        int ans = 1;
        Iterator<Integer> it = adj[index].iterator();
        while(it.hasNext()){
            int n = it.next();
            if(!visited[n]){
                ans += getComponentes(n, visited);
                visited[n] = true;
            }
        }
        return ans;
    }
    void componentsUtil(boolean[] visited){

        for(int i = 0;i<V;i++){
            visited[i] = false;
        }
        for(int i = 0;i<V;i++){
            if(!visited[i]){
                components.add(getComponentes(i, visited));
            }
        }
        System.out.println("total components : "+components.size());

        for(int i = 0;i<components.size();i++){
            System.out.println(components.get(i));
        }
    }

    //There 
    long noWays(){
        long ans =0;
        for(int i: components){
            ans+= i*(V-i);
        }
        return ans;
    }
    public static void main(String[] args) {
        prob103 g = new prob103(5);
        g.addEdge(0, 1);
        g.addEdge(2, 3);
        g.addEdge(0, 4);
        boolean[] visited =new boolean[g.V];
        g.componentsUtil(visited);

    }
}
