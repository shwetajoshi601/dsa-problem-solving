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

public class TreeOperations {
    static void insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return;
        }
        
        if(root.data >= val) { 
            if(root.left == null) {
                root.left = new Node(val);
                return;
            }
            else
                insert(root.left, val);
        } else {    
            if(root.right == null) {
               root.right = new Node(val);
               return;
            }
            else
                insert(root.right, val);
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
        
        insert(root, 4);
        printPreorder(root);
    }
}
