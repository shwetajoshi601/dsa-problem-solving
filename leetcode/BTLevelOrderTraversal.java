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
class BTLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        
        // queue to maintain results
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        // add the root
        q.add(root);
        
        while(!q.isEmpty()) {
            // consider size to create new lists for each level
            int size = q.size();
            List<Integer> currLevel = new ArrayList<Integer>();
            
            // process the nodes on each level
            for(int i=0; i<size; i++) {
                // poll the current node
                TreeNode currNode = q.poll();
                // add its value to result
                currLevel.add(currNode.val);
                
                // add left child to the queue if it exists
                if(currNode.left != null)
                    q.add(currNode.left);
                
                // add the right child to the queue if it exists
                if(currNode.right != null)
                    q.add(currNode.right);
            }
            
            // once all nodes in the current level are done
            // add the list to the final result list
            result.add(currLevel);
        }
        
        return result;
    }
}