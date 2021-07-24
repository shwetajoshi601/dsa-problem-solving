// { Driver Code Starts
// Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BTDiameter {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Tree g = new Tree();
            System.out.println(g.diameter(root));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Tree {
    /* Complete the function to get diameter of a binary tree */
    int diameter(Node root) {
        // base case
        if(root == null) return 0;
        
        // if you observe a tree, the longest path between two leaves passing through the root
        // is nothing but the sum of their heights + 1 for the root node
        // now, the diameter could also be the length of the path not passing through the root
        // for this reason, we need to find diameters of its subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        int lDiam = diameter(root.left);
        int rDiam = diameter(root.right);
        
        // finally, diameter is the max of height of left + height of right + 1 (this is the longest path passing through the root) and the max of left and right diameter
        return Math.max(leftHeight+rightHeight+1, Math.max(lDiam, rDiam));
    }
    
    int height(Node root) {
        if(root == null) return 0;
        
        return (Math.max(height(root.left), height(root.right))+1);
    }
}
