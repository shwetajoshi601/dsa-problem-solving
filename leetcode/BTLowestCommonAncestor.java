/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BTLowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;
        
        // if the root is equal to one of the nodes
        // that node is the ancestor
        if(root.val == p.val || root.val == q.val)
            return root;
        
        // recursively check the presence of the nodes in the left and right tree
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
        
        // if both are not null, it means one node is present in the left subtree
        // and one node is in the right subtree
        // hence, their common ancestor is the current node (root)
        if(leftLCA != null && rightLCA != null)
            return root;
        
        // if one of them is null, it means both the nodes are present in one subtree
        // return the one that is not null
        return leftLCA != null ? leftLCA : rightLCA;
    }
}