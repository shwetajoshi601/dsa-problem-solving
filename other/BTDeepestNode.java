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

public class BTDeepestNode {
    // while traversing we need to keep a track of what level is max so far and which node
    static int maxLevel = -1;
    static int deepestNode = -1;
    
    static void findDeepest(Node root) {
        deepest(root, 1);
    }
    
    static void deepest(Node root, int level) {
        // the idea is to do an inorder traversal and update the maxlevel and node
        if(root != null) {
            // increment for current level
            ++level;
            deepest(root.left, level);
            if(level > maxLevel) {
                // level deeper than current max level
                maxLevel = level;
                deepestNode = root.data;
            }
            deepest(root.right, level);
        }
    }
    
    static void printPreorder(Node root) {
        if(root == null)
            return;
        
        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
    
    public static void main(String args[]) {
        Node root = new Node(5);
        root.left = new Node(1);
        root.left.left = new Node(2);
        root.right = new Node(6);
        root.right.left = new Node(3);
        
        findDeepest(root);
        System.out.println(deepestNode);
        
    }
}
