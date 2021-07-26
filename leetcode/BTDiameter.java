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
class BTDiameter {
    int maxDiameter = Integer.MIN_VALUE;
    
    public int diameterOfBinaryTree(TreeNode root) {
         if(root == null)
            return 0;
            
        int height = height(root);
        return maxDiameter == Integer.MIN_VALUE ? maxDiameter : maxDiameter-1;
    }
    
    int height(TreeNode root) {
        if(root == null)
            return 0;
            
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        int pathLength = leftHeight + rightHeight + 1;
        maxDiameter = Math.max(maxDiameter, pathLength);
        
        return Math.max(leftHeight, rightHeight)+1;
    }
}