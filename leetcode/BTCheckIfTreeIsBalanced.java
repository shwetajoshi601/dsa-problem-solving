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
class BTCheckIfTreeIsBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        if(root.left == null && root.right == null)
            return true;
        
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        
        return Math.abs(lHeight - rHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    int height(TreeNode root) {
        if(root == null)
            return 0;
        
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    // the following is a better solution
    // since we already iterate while calculating the height, store the result in a variable
    boolean flag = true;
    public boolean isBalancedBetter(TreeNode root) {
        if(root == null)
            return flag;
        
        heightBetter(root);
        return flag;
    }
    
    int heightBetter(TreeNode root) {
        if(root == null)
            return 0;
        
        int lHeight = heightBetter(root.left);
        int rHeight = heightBetter(root.right);
        
        if(Math.abs(lHeight - rHeight) > 1)
            flag = false;
        
        return Math.max(lHeight, rHeight) + 1;
    }
}