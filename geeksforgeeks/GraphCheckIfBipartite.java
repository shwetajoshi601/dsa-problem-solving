// { Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;

    class GraphCheckIfBipartite
    {
        public static void main(String[] args) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());
            while(T-->0)
            {
                String[] S = br.readLine().trim().split(" ");
                int V = Integer.parseInt(S[0]);
                int E = Integer.parseInt(S[1]);
                ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
                for(int i = 0; i < V; i++){
                    adj.add(new ArrayList<Integer>());
                }
                for(int i = 0; i < E; i++){
                    String[] s = br.readLine().trim().split(" ");
                    int u = Integer.parseInt(s[0]);
                    int v = Integer.parseInt(s[1]);
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }
                Solution obj = new Solution();
                boolean ans = obj.isBipartite(V, adj);
                if(ans)
                    System.out.println("1");
                else System.out.println("0");
           }
        }
    }// } Driver Code Ends
    
    
    class Solution
    {
        public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
        {
            int[] color = new int[V];
            Arrays.fill(color, -1);
            
            for(int i=0; i<V; i++) {
                if(color[i] == -1) {
                    // at any point if we find that the graph is not bipartite
                    // return false
                    if(!checkIsBipartite(adj, color, i))
                        return false;
                }
            }
            
            return true;
        }
        
        boolean checkIsBipartite(ArrayList<ArrayList<Integer>> adj, int[] color, int s) {
            // perform a bfs traversal
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(s);
            color[s] = 0;
            
            while(!q.isEmpty()) {
                int curr = q.poll();
                
                for(Integer n: adj.get(curr)) {
                    // if the node is not colored
                    if(color[n] == -1) {
                        // color it with the opposite color of its parent
                        color[n] = 1 - color[curr];
                        q.add(n);
                    // if the node is already colored
                    // check if its not the same as its previous
                    // if it has the same color, its not bipartite
                    } else if(color[curr] == color[n])
                        return false;
                }
            }
            
            return true;
        }
    }