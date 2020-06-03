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
public class BSTRangeSum {
   
   public int rangeSumBST(TreeNode root, int L, int R) {
       if(root == null) return 0;
       int sum = 0;
       
       // if root value is in the range
       if(root.val >=L && root.val <= R )
           // add sum of left subtree and right subtree
           sum = root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
       
       // if current val is out of lower bound, traverse the right subtree (BST property)
       if(root.val < L)
           sum+=rangeSumBST(root.right, L, R);
       
       // if current val is out of upper bound, traverse left subtree 
       if(root.val > R)
           sum+=rangeSumBST(root.left, L, R);
       
       return sum;
   }
}