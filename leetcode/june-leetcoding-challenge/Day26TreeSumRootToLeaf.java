import java.util.*;

public class Day26TreeSumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        
        // queue to maintain left right nodes
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        // queue to maintain path sum
        Queue<Integer> sums = new LinkedList<Integer>();
        int tot=0;
        
        nodes.add(root);
        sums.add(root.val);
        
        while(!nodes.isEmpty()) {
            TreeNode temp = nodes.poll();
            int sum = sums.poll();
            
            // base case - leaf node
            if(temp.left == null && temp.right == null)
                tot+=sum;
            
            // process the left child
            if(temp.left != null) {
                nodes.add(temp.left);
                // between each node and its children there will be a diff
                // of a factor of 10
                // in the first iteration -> sum is 4, then 49, then 495.
                sums.add((sum*10) + temp.left.val);
            }
            
            // process the right child
            if(temp.right != null) {
                nodes.add(temp.right);
                sums.add((sum*10) + temp.right.val);
            }
        }
        
        return tot;
    }
}