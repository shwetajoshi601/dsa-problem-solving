import java.util.*;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class BTInorder {
    
    void getInorder(TreeNode root, List<Integer> list) {
        if(root!=null) {
            getInorder(root.left, list);
            list.add(root.val);
            getInorder(root.right, list);
        }
        
        return;
    }
    
    void getInorderIterative(TreeNode root, List<Integer> list) {
        TreeNode curr = root;
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        while(curr != null || !st.empty()) {
            // traverse to the leftmost node
            // add each node to the stack
            while(curr != null) {
                st.push(curr);
                curr=curr.left;
            }
            
            // curr=null at this point - reach the leftmost node
            curr = st.pop();
            list.add(curr.val);
        
            // traverse the right node
            curr=curr.right;
        }
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inList = new LinkedList<Integer>();
        
        getInorder(root, inList);
        getInorderIterative(root, inList);
        return inList;
    }
}