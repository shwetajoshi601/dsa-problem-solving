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
    // O(min(m, n)), Space - O(m+n)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if((p == null && q!= null) || (p!= null && q==null)) return false;
        
        // traverse both the trees in level order
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.add(p);
        q2.add(q);
        
        while(!q1.isEmpty() && !q2.isEmpty()) {
            int size1 = q1.size();
            int size2 = q2.size();
            
            // unequal number of nodes in a level
            if(size1 != size2) return false;
            
            for(int i=0; i<size1; i++) {
                TreeNode node1 = q1.poll();
                TreeNode node2 = q2.poll();
                
                // unequal data value
                if(node1.val != node2.val) return false;
                
                // validating left and right children
                if((node1.left == null && node2.left != null) || (node1.left != null && node2.left == null) || (node1.right == null && node2.right != null) || (node1.right != null && node2.right == null))
                    return false;
                
                // add into the queue
                if(node1.left != null)
                    q1.add(node1.left);
                if(node1.right != null)
                    q1.add(node1.right);
                if(node2.left != null)
                    q2.add(node2.left);
                if(node2.right != null)
                    q2.add(node2.right);
            }
        }
        
        return true;
    }


    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if((p == null && q != null) || (p != null && q == null))
            return false;
        
        if(p == null && q == null)
            return true;
        
        if(p.val != q.val)
            return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTreeSimple(TreeNode p, TreeNode q) {
        if(p == null && q == null)
             return true;
         
         if((p != null && q != null) && (p.val == q.val))
             return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
         
         return false;
     }
}