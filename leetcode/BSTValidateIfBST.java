/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTValidateIfBST {
    
    boolean validateBST(TreeNode root, long min, long max) {
        // base case
        if(root == null)
            return true;
        
        // root is between the range Min to Max
        if((root.val > min && root.val < max) &&
         // the left subtree values will be within the range min to root
          validateBST(root.left, min, root.val) &&
         // right subtree values will be within the range root to max
          validateBST(root.right, root.val, max))
            return true;
        else
            return false;
    }
    
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}