// { Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GraphBFSNew {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // BFS traversal
        ArrayList<Integer> bfsList = new ArrayList<Integer>();
        // visited array
        boolean[] visited = new boolean[V];
        
        // we need to ensure all the nodes from all components are traversed
        // hence we run a loop for all nodes
        // the problem mentions not to consider disconnected components
        // the this loop is commented
        // for(int i=0; i<V; i++) {
        //     // if the node is not visited, perform bfs
        //     if(!visited[i]) {
                // create a queue
                Queue<Integer> q = new LinkedList<Integer>();
                // add the node to the queue
                q.add(0);
                // mark as visited
                visited[0] = true;
                
                // now traverse all the nodes connected to this node
                while(!q.isEmpty()) {
                    Integer node = q.poll();
                    // add to the result
                    bfsList.add(node);
                    
                    // get the adjacent nodes from adjacency list
                    for(Integer n: adj.get(node)) {
                        // mark as visited
                        // add into the queue
                        if(!visited[n]) {
                            visited[n] = true;
                            q.add(n);
                        }
                    }
                }
        //     }    
        // }
        
        return bfsList;
    }
}