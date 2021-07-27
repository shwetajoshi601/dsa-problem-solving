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

public class BTIsMirror {
    
    // recursive
    static boolean isMirror(Node root1, Node root2) {
        // two trees are mirrors if the data is equal and 
        // the left of one node is a mirror of the right of the other
        // the left of the other is a mirror of the right of the first
        if(root1 == null && root2 == null)
            return true;
        
        if(root1 != null && root2 != null)
            return root1.data == root2.data && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    
        return false;
    }
    
    static void printPreorder(Node root) {
        if(root == null)
            return;
        
        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
    
    public static void main(String args[]) {
        Node root1 = new Node(1);
        root1.left = new Node(3);
        root1.right = new Node(2);
        root1.right.left = new Node(5);
        root1.right.right = new Node(4);
        
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.right = new Node(3);

        System.out.println(isMirror(root1, root2));
    }
}
