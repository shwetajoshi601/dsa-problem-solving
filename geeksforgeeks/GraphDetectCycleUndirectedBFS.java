// { Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;

    class GraphDetectCycleUndirectedBFS {
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
    
    class Node {
        int node;
        int parent;
        
        Node(int n, int p) {
            node = n;
            parent = p;
        }
    }
    
    class Solution {
        // Function to detect cycle in an undirected graph.
        public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
            boolean[] visited = new boolean[V];
            for(int i=0; i<V; i++) {
                if(!visited[i]) {
                    if(checkForCycle(adj, visited, i))
                        return true;
                }
            }
            return false;
        }
        
        boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int s) {
            // perform a BFS traversal
            // store the node along with its parent node
            // this helps when an already visited node is encountered
            // if the node is a parent/previous node of the current node, its not a cycle
            // however if an adjacent node is visited already but is not the previous node
            // it denotes a cycle
            Queue<Node> q = new LinkedList<Node>();
            q.add(new Node(s, -1));
            // mark the node as visited
            visited[s] = true;
            
            // traverse all adjacent nodes
            while(!q.isEmpty()) {
                // poll the node
                Node curr = q.poll();
                int node = curr.node;
                int parent = curr.parent;
                
                for(Integer i: adj.get(node)) {
                    if(!visited[i]) {
                        visited[i] = true;
                        // this node is adj of the polled node
                        // it means the one removed from the q is its parent
                        q.add(new Node(i, node));
                    } else if(i != parent)
                    // if the node is visited and is not the parent
                    // its a cycle
                        return true;
                }
            }
            
            return false;
        }
    }