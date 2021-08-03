// { Driver Code Starts
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

class BTFindDistanceBetweenTwoNodes {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            String[] ab = br.readLine().trim().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            GfG g = new GfG();
            System.out.println(g.findDist(root, a, b));
        }
    }
}
// } Driver Code Ends


// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
    int findDist(Node root, int a, int b) {
        if(root == null)
            return -1;
            
        // find the lca of the two nodes
        Node lca = lca(root, a, b);
        
        // now find the distance of the two nodes from the lca
        int distLcaToA = findDistFromLca(lca, a, 0);
        int distLcaToB = findDistFromLca(lca, b, 0);
        
        // add the distances to get the total distance between the two nodes
        return distLcaToA + distLcaToB;
    }
    
    // function to find the lca of two nodes
    Node lca(Node root, int a, int b) {
        if(root == null)
            return root;
            
        if(root.data == a || root.data == b)
            return root;
            
        Node leftLCA = lca(root.left, a, b);
        Node rightLCA = lca(root.right, a, b);
        
        // one node in left subtree, one in right
        if(leftLCA != null && rightLCA != null)
            return root;
        
        // both nodes in the same subtree
        return leftLCA != null ? leftLCA : rightLCA;
    }
    
    // function to get the distance of a node from the given node
    int findDistFromLca(Node lca, int data, int level) {
        // the approach is similar to level order
        if(lca == null)
            return -1;
        
        // node found
        if(lca.data == data)
            return level;
        
        // traverse the left child and increment the level    
        int leftDist = findDistFromLca(lca.left, data, level + 1);
        
        // if node is found in the left subtree, return the distance
        // else, find the distance in the right subtree
        return leftDist != -1 ? leftDist : findDistFromLca(lca.right, data, level + 1);
    }
}