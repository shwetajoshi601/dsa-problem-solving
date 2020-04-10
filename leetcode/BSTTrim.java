/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTTrim {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        // base case
        if(root == null)
            return root;
        
        // if the current valus is less than L, it means we need consider its left subtree bcz all the elements in left subtree will be less than the value. We only need values >= L. hence we only traverse the right subtree in this case
        if(root.val < L)
            return trimBST(root.right, L, R);
        
        // Similarly, traverse the left subtree if the current value is greater than R - need values <= val.
        if(root.val > R)
            return trimBST(root.left, L, R);
        
        // save the updated subtree
        root.left=trimBST(root.left, L, R);
        root.right=trimBST(root.right, L, R);
        
        return root;
    }
}