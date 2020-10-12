/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BTFindMaxDepth {
    // O(n) using recursion
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        // leaf node
        if(root.left == null && root.right == null) return 1;
        
        // find the depth of the left and right subtree
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        // find the max between the two
        return Math.max(leftDepth, rightDepth)+1;
    }
}