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
class BTRootToLeafPaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        getPaths(root, "", result);
        
        return result;
    }
    
    void getPaths(TreeNode root, String path, List<String> result) {
        // traverse in DFS
        if(root == null) return;
        
        // root value comes first
        path+=root.val;
        // base condition -> leaf node, means one path is complete
        // add it to the result
        if(root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        
        // path incomplete, add an arrow
        path+="->";
        // recursively find the path for the left and right branches
        getPaths(root.left, path, result);
        getPaths(root.right, path, result);
    }
}