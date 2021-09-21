import java.util.*; 

class Pair
{
    private int v;
    private int weight;
    Pair(int _v, int _w) { v = _v; weight = _w; }
    int getV() { return v; }
    int getWeight() { return weight; }
}

class GraphShortestPathDAG
{
    public void topoSort(int V, ArrayList<ArrayList<Pair>> adj, boolean[] visited, int s, Stack<Integer> st) {
        // mark the node as visited
        visited[s] = true;
        for(Pair it: adj.get(s)) {
            if(!visited[it.getV()])
                topoSort(V, adj, visited, it.getV(), st);
        }
        
        st.push(s);
    }
    
    public void shortestPath(int V, ArrayList<ArrayList<Pair>> adj, int src) {
        // DFS
        boolean[] visited = new boolean[V];
        // stack for topo sort
        Stack<Integer> st = new Stack<Integer>();
        
        // distance array for shortest paths
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int i=0; i<V;i++) {
            if(!visited[i]) {
                topoSort(V, adj, visited, i, st);
            }
        }
        
        dist[src] = 0;
        // now the stack contains the topoSort for the graph
        // for each node in the stack, we find the distance
        while(!st.isEmpty()) {
            int node = st.pop();
            // now if this node has been reached previously
            if(dist[node] != Integer.MAX_VALUE) {
                // find the distances for its adjacent nodes.
                for(Pair it: adj.get(node)) {
                    // if the node dist + dist of wt to reach adjacent node is less
                    // update the distance
                    if(dist[node] + it.getWeight() < dist[it.getV()]) {
                        dist[it.getV()] = dist[node] + it.getWeight();
                    }
                }
            }
        }
        
        // the distance array now contains shortest paths
        for(int i=0; i<V; i++) {
            if(dist[i] == Integer.MAX_VALUE)
                System.out.print("INF ");
            else
                System.out.print(dist[i] + " ");
        }
    }
    
    public static void main(String args[])
    {
        int n = 6;
        ArrayList<ArrayList<Pair> > adj = new ArrayList<ArrayList<Pair> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Pair>());
			
		adj.get(0).add(new Pair(1, 2));
		adj.get(0).add(new Pair(4, 1));
		adj.get(1).add(new Pair(2, 3));
		adj.get(2).add(new Pair(3, 6));
		adj.get(4).add(new Pair(2, 2));
		adj.get(4).add(new Pair(5, 4));
		adj.get(5).add(new Pair(3, 1));
		GraphShortestPathDAG obj = new GraphShortestPathDAG(); 
		obj.shortestPath(n, adj, 0); 
		
    }
}