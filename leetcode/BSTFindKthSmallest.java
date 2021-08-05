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
class BSTFindKthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        getInorder(root, inorder);
        
        return inorder.get(k-1);
    }
    
    void getInorder(TreeNode root, ArrayList<Integer> result) {
        if(root == null)
            return;
        
        getInorder(root.left, result);
        result.add(root.val);
        getInorder(root.right, result);
    }
    
//     int helper(TreeNode root, int k, int count) {
//         if(root == null || count > k)
//             return -1;
        
//         int leftSmall = helper(root.left, k, count);
//              if(leftSmall != -1)
//                 return leftSmall;
        
//             if(++count == k)
//                 return root.val;
        
//             return helper(root.right, k, count);
//     }
}