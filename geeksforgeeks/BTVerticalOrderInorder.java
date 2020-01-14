//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }

/* Should print vertical order such that each vertical line
    is separated by $ */

class BTVerticalOrderInorder
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

class BinaryTree
{
    void verticalOrder(Node node) 
    {
        // Your code here
        TreeMap<Integer, String> h = new TreeMap<Integer, String>();
        getInorder(node, 0, h);
        
        for(Map.Entry<Integer, String> e : h.entrySet())
        {
            System.out.print(e.getValue() + " $");
        }
    }
    
    void getInorder(Node node, int level, TreeMap<Integer, String> h)
    {
        if(node == null)
        {
            return;
        }
        
        if(h.containsKey(level))
        {
            h.put(level, h.get(level) + " " + node.data);
        }
        else
        {
            h.put(level, node.data+"");
        }
        
        getInorder(node.left, level-1, h);
        getInorder(node.right, level+1, h);
    }
}