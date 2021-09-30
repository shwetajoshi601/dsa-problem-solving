// { Driver Code Starts
    import java.util.*;
    import java.io.*;
    import java.lang.*;
    
    class GraphPrimsAlgoMST
    {
        public static void main(String args[]) throws IOException {
    
            BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(read.readLine());
            while (t-- > 0) {
                String str[] = read.readLine().trim().split(" ");
                int V = Integer.parseInt(str[0]);
                int E = Integer.parseInt(str[1]);
        
                ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
                for(int i=0;i<V;i++)
                {
                    adj.add(new ArrayList<ArrayList<Integer>>());
                }
                
                int i=0;
                while (i++<E) {
                    String S[] = read.readLine().trim().split(" ");
                    int u = Integer.parseInt(S[0]);
                    int v = Integer.parseInt(S[1]);
                    int w = Integer.parseInt(S[2]);
                    ArrayList<Integer> t1 = new ArrayList<Integer>();
                    ArrayList<Integer> t2 = new ArrayList<Integer>();
                    t1.add(v);
                    t1.add(w);
                    t2.add(u);
                    t2.add(w);
                    adj.get(u).add(t1);
                    adj.get(v).add(t2);
                }
                
                Solution ob = new Solution();
                
                System.out.println(ob.spanningTree(V, adj));
            }
        }
    }// } Driver Code Ends
    
    
    // User function Template for Java
    
    class Solution
    {
        //Function to find sum of weights of edges of the Minimum Spanning Tree.
        static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
        {
            // maintain 3 arrays
            // has the min weight to reach this node from the corresponding parent in parent array
            int[] key = new int[V];
            // parent that joins with min weight
            int[] parent = new int[V];
            // indicates if the node at i is a part of the mst
            boolean[] mst = new boolean[V];
            
            int sum = 0;
            
            Arrays.fill(key, Integer.MAX_VALUE);
            Arrays.fill(parent, -1);
            Arrays.fill(mst, false);
            
            key[0] = 0;
            
            // in an MST N node are connected using N-1 edges
            // hence, traverse only upto N-1
            for(int i=0; i<V-1; i++) {
                // find the edge with the min weight from the key array
                int min = Integer.MAX_VALUE, p = 0;
                // traverse through the key array
                for(int j=0; j<V; j++) {
                    // the edge is not yet a part of mst and its weight is less than current min
                    if(!mst[j] && key[j] < min) {
                        // update the min
                        min = key[j];
                        p = j;
                    }
                }
                
                // now we have found the node that connects to the min edge
                mst[p] = true;
                
                // traverse through the adjacent edges of this node
                for(ArrayList<Integer> it: adj.get(p)) {
                    // if the adjacent node is not a part of the mst
                    // and its weight is less than the weight in key
                    // update the key with this weight and update the parent to p
                    if(!mst[it.get(0)] && it.get(1) < key[it.get(0)]) {
                        key[it.get(0)] = it.get(1);
                        parent[it.get(0)] = p;
                    }
                }
            }
            
            // in the end we have the nodes in parent
            // and the min weights of mst edges in key
            for(int k=0; k<V; k++) {
               sum+=key[k];
            }
            
            return sum;
        }

        // Not getting accepted on gfg, look into it later
        static int spanningTreeUsingHeap(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
        {
            // maintain 3 arrays
            // has the min weight to reach this node from the corresponding parent in parent array
            int[] key = new int[V];
            // parent that joins with min weight
            int[] parent = new int[V];
            // indicates if the node at i is a part of the mst
            boolean[] mst = new boolean[V];
            
            int sum = 0;
            
            Arrays.fill(key, Integer.MAX_VALUE);
            Arrays.fill(parent, -1);
            Arrays.fill(mst, false);
            
            key[0] = 0;
            
            // priority queue to store nodes with min weight - min heap
            Queue<int[]> pq = new PriorityQueue<int[]>(V, (a, b) -> {
               return a[1] - b[1]; 
            });
            
            pq.add(new int[]{0, key[0]});
            
            // in an MST N node are connected using N-1 edges
            // hence, traverse only upto N-1
            for(int i=0; i<V-1; i++) {
                // find the edge with the min weight from the key array
                // int min = Integer.MAX_VALUE, p = 0;
                // // traverse through the key array
                // for(int j=0; j<V; j++) {
                //     // the edge is not yet a part of mst and its weight is less than current min
                //     if(!mst[j] && key[j] < min) {
                //         // update the min
                //         min = key[j];
                //         p = j;
                //     }
                // }
                int[] minNode = pq.poll();
                int p = minNode[0];
                int min = minNode[1];
                // now we have found the node that connects to the min edge
                mst[p] = true;
                
                // traverse through the adjacent edges of this node
                for(ArrayList<Integer> it: adj.get(p)) {
                    // if the adjacent node is not a part of the mst
                    // and its weight is less than the weight in key
                    // update the key with this weight and update the parent to p
                    if(!mst[it.get(0)] && it.get(1) < key[it.get(0)]) {
                        key[it.get(0)] = it.get(1);
                        parent[it.get(0)] = p;
                        // add into the priority queue
                        pq.add(new int[]{it.get(0), it.get(1)});
                    }
                }
            }
            
            // in the end we have the nodes in parent
            // and the min weights of mst edges in key
            for(int k=0; k<V; k++) {
               sum+=key[k];
            }
            
            return sum;
        }
    }
    