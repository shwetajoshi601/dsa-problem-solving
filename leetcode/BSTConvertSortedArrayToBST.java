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
class BSTConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        // to get a height balanced tree
        // we can start from the mid of the array and then construct the tree from left and right
        // finding the mid would result in equal number of elements in both subtrees or at a difference of 1 - this gives a height balanced tree
        return helper(nums, 0, nums.length-1);
    }
    
    // helper function
    TreeNode helper(int[] nums, int low, int high) {
        // cannot divide further
        if(low > high)
            return null;
        
        // one element left
        if(low == high)
            return new TreeNode(nums[low]);
        
        // find the mid
        int mid = low + (high-low)/2;
        
        // mid element is the root
        TreeNode root = new TreeNode(nums[mid]);
        // recursively build the left subtree from elements before mid
        root.left = helper(nums, low, mid-1);
        // recursively build right subtree from elements after mid
        root.right = helper(nums, mid+1, high);
        
        // return the root
        return root;
    }
}