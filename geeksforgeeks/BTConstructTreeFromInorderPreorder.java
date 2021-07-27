// { Driver Code Starts
    import java.util.*;
    import java.io.*;
    class Node
    {
        int data; 
        Node left, right;
        Node(int key)
        {
            data = key;
            left = right = null;
        }
    }
    
    class BTConstructTreeFromInorderPreorder
    {
        public static void main (String[] args)
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            
            while(t-- > 0)
            {
                int n = sc.nextInt();
                Node root = null;
                int inorder[] = new int[n];
                int preorder[] = new int[n];
                for(int i = 0; i < n; i++)
                  inorder[i] = sc.nextInt();
                  
                for(int i = 0; i < n; i++)
                  preorder[i] = sc.nextInt();
                  
                Solution ob = new Solution();
                root = ob.buildTree(inorder, preorder, n);
                postOrdrer(root);
                System.out.println();
            }
        }
        
        public static void postOrdrer(Node root)
        {
            if(root == null)
              return;
              
            postOrdrer(root.left);
            postOrdrer(root.right);
            System.out.print(root.data + " ");
        }
    }// } Driver Code Ends
    
    
    class Solution
    {
        static int preIndex = 0;
        public static Node buildTree(int inorder[], int preorder[], int n)
        {
            preIndex = 0;
           // if the preorder and inorder do not form a tree
           if(inorder.length != preorder.length || inorder.length == 0 || preorder.length == 0)
                return null;
                
            return buildTreeHelper(inorder, preorder, 0, inorder.length-1);
        }
        
        static Node buildTreeHelper(int[] inorder, int[] preorder, int inStart, int inEnd) {
            if(preIndex > preorder.length || inStart > inEnd)
                return null;
                
            // the first node is pre order is the root
            Node root = new Node(preorder[preIndex]);
            preIndex++;
            
            // no child nodes
            if(inStart == inEnd)
                return root;
                
            // find this node in the inorder traversal to get the left and right parts
            int inIndex = search(inorder, inStart, inEnd, root.data);
            // if the node is not found in the inorder traveral,
            // it means the two arrays are invalid and do not form a tree
            if(inIndex == -1)
                return null;
                
            // now recursively build the left and right subtrees
            // left subtree is the left part of the root in inorder traveral (given by inIndex)
            root.left = buildTreeHelper(inorder, preorder, inStart, inIndex-1);
            root.right = buildTreeHelper(inorder, preorder, inIndex+1, inEnd);
            
            return root;
        }
        
        static int search(int[] arr, int start, int end, int key) {
            for(int i=start; i<=end; i++) {
                if(arr[i] == key)
                    return i;
            }
            
            return -1;
        }
    }
    