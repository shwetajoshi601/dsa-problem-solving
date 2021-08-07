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

class FloorCeil {
    int floor;
    int ceil;
    
    FloorCeil() {
        floor = -1;
        ceil = -1;
    }
}

public class BSTFindFloorAndCeil {
    
    static int floor = -1, ceil = -1;
    
    static void findFloorCeil(Node root, int key, FloorCeil result) {
       if(root == null)
            return;
        
        // if they key is in the BST, it is itself the floor and ceil    
        if(root.data == key) {
            result.floor = root.data;
            result.ceil = root.data;
        } else if(key < root.data) {
            // key less than root
            // this means the root is a possible ceil value
            // remember that this is a BST, hence as we traverse we will get the less and greater values
            result.ceil = root.data;
            // since key is less, traverse left
            findFloorCeil(root.left, key, result);
        } else {
            // key greater than root
            // this means root is a possible floor values
            result.floor = root.data;
            findFloorCeil(root.right, key, result);
        }
    }
    
    static void findFloorCeilIterative(Node root, int key, FloorCeil result) {
       if(root == null)
            return;
        
        while(root != null) {
            // if they key is in the BST, it is itself the floor and ceil    
            if(root.data == key) {
                result.floor = root.data;
                result.ceil = root.data;
                return;
            } else if(key < root.data) {
                // key less than root
                // this means the root is a possible ceil value
                // remember that this is a BST, hence as we traverse we will get the less and greater values
                result.ceil = root.data;
                // since key is less, traverse left
                root = root.left;
            } else {
                // key greater than root
                // this means root is a possible floor values
                result.floor = root.data;
                root = root.right;
            }
        }
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

        FloorCeil result1 = new FloorCeil();
        findFloorCeil(root, 10, result1);
        System.out.println("10: floor -> " + result1.floor + ", ceil -> " + result1.ceil);
        
        FloorCeil result2 = new FloorCeil();
        findFloorCeil(root, 9, result2);
        System.out.println("10: floor -> " + result2.floor + ", ceil -> " + result2.ceil);
        
        FloorCeil result3 = new FloorCeil();
        findFloorCeil(root, 0, result3);
        System.out.println("10: floor -> " + result3.floor + ", ceil -> " + result3.ceil);
    }
}
