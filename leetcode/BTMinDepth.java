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

    // recursive, O(n)/O(n)
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        // base condition
        if(root.left == null && root.right == null)
            return 1;
        
        // when we find the min we also need to be careful about skew trees
        // if we just take min of left right and add 1, it gives incorrect depth
        // hence we need to check if left of right subtree is null
        // and recurse only on the subtree that is present
        if(root.left == null)
            return minDepth(root.right) + 1;
        
        if(root.right == null)
            return minDepth(root.left) + 1;
        
        // both subtrees present
        // take the min depth of both and add 1 for the current node
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
}