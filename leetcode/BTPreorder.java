/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BTPreorder {
    
    void getPreorder(TreeNode root, List<Integer> result) {
        if(root == null)
            return;
        
        result.add(root.val);
        getPreorder(root.left, result);
        getPreorder(root.right, result);
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        getPreorder(root, result);
        return result;
    }
}