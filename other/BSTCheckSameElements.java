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

public class BSTCheckSameElements {
    
    static boolean sameElements(Node root1, Node root2) {
       if(root1 == null || root2 == null)
            return false;
        
        ArrayList<Integer> inorder1 = new ArrayList<Integer>();
        ArrayList<Integer> inorder2 = new ArrayList<Integer>();
        
        getInorder(root1, inorder1);
        getInorder(root2, inorder2);
        
        if(inorder1.size() != inorder2.size())
            return false;
            
        for(int i=0; i<inorder1.size(); i++) {
            if(inorder1.get(i) != inorder2.get(i))
                return false;
        }
        
        return true;
    }
    
    static void getInorder(Node root, ArrayList<Integer> inorder) {
       if(root == null)
            return;
        
       getInorder(root.left, inorder);
       inorder.add(root.data);
       getInorder(root.right, inorder);
    }

    
    
    public static void main(String args[]) {
        Node root1 = new Node(15);
        root1.left = new Node(10);
        root1.right = new Node(20);
        root1.left.left = new Node(5);
        root1.left.right = new Node(12);
        root1.right.right = new Node(25);
        
        Node root2 = new Node(15);
        root2.left = new Node(12);
        root2.right = new Node(20);
        root2.left.left = new Node(5);
        root2.left.left.right = new Node(10);
        root2.right.right = new Node(25);

       System.out.println(sameElements(root1, root2));
    }
}
