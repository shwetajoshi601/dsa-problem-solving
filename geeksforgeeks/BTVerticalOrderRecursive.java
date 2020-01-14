//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class Node
{
    int data, hd;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
        hd = Integer.MAX_VALUE;
    }
}
class BTVerticalOrderRecursive
{
    public static void main (String[] args)throws IOException {
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node>();
            int n = Integer.parseInt(read.readLine());
            Node root = null;
            String str[] = read.readLine().replace("  ", " ").trim().split(" ");
            int k = 0;
            while(n-- > 0)
            {
                int n1 = Integer.parseInt(str[k++]);
                int n2 = Integer.parseInt(str[k++]);
	        	char lr= str[k++].charAt(0);
				
                
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
            }
            
            BinaryTree obj = new BinaryTree();
            obj.verticalOrder(root);
            System.out.println();
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/*class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
        hd = Integer.MAX_VALUE;
    }
}*/
class BinaryTree
{
    static void getVerticalOrder(Node root, int hd, TreeMap<Integer, Vector<Integer>> map) {
        // terminating condition
        if(root == null)
            return;
        // get the vector of data elements for the 
        // horizontal distance
        Vector<Integer> vec = map.get(hd);
        
        // if empty create a new vector
        if(vec == null) {
            vec = new Vector<Integer>();
        }
        // add the data of the node to the vector
        vec.add(root.data);
        // update the map with the new value
        map.put(hd, vec);
        // store the data in left subtree
        getVerticalOrder(root.left, hd-1, map);
        // store the data in the right subtree
        getVerticalOrder(root.right, hd+1, map);
    }

    static void verticalOrder(Node root)
    {
    // map to maintain data in nodes according to their horizontal
    // distance from the root
    // Distance -> [Node1 data, Node2 data...]
     TreeMap<Integer, Vector<Integer>> map = new TreeMap<Integer, Vector<Integer>>();
     // horizontal distance is wrt to the root.
     // for the root, hd=0, for left subtree decrement by 1
     // for right subtree, increment by 1
     getVerticalOrder(root, 0, map);
     
     for(Map.Entry<Integer, Vector<Integer>> e: map.entrySet()) {
         Iterator<Integer> itr = e.getValue().iterator();
         while(itr.hasNext())
            System.out.print(itr.next() + " ");
     }
    }
}
