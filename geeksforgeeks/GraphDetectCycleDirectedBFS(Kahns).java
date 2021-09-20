// { Driver Code Starts
    import java.util.*;
    import java.io.*;
    import java.lang.*;
    
    class GraphDetectCycleDirectedBFS(Kahns) {
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
            
            // Using Kahn's algorithm
            // Kahn's algorithm is used to find topo sort, topo sort is only possible in DAGs
            // Hence, if we are not able to generate a valid topo sort
            // we can conclude that the graph is cyclic
            
            int[] indegree = new int[V];
            // count indegree
            int i=0;
            for(i=0; i<V;i++) {
                for(Integer it: adj.get(i)) {
                    indegree[it]++;
                }
            }
            
            // Queue for BFS
            Queue<Integer> q = new LinkedList<Integer>();
            // add nodes with indegree 0
            for(i=0; i<indegree.length; i++) {
                if(indegree[i] == 0)
                    q.add(i);
            }
            
            int count = 0;
            // traverse
            while(!q.isEmpty()) {
                int node = q.poll();
                // we maintain a count of nodes in topo sort
                count++;
                
                for(Integer it: adj.get(node)) {
                    indegree[it]--;
                    if(indegree[it] == 0)
                        q.add(it);
                }
            }
            
            // if we get exactly V nodes in the topo sort
            // there is no cycle
            if(count == V)
                return false;
            
            return true;
        }
    }