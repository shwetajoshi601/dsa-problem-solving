// USING LEVEL ORDER TRAVERSAL

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
class BTVerticalOrder
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
    static void verticalOrder(Node root)
    {
    // map to maintain data in nodes according to their horizontal
    // distance from the root
    // Distance -> [Node1 data, Node2 data...]
     TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
     LinkedList<Node> list = new LinkedList<Node>();
     root.hd = 0;
     list.add(root);
     
     while(!list.isEmpty()) {
        Node temp = list.poll();
        ArrayList<Integer> al = null;
        if(map.containsKey(temp.hd))
            al = map.get(temp.hd);
        else 
            al = new ArrayList<Integer>();
        al.add(temp.data);
        map.put(temp.hd, al);
        
        if(temp.left!=null) {
            temp.left.hd = temp.hd-1;
            list.add(temp.left);
        }
        if(temp.right!=null) {
            temp.right.hd = temp.hd+1;
            list.add(temp.right);
        }
     }
     
     for(Map.Entry<Integer, ArrayList<Integer>> e: map.entrySet()) {
         ArrayList<Integer> al = e.getValue();
         for(int i=0; i< al.size(); i++) {
             System.out.print(al.get(i) + " ");
         }
     }
    }
}
