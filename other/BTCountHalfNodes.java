import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    
    Node(int val) {
        left = right = null;
        data = val;
    }
}

public class BTCountFullNodes {
    
    // recursive
    static int countFullNodes(Node root) {
        // edge case
        if(root == null)
            return 0;
        
        // base condition
        if(root.left == null && root.right == null)
            return 0;
            
        // if both are not null, then number of full nodes is full nodes in left subtree
        // plus full nodes in right subtree plus 1 for the node itself
        if(root.left != null && root.right != null)
            return countFullNodes(root.left) + countFullNodes(root.right) + 1;
            
        // if the node only has one subtree then we need not add 1 as its not a full node
        if(root.left == null)
            return countFullNodes(root.right);
            
        if(root.right == null)
            return countFullNodes(root.left);
        
        // just to avoid compilation error due to return type   
        return 0;
    }
    
     // iterative
    static int countFullNodesIterative(Node root) {
        // edge case
        if(root == null)
            return 0;
        
        int count = 0;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            
            if(curr.left != null && curr.right != null)
                count++;
                
            if(curr.left != null)
                q.add(curr.left);
                
            if(curr.right != null)
                q.add(curr.right);
        }
        
        return count;
    }
    
    static void printPreorder(Node root) {
        if(root == null)
            return;
        
        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
    
    public static void main(String args[]) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.left.left = new Node(5);
        root.left.left.right = new Node(9);
        root.right = new Node(2);
        root.right.left = new Node(7);
        root.right.right = new Node(4);
        
        System.out.println(countFullNodes(root));
        System.out.println(countFullNodesIterative(root));
    }
}
