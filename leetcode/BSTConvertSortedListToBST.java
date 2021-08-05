/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
class BSTConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        
        if(head.next == null)
            return new TreeNode(head.val);
        
        ListNode[] prevAndMid = findMidNode(head);
        ListNode prev = prevAndMid[0];
        ListNode mid = prevAndMid[1];
        prev.next = null;
        
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        
        return root;
    }
    
    ListNode[] findMidNode(ListNode head) {
        ListNode[] prevAndMid = new ListNode[2];
        ListNode prev = null, slow = head, fast = head;
        
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prevAndMid[0] = prev;
        prevAndMid[1] = slow;
        
        return prevAndMid;
    }
}