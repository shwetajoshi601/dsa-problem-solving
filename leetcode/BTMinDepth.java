/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BTMinDepth {
    
    public int minDepth(TreeNode root) {
        // null tree
       if(root == null)
           return 0;
        
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.add(root);
        int depth = 0;
        
        // traverse the queue
        while(!nodes.isEmpty()) {
            // next level
            depth++;
            
            // maintain size for level order traversal
            int size = nodes.size();
            
            // traverse all nodes at each level
            while(size-- > 0) {
                 TreeNode temp = nodes.poll();
                
                // first leaf node gives the minimum depth
                 if(temp.left == null && temp.right == null)
                     return depth;
                
                if(temp.left != null)
                  nodes.add(temp.left);
                
                if(temp.right != null)
                    nodes.add(temp.right);
            }
        }
        return depth;
    }
}