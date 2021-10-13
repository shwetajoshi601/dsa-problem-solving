import java.util.*;

// class Node {
//     // a class to represent edges
//     int w, u, v;
//     Node(int weight, int node1, int node2) {
//         w = weight;
//         u=node1;
//         v=node2;
//     }
// }

public class GraphArticulationPoint {
    
    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] in, int[] low, int timer, int parent, int node, int[] isArticulation) {
        visited[node] = true;
        in[node] = low[node] = timer++;
        int child = 0;
        
        // travserse the adjacent nodes
        for(Integer it: adj.get(node)) {
            // if the adjacent node is a parent
            // we need not do anything
            if(it == parent)
                continue;
                
            // if the adjacent node is not visited
            if(!visited[it]) {
                // forward edge
                dfs(adj, visited, in, low, timer, node, it, isArticulation);
                
                // at this point the dfs for the current node is complete
                // update the node's low value with the min of itself and the adjacent 
                low[node] = Math.min(low[node], low[it]);
                
                // if low[it] > in[node], it means this node cant be reached by any other path
                // hence it is a bridge
                if(low[it] >= in[node] && parent != -1)
                    isArticulation[node] = 1;
                    
                child++;
            } else {
                // adjacent node is already visited
                // back edge
                low[node] = Math.min(low[node], in[it]);                
            }
        }
        
        if(parent != -1 && child > 1)
            isArticulation[node] = 1;
    }
    
    static void printArticulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int[] in = new int[V];
        int[] low = new int[V];
        int[] isArticulation = new int[V];
        
        int timer = 0;
        
        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                dfs(adj, visited, in, low, timer, -1, i, isArticulation);
            }
        }
        
        for(int j=0;j<V;j++) {
            if(isArticulation[j] == 1)
                System.out.print(j + " ");
        }
    }
    
    
    public static void main(String args[]) {
       // represent the graph in an adjacency list
       int V = 5;
       ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
       for(int i = 0; i<V; i++)
            adj.add(i, new ArrayList<Integer>());
            
       adj.get(0).add(1);
		adj.get(1).add(0);

		adj.get(0).add(2);
		adj.get(2).add(0);

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(1).add(3);
		adj.get(3).add(1);

		adj.get(3).add(4);
		adj.get(4).add(3);
       
       printArticulationPoints(V, adj);
    }
}
