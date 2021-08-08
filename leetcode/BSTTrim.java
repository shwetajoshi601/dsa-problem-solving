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
    // using postorder
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null)
            return root;
         
         // traverse in preorder fashion and trim the left and right child first
         // we do this as the root can be changed
         // hence it is good to fix the child trees first
         root.left = trimBST(root.left, L, R);
         root.right = trimBST(root.right, L, R);
         
         // now fix the root
         // if the value < low, it means the right subtree contains the nodes in the range
         if(root.val < L)
             return root.right;
         
         // if the value > high, it means left subtree contains the values in range
         if(root.val > R)
             return root.left;
         
         // if the root is in range, don't remove it
         // its left and right nodes are already fixed, hence return the root
         return root;
     }

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