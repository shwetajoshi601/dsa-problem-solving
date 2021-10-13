// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GraphStronglyConnectedComponentsKosaraju
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    void dfs(ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, boolean[] visited, int node)
    {
        visited[node] = true;
        
        for(Integer it: adj.get(node)) {
            if(!visited[it])
                dfs(adj, st, visited, it);
        }
        st.push(node);
    }
    
    void revDfs(ArrayList<ArrayList<Integer>> transpose, boolean[] visited, int node) {
        visited[node] = true;
        
        for(Integer it: transpose.get(node)) {
            if(!visited[it])
                revDfs(transpose, visited, it);
        }
    }
    
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int connectedCount = 0;
        
        //Step-1: sort the nodes - topologiccal sort
        Stack<Integer> st = new Stack<Integer>();
        boolean[] visited = new boolean[V];
        int i=0;
        for(i=0; i<V;i++) {
            if(!visited[i])
                dfs(adj, st, visited, i);
        }
        
        //Step-2: Transpose the graph - reverse the edges
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>();
        for(i=0;i<V;i++)
            transpose.add(new ArrayList<Integer>());
        
        // add the edges in reverse in the transpose
        for(i=0;i<V;i++) {
            // mark the visited array as unvisited - it is marked in dfs so we change it back
            visited[i]= false;
            for(Integer it: adj.get(i)) {
                transpose.get(it).add(i);
            }
        }
        
        // Step-3: Perform a DFS on the transpose in the order of topo sort
        while(!st.isEmpty()) {
            int node = st.pop();
            if(!visited[node]) {
                revDfs(transpose, visited, node);
                // one cycle of dfs denotes a connected component
                // dfs explores all adjacent nodes
                connectedCount++;
            }
        }
        
        return connectedCount;
    }
}
