/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BTSymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        
        if(root.left == null && root.right == null)
            return true;
        
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.add(root.left);
        nodes.add(root.right);
        
        while(!nodes.isEmpty()) {
            TreeNode left = nodes.poll();
            TreeNode right = nodes.poll();
            
            // both left and right nodes are null
            if(left==null && right==null)
                continue;
            
            // one of the nodes is null
            if((left==null && right!=null) || (right==null && left!=null))
                return false;
            
            // both exist but have different values
            if(left.val != right.val)
                return false;
            
            // always compare left child of left node and right child of right node
            // add in the same order
            nodes.add(left.left);
            nodes.add(right.right);
            nodes.add(left.right);
            nodes.add(right.left);
        }
        return true;
    }
}