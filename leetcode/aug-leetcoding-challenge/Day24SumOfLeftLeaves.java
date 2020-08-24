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
class Solution {
    public int sumOfLeftLeavesRecursive(TreeNode root) {
        // if root is null
        if(root == null)
            return 0;
        // check if the curr node has a left node which is a leaf node
        else if(root.left != null && root.left.left == null && root.left.right == null)
            // sum its value and traverse the right subtree
            return root.left.val + sumOfLeftLeaves(root.right);
        else
            // traverse the left and right sub trees
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public int sumOfLeftLeavesLevelOrder(TreeNode root) {
        // if tree is empty or contains only one node
        if(root == null || (root.left==null && root.right == null))
            return 0;
        
        int sum = 0;
        // perform level order traversal
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        // traverse the nodes in level order
        while(!q.isEmpty()) {
            // dequeue the node
            TreeNode curr = q.poll();
            // check if its left node is a leaf node
            if(curr.left != null && curr.left.left==null && curr.left.right == null)
                sum+=curr.left.val;
            
            // add the left and right child nodes if they exist
            if(curr.left != null)
                q.add(curr.left);
            
            if(curr.right != null)
                q.add(curr.right);
        }
        
        return sum;
    }
}