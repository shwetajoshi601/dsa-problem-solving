import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    // function get elements in sorted order
    void getPreorder(TreeNode root, List<Integer> sortedList) {
        if(root == null)
            return;
        
        // traverse the left subtree
        getPreorder(root.left, sortedList);
        // add the root element to the list
        sortedList.add(root.val);
        //traverse the right subtree
        getPreorder(root.right, sortedList);
    }
    
    // function to merge two sorted lists into one sorted list
    List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        
        // append elements from second list to first
        list1.addAll(list2);
        
        // sort the resulting list
        // Note: Colletions.sort() uses TimSort - hybrid of merge sort and insertion sort
        Collections.sort(list1);
        
        return list1;
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        // two lists for sorted elements from the trees
        List<Integer> sortedTree1 = new ArrayList<Integer>();
        List<Integer> sortedTree2 = new ArrayList<Integer>();
        
        // for BSTs, preorder traversal returns elements in sorted order
        // get elements in sorted order for the two trees
        getPreorder(root1, sortedTree1);
        getPreorder(root2, sortedTree2);
        
        // merge the sorted elements from both trees
        return mergeSortedLists(sortedTree1, sortedTree2);
    }
}