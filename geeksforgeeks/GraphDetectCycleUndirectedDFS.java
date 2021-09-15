// { Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;

    class GraphDetectCycleUndirectedDFS {
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
                    adj.get(v).add(u);
                }
                Solution obj = new Solution();
                boolean ans = obj.isCycle(V, adj);
                if (ans)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }// } Driver Code Ends
    
    class Solution {
        // Function to detect cycle in an undirected graph.
        public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
            boolean[] visited = new boolean[V];
            for(int i=0; i<V; i++) {
                if(!visited[i]) {
                    if(checkForCycle(adj, visited, i, -1))
                        return true;
                }
            }
            return false;
        }
        
        // using DFS
        boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int s, int parent) {
            // perform a DFS traversal
            // we use the parent node to determing if its a cycle
           
           // mark the current node as visited
           visited[s] = true;
           // traverse its adjacent nodes
           for(Integer n: adj.get(s)) {
               if(!visited[n]) {
                   // recursively traverse the adjacent nodes
                   if(checkForCycle(adj, visited, n, s))
                   // if any child contains a cycle, return true
                        return true;
               } else if(n != parent)
               // if the node is already visited, check if it is a node other than parent
                    return true;
           }
           
           // no cycle found
           return false;
        }
    }