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

public class BTIsIdentical {
    
    // recursive
    static boolean isIdentical(Node root1, Node root2) {
        if(root1 == null && root2 == null)
            return true;
        
        if(root1 != null && root2 != null)
            return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    
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
        Node root1 = new Node(6);
        root1.left = new Node(3);
        root1.left.left = new Node(5);
        root1.left.left.right = new Node(9);
        root1.right = new Node(2);
        root1.right.left = new Node(7);
        root1.right.right = new Node(4);
        
        Node root2 = new Node(6);
        root2.left = new Node(3);
        // uncomment these lines to check for identical
        // root2.left.left = new Node(5);
        // root2.left.left.right = new Node(9);
        root2.right = new Node(2);
        root2.right.left = new Node(7);
        root2.right.right = new Node(4);
        
        System.out.println(isIdentical(root1, root2));
    }
}
