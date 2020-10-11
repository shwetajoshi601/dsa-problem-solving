// { Driver Code Starts
    import java.util.*;
    import java.util.Scanner;
    import java.util.HashMap;
    import java.lang.Math;
        class Node
        {
            int data;
            Node left,right;
            Node(int d) {data = d; left =right= null; }
        }
            
    public class BTFindMaxAndMin
    {
        public static void inorder(Node root)
        {
            if(root==null)
            return;
            inorder(root.left);
            System.out.print(root.data);
            inorder(root.right);
        }
         /* Drier program to test above functions */
        public static void main(String args[])
        {
             Scanner sc = new Scanner(System.in);
             int t=sc.nextInt();
             
             while(t-->0)
             {
                int n = sc.nextInt();
                BTFindMaxAndMin llist=new BTFindMaxAndMin();
                Node root=null,parent=null;
                HashMap<Integer, Node> m = new HashMap<>();
                for(int i=0;i<n;i++)
                {
                    int a=sc.nextInt();
                    int b=sc.nextInt();
                    char c=sc.next().charAt(0);
                    if(m.containsKey(a)==false)
                    {
                        parent=new Node(a);
                        m.put(a,parent);
                        if(root==null)
                        root=parent;
                    }
                    else
                        parent=m.get(a);
                    Node child=new Node(b);
                    if(c=='L')
                    parent.left=child;
                    else
                    parent.right=child;
                    m.put(b,child);
                }
                GFG obj = new GFG();
                int Max=obj.findMax(root);
                int Min=obj.findMin(root);
                System.out.println(Max+" "+Min);
            }
        }
    }// } Driver Code Ends
    
    
    /*class Node
    {
        int data;
        Node left,right;
        Node(int d)
        {
            data=d;
            left=right=null;
        }
    }*/
    
    //Complete the findMax and findMin functions.
    class GFG
    {
        public static int findMax(Node root)
        {
            if(root == null) return Integer.MIN_VALUE;
            
            // find the max in the left subtree and right subtree
            // Then find the max among the left, right max and the root.data
            int max = Integer.MIN_VALUE;
            
            // find max in left subtree
            int leftMax = findMax(root.left);
            // find max in right subtree
            int rightMax = findMax(root.right);
            
            // find max among leftMax, rightMax and current node data   
            if(leftMax >= rightMax)
                max = leftMax;
            else
                max = rightMax;
                
           if(root.data > max)
                max = root.data;
                
           return max;
        }
        
        public static int findMin(Node root)
        {
            // same approach as max
            if(root == null) return Integer.MAX_VALUE;
            
            int min = Integer.MAX_VALUE;
            int leftMin = findMin(root.left);
            int rightMin = findMin(root.right);
            
            if(leftMin <= rightMin)
                min = leftMin;
            else
                min = rightMin;
                
           if(root.data < min)
                min = root.data;
                
           return min;
        }
    }