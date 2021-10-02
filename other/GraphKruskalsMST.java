import java.util.*;

class Node {
    // a class to represent edges
    int w, u, v;
    Node(int weight, int node1, int node2) {
        w = weight;
        u=node1;
        v=node2;
    }
}

public class GraphKruskalsMST {
    
    static int findParent(int[] parent, int node) {
        if(parent[node] == node)
            return node;
        
        // compression
        // 2->4->5, then the parent of 5 is 2, so we re-assign in each recursive call
        return parent[node] = findParent(parent, parent[node]);
    }
    
    static void union(int[] parent, int[] rank, int u, int v) {
        int parent_u = findParent(parent, u);
        int parent_v = findParent(parent, v);
        
        // union by rank
        // attach the smaller component to the larger component
        if(rank[parent_u] < rank[parent_v]) {
            parent[parent_u] = parent_v;
        } else if(rank[parent_v] < rank[parent_u]) {
            parent[parent_v] = parent_u;
        } else {
            // both have same ranks, attach any one to the other
            // the rank of the one attached to is increased
            parent[parent_u] = parent_v;
            rank[parent_v]++;
        }
    }
    
    // recursive
    static int kruskalsAlgo(int V, ArrayList<Node> adj) {
        // sort the edges in ascending order of weights
        Collections.sort(adj, (a, b)-> {
            return a.w - b.w;
        });
        
        // use a disjoint set for finding the MST
        int[] parent = new int[V];
        int[] rank = new int[V];
        for(int i=0; i<V;i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        int mstCost = 0;
        // to store the mst
        ArrayList<Node> mst = new ArrayList<Node>();
        // traverse through the edges
        for(Node it: adj) {
           // find the parent of the two nodes in the edge
           // if they belong to different components then we consider them
           // this is because, an MST cannot have cycles, if they have the same parent,
           // they are in the same component and have cycle
           if(findParent(parent, it.u) != findParent(parent, it.v)) {
               // add the edge to the mst
               mst.add(it);
               mstCost+=it.w;
               // perform a union on the two nodes
               union(parent, rank, it.u, it.v);
           }
        }
        
        for(Node edge: mst)
            System.out.println(edge.w + " : " + edge.u + "->" + edge.v);

        return mstCost;
    }
    
    
    public static void main(String args[]) {
       // represent the graph in an adjacency list
       ArrayList<Node> adj = new ArrayList<Node>();
       adj.add(new Node(1, 0, 3));
       adj.add(new Node(2, 0, 1));
       adj.add(new Node(3, 1, 2));
       adj.add(new Node(3, 1, 3));
       adj.add(new Node(4, 0, 4));
       adj.add(new Node(5, 2, 3));
       adj.add(new Node(7, 1, 5));
       adj.add(new Node(8, 2, 5));
       adj.add(new Node(9, 3, 4));
       
       int mstCost = kruskalsAlgo(6, adj);
       System.out.println(mstCost);
    }
}
