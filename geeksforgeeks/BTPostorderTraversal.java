// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class BTPostOrderTraversal {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	Tree g = new Tree();
                ArrayList<Integer> res = g.postOrder(root);
                for (int i = 0; i < res.size (); i++)
                    System.out.print (res.get (i) + " ");
                System.out.print("\n");
                t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java



//User function Template for Java

/* A Binary Tree node
class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

class Tree
{
    ArrayList<Integer> postOrder(Node root)
    {
       // Your code goes here
       ArrayList<Integer> result = new ArrayList<Integer>();
       getPostorderRecursive(root, result);
       
       return result;
    }
    
    // rescursive solution
    void getPostorderRecursive(Node root, ArrayList<Integer> result) {
        if(root == null)
            return;
            
        getPostorder(root.left, result);
        getPostorder(root.right, result);
        result.add(root.data);
    }

    // iterative solution using two stacks
    void getPostorderIterative(Node root, ArrayList<Integer> result) {
        // stack to keep reverse of postorder - D, R, L
        Stack<Integer> res = new Stack<Integer>();
        // stack to keep nodes
        // if you observer the reverse of postorder, it is very similar to preorder
        // except that the right child comes before the left child
        Stack<Node> st = new Stack<Node>();
        
        // push the root
        st.push(root);
        
        // traverse the nodes similar to pre-order
        while(!st.isEmpty()) {
            // pop the node from the stack
            Node node = st.pop();
            // add its data onto the result stack
            res.push(node.data);
            
            // push the left child first to ensure the right child is processed first (LIFO nature of the stack)
            if(node.left != null)
                st.push(node.left);
                
            if(node.right != null)
                st.push(node.right);
        }
        
        // travserse the result stack by taking out elements
        // this will give the result in correct postorder
        while(!res.isEmpty()) {
            result.add(res.pop());
        }
    }

    // iterative soln using one stack -> this trick also works for preorder and inorder traversals
    void getPostorderIterativeUsingOneStack(Node root, ArrayList<Integer> result) {
        // simulating recursive behavior
        // keep the traversal state -> node and the number of times it is visited
        Stack<Pair> st = new Stack<Pair>();
        // 0 indicates the node has just begun exploring
        st.push(new Pair(root, 0));
        
        while(!st.isEmpty()) {
            Pair p = st.pop();
            Node curr = p.curr;
            int count = p.countVisited;
            
            // 3 indicates the node has been completely explored
            if(curr == null || count == 3) continue;
            
            // each time a node is visited, increment the count and push onto the stack
            st.push(new Pair(curr, count+1));
            
            // if the node is just begun exploring, then we need to traverse left (LRD)
            if(count == 0) st.push(new Pair(curr.left, 0));
            // count 1 indicates the left subtree is explored, so move right
            else if(count == 1) st.push(new Pair(curr.right, 0));
            // count 2 indicates the both left and right subtrees are explored, now process the root
            else if(count == 2) result.add(curr.data);
        }
    }
}
