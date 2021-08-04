
import java.util.*;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BTFlatten {

    // function to get pre-order traversal
    void getPreorder(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return;

        list.add(root);
        getPreorder(root.left, list);
        getPreorder(root.right, list);
    }

    public void flattenNaiveSoln(TreeNode root) {
        List<TreeNode> list = new LinkedList<TreeNode>();

        TreeNode p = root;
        // get the preorder traversal of the tree
        getPreorder(root, list);

        // for each node in the list
        // add the next node as the right child
        for (TreeNode n : list) {
            n.left = null;
            if (n == p)
                continue;
            p.right = n;
            p = p.right;
        }
    }

    public void flatten(TreeNode root) {
        // stack to maintain the right child
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode p = root;

        while (p != null || !st.empty()) {

            // if right child exists, add it to the stack
            if (p.right != null)
                st.push(p.right);

            // if left child exists
            if (p.left != null) {
                // make it the right child
                p.right = p.left;
                // set left to null
                p.left = null;
                // no left child to add to the right
            } else if (!st.empty()) {
                // add the right nodes from the stack
                p.right = st.pop();
            }

            // move to the next node
            p = p.right;
        }
    }

    // in-place solution
    // make sure to comment the other methods before running
    public void flatten(TreeNode root) {
        flattenHelper(root);
     }
     
     TreeNode flattenHelper(TreeNode root) {
         if(root == null)
            return root;
         
         // use another pointer for traversal
         TreeNode curr = root;
         // save the left and right child for later use
         TreeNode left = curr.left;
         TreeNode right = curr.right;
         
         // since it has to be in preorder
         // the right point points to the left node first
         // hence we recursively flatten the left child and update the right pointer
         curr.right = flattenHelper(left);
         // set the left to null
         curr.left = null;
         
         // the earlier right child should come after all of the left nodes
         // hence move to the extreme right
         while(curr.right != null)
             curr = curr.right;
         
         // now recursively flatten the right subtree
         curr.right = flattenHelper(right);
         
         // the root remains unchanged
         return root;
     }
}