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
public class BTConstructStringFromTree {
   public String tree2str(TreeNode t) {
       // if the current node is null
       if(t==null) return "";
       
       // if the node is a leaf node - R
       if(t.left==null && t.right==null) return String.valueOf(t.val);
       
       // get left subtree string - L
       String leftStr = tree2str(t.left);
       
       // get right subtree string - R
       String rightStr = tree2str(t.right);
       
       // if there is no right child, the string contains only the left string
       if(rightStr == "")
           return String.valueOf(t.val) + "(" + leftStr + ")";
       else
       // if the right child exists, the string contains both left and right strings
           return String.valueOf(t.val) + "(" + leftStr + ")(" + rightStr + ")"; 
   }
}