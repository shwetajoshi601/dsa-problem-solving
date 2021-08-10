/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class BSTInorderSuccessor {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    TreeNode successor = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if(root == null)
            return null;

        if(root == p) {
            if(p.right != null) {
            // successor will be its parent or on the right side LVR
            // find the leftmost node in the right subtree
            TreeNode curr = p.right;
            while(curr.left != null)
                curr = curr.left;

            successor = curr;
            return successor;
            }
        }

        if(root.val > p.val) {
            // node is in the left subtree
            // root is a possible successor - if the node is a leaf node, then the inorder successor is one of its parent nodes
            successor = root;
            inorderSuccessor(root.left, p);
        } else {
            // traverse right
            inorderSuccessor(root.right, p);
        }

        return successor;
    }
}