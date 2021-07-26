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
class BTPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return checkPathSum(root, 0, targetSum);
    }
    
    boolean checkPathSum(TreeNode root, int currSum, int targetSum) {
        if(root == null) return false;
        // calculate current sum
        currSum+=root.val;
        if(root.left == null && root.right == null) {
            // path complete
            // check if the sum is equal to the target
            if(currSum == targetSum)
                return true;
            return false;
        }
        
        // recursively check for left and right
        boolean isSumInLeft = checkPathSum(root.left, currSum, targetSum);
        // if present in left, no need to check in right
        if(isSumInLeft)
            return isSumInLeft;
        // check in right
        boolean isSumInRight = checkPathSum(root.right, currSum, targetSum);
        
        return isSumInLeft || isSumInRight;
    }

    // a better way of writing the same above logic
    public boolean hasPathSumBetter(TreeNode root, int targetSum) {
        if(root == null) return false;
        // in each iteration, reduce the current value from the target
         targetSum-=root.val;
         // path complete
         if(root.left == null && root.right == null) {
             // if the path = targetSum, then targetSum will be 0 at this stage
             return targetSum == 0;
         }
         
         // recursively find sums of left and right branches
         return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
     }
}