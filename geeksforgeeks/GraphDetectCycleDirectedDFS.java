// { Driver Code Starts
    import java.util.*;
    import java.io.*;
    import java.lang.*;
    
    class DriverClass {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
    
            while (t-- > 0) {
                ArrayList<ArrayList<Integer>> list = new ArrayList<>();
                int V = sc.nextInt();
                int E = sc.nextInt();
                for (int i = 0; i < V + 1; i++)
                    list.add(i, new ArrayList<Integer>());
                for (int i = 0; i < E; i++) {
                    int u = sc.nextInt();
                    int v = sc.nextInt();
                    list.get(u).add(v);
                }
                if (new Solution().isCyclic(V, list) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }// } Driver Code Ends
    
    
    /*Complete the function below*/
    
    class Solution {
        // Function to detect cycle in a directed graph.
        public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
            boolean[] visited = new boolean[V];
            boolean[] dfsVisited = new boolean[V];
            
            for(int i=0; i<V; i++) {
                if(!visited[i]) {
                    if(checkForCycle(V, adj, visited, dfsVisited, i))
                        return true;
                }
            }
            
            return false;
        }
        
        // Using DFS
        boolean checkForCycle(int V, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] dfsVisited, int s) {
            visited[s] = true;
            dfsVisited[s] = true;
            
            // traverse the adjacent nodes
            for(Integer i: adj.get(s)) {
                // if its not visited, recursively call DFS
                if(!visited[i]) {
                    if(checkForCycle(V, adj, visited, dfsVisited, i))
                        return true;
                }
                // if its visited and also visited in the current DFS cycle
                // it is a cycle, return false
                else if(dfsVisited[i])
                    return true;
            }
            
            // mark as unvisited in the current DFS
            dfsVisited[s] = false;
            return false;
        }
    }