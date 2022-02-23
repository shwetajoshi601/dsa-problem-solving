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

    // recursive
    public boolean isSymmetricRecursive(TreeNode root) {
        if(root == null)
            return true;
        
        return isMirror(root.left, root.right);
    }
    
    // helper function that checks if two trees are identical (in this case mirrors)
    public boolean isMirror(TreeNode root1, TreeNode root2) {
        // if one of the roots is null -> false, if both are null -> true
        if(root1 == null || root2 == null)
            return root1 == root2;
        
        // if the values are unequal -> false
        if(root1.val != root2.val)
            return false;
        
        // since we are checking for symmetry, the left child of root1 should be equal to the right child of root2, and right child of root1 should be equal to the left child of root2
        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }
}