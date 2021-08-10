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

public class BTRemoveLeaves {
    
    static Node removeLeaves(Node root) {
       if(root == null)
            return root;
       
       if(root.left == null && root.right == null)
            return null; 
       root.left = removeLeaves(root.left);
       root.right = removeLeaves(root.right);
            
        return root;
    }
    
    static void printInorder(Node root) {
        if(root == null)
            return;
        
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
    
    public static void main(String args[]) {
        Node root1 = new Node(15);
        root1.left = new Node(10);
        root1.right = new Node(20);
        root1.left.left = new Node(5);
        // root1.left.right = new Node(12);
        root1.right.right = new Node(25);

        Node result = removeLeaves(root1);
       printInorder(result);
    }
}
