// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class Node  
    { 
        int data; 
        Node left, right; 
       
        public Node(int d)  
        { 
            data = d; 
            left = right = null; 
        } 
    }
    
    class GFG
    {
        static Node buildTree(String str)
        {
            // Corner Case
            if(str.length() == 0 || str.equals('N'))
                return null;
            String[] s = str.split(" ");
            
            Node root = new Node(Integer.parseInt(s[0]));
            Queue <Node> q = new LinkedList<Node>();
            q.add(root);
            
            // Starting from the second element
            int i = 1;
            while(!q.isEmpty() && i < s.length)
            {
                  // Get and remove the front of the queue
                  Node currNode = q.remove();
            
                  // Get the current node's value from the string
                  String currVal = s[i];
            
                  // If the left child is not null
                  if(!currVal.equals("N")) 
                  {
            
                      // Create the left child for the current node
                      currNode.left = new Node(Integer.parseInt(currVal));
            
                      // Push it to the queue
                      q.add(currNode.left);
                  }
            
                  // For the right child
                  i++;
                  if(i >= s.length)
                      break;
                  currVal = s[i];
            
                  // If the right child is not null
                  if(!currVal.equals("N")) 
                  {
            
                      // Create the right child for the current node
                      currNode.right = new Node(Integer.parseInt(currVal));
            
                      // Push it to the queue
                      q.add(currNode.right);
                  }
                  
                  i++;
            }
        
            return root;
        }
        
        public static void main(String args[]) throws IOException {
        
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while(t>0)
            {
                String s = br.readLine();
                Node root = buildTree(s);
                
                Solution T = new Solution();
                
                ArrayList <Integer> res = T.printBoundary(root);
                for (Integer num : res) System.out.print (num + " ");
                System.out.println();
                t--;
            }
        }
    }
    // } Driver Code Ends
    
    
    //User function Template for Java
    
    // class Node  
    // { 
    //     int data; 
    //     Node left, right; 
       
    //     public Node(int d)  
    //     { 
    //         data = d; 
    //         left = right = null; 
    //     } 
    // }
    
    class Solution
    {
        ArrayList <Integer> printBoundary(Node node)
        {
            ArrayList<Integer> result = new ArrayList<Integer>();
            printBoundaryHelper(node, result);
            
            return result;
        }
        
        void printBoundaryHelper(Node node, ArrayList<Integer> result) {
            if(node == null) return;
            
            result.add(node.data);
            
            // get the left boundary
            getLeftBoundary(node.left, result);
            
            // get the leaf boundary
            getLeafBoundary(node.left, result);
            getLeafBoundary(node.right, result);
            
            // right boundary in bottom up
            getRightBoundary(node.right, result);
        }
        
        void getLeftBoundary(Node node, ArrayList<Integer> result) {
            if(node == null) return;
            
            if(node.left != null) {
                // top down traversal
                // hence, add the data of the current node first
                result.add(node.data);
                getLeftBoundary(node.left, result);
            } else if(node.right != null) {
                // if the left is null, the right node forms the boundary
                result.add(node.data);
                getLeftBoundary(node.right, result);
            }
            
            // do nothing if the node is a leaf node
        }
        
        void getLeafBoundary(Node node, ArrayList<Integer> result) {
            if(node == null) return;
            
            // first get the left nodes of left subtree
            getLeafBoundary(node.left, result);
            // leaf node
            if(node.left == null && node.right == null)
                result.add(node.data);
                
            getLeafBoundary(node.right, result);
        }
        
        
        void getRightBoundary(Node node, ArrayList<Integer> result) {
            if(node == null) return;
            
            if(node.right != null) {
                // need bottom up order, hence traverse the right node first
                getRightBoundary(node.right, result);
                result.add(node.data);
            } else if(node.left != null) {
                // if right node is null, left forms the boundary
                getRightBoundary(node.left, result);
                result.add(node.data);
            }
            
            // do nothing for a leaf node
        }
    }
    