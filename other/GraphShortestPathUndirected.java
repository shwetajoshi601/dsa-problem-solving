import java.util.*;

public class GraphShortestDistanceUndirected {
    
    static void findShortestPath(int V, ArrayList<ArrayList<Integer>> adj, int src) {
        // create a distance array
        // here we assume that each edge has unit weights
        int[] dist = new int[V];
        // fill the dist array with max int
        // we initally consider max distance for each node from the src
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // Queue for BFS
        Queue<Integer> q = new LinkedList<Integer>();
        // add the src
        q.add(src);
        dist[src] = 0; // dist of src to itself is 0
        
        // traverse the nodes in BFS
        while(!q.isEmpty()) {
            int node = q.poll();
            // now for each adjacent node
            // find the distance
            for(Integer it: adj.get(node)) {
                // distance upto the "node" is given by dist[node]
                // each adjacent node is one step far from the node
                // hence, the distance we get for this adjacent node is dist[node]+1
                // if this distance is less than the one already present in dist[it]
                // we update it with the shorted one
                if(dist[node]+1 < dist[it]) {
                    dist[it] = dist[node]+1;
                    // add into the queue
                    q.add(it);
                }
            }
        }
        
        // once all the nodes are traversed print the shortest paths
        for(int i=0; i<V; i++)
            System.out.print(dist[i] + " ");
    }
    
    // auxiliary methods to create an adjacency list
    static void addEdge(ArrayList<ArrayList<Integer> > adj,
                        int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
  
    static void printAdjacencyList(ArrayList<ArrayList<Integer> > adj)
    {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("Adjacency list of " + i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
  
    public static void main(String[] args)
    {
        // Creating a graph with 5 vertices
        int V = 9;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());
  
        // Adding edges one by one.
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 3, 4);
        addEdge(adj, 2, 6);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 7);
        addEdge(adj, 6, 8);
        addEdge(adj, 7, 8);
        // printAdjacencyList(adj);
        
        findShortestPath(V, adj, 0);
    }
}
