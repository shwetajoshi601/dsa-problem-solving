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
class BTPathSumII {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> paths = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return result;
        
        helper(paths,root,targetSum);
        return result;
    }
    
    public void helper(List<Integer> paths,TreeNode root,int targetSum){
        if(root==null) return;
        
        paths.add(root.val);
        targetSum -= root.val;
        
        if(root.left==null && root.right==null && targetSum == 0){
            // lists are pass by reference in java, so create a new list
            result.add(new ArrayList<>(paths));
        }
        
        helper(paths,root.left,targetSum);
        helper(paths,root.right,targetSum);
        // after exploring the left and right paths, we need to backtrack to the root
        paths.remove(paths.size()-1);
    }
}