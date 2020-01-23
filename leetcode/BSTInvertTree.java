/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTInvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        
            // swap the left and right child
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        // repeat for subtree
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
}