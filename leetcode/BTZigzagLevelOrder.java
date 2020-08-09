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
class BTZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        int level = 0;
        // level order traversal
        getLevelOrder(root, level, result);
        
        for(int i=0; i < result.size(); i++) {
            // for zig zag level order
            // odd levels have elements in reverse order
            if(i % 2 != 0)
                Collections.reverse(result.get(i));
        }
        
        return result;
    }
    
    void getLevelOrder(TreeNode root, int level, List<List<Integer>> result) {
        if(root == null)
            return;
        
        // if the list for that level, create the list
        if(result.size() <= level)
            result.add(new ArrayList<Integer>());
        
        // add the root value into the list for that level
        result.get(level).add(root.val);
        
        // recursively get level order for left and right subtree
        getLevelOrder(root.left, level+1, result);
        getLevelOrder(root.right, level+1, result);
    }
}