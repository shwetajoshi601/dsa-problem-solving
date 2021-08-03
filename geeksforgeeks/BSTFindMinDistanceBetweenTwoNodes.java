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

public class BSTFindDistanceBetweenTwoNodes {
    
    static int findDist(Node root, int a, int b) {
       if(root == null)
            return -1;
        
        // find the lca of the two nodes    
        Node lca = lca(root, a, b);
        
        // find the distance of both from the lca
        int distA = findDistFromLca(lca, a, 0);
        int distB = findDistFromLca(lca, b, 0);
        
        // return total distance        
        return distA + distB;
    }
    
    static Node lca(Node root, int a, int b) {
        if(root == null)
            return root;
            
        if(root.data == a || root.data == b)
            return root;
        
        // since it is a BST, we can check the values
        // move left if both are smaller than the root
        if(a <= root.data && b <= root.data)
            return lca(root.left, a, b);
        // move right
        else if(a > root.data && b > root.data)
            return lca(root.right, a, b);
        
        // both dont match, means one is small and one is greater
        // hence root is their lca
        return root;
    }
    
    // function to find the distance of a node from the lca
    static int findDistFromLca(Node lca, int a, int level) {
        if(lca == null)
            return -1;
        
        // node found, level gives the current distance        
        if(lca.data == a)
            return level;
        
        // bst -> traverse left if the node value is lesser than lca
        if(a <= lca.data)
            return findDistFromLca(lca.left, a, level + 1);
        
        // for a greater value traverse right
        return findDistFromLca(lca.right, a, level + 1);
    }
    
    public static void main(String args[]) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(12);
        root.right.left = new Node(9);
        root.right.right = new Node(21);
        root.right.right.right = new Node(25);
        root.right.right.left = new Node(19);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        System.out.println(findDist(root, 3, 9));
        System.out.println(findDist(root, 9, 25));
    }
}
