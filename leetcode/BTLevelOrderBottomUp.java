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
class BTLevelOrderBottomUp {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        // edge case, empty tree
        if(root == null) return result;
        
        // perform level order traversal
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
    
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> currLevel = new ArrayList<Integer>();
            
            for(int i=0; i<size; i++) {
                TreeNode currNode = q.poll();
                currLevel.add(currNode.val);
                
                if(currNode.left != null)
                    q.add(currNode.left);
                
                if(currNode.right != null)
                    q.add(currNode.right);
            }
            
            // the result at the beginning, so that the results list is created in reverse order giving us bottom up traversal
            result.add(0, currLevel);
        }
        
        return result;
    }
}