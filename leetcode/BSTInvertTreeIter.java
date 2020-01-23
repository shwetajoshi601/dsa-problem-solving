/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTInvertTreeIter {
    
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null) return root;
        
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.add(root);
        
        while(!nodes.isEmpty()) {
            // pop the first node
            TreeNode curr = nodes.poll();
            
            // swap the left and right children
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            
            // add the left child
            if(curr.left != null)
                nodes.add(curr.left);
            
            // add the right child
            if(curr.right != null)
                nodes.add(curr.right);
        }
        
        return root;
    }
}