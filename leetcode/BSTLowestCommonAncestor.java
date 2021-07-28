/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class BSTLowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;
        
        if(p.val == root.val || q.val == root.val)
            return root;
        
        // if((p.val <= root.val && q.val > root.val) || (q.val <= root.val && p.val > root.val))
        //     return root;
        
        // use the properties of a BST
        // if both are less, LCA is present only in the left subtree
        if(p.val <= root.val && q.val <= root.val)
            return lowestCommonAncestor(root.left, p, q);
        // if both are greater than root LCA is present only in the right subtree
        else if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p,q);
        
        // if both the above conditions do not match, it means one is greater and one is smaller
        // hence root is their ancestor 
        return root;
    }
}