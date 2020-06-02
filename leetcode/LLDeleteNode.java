/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LLDeleteNode {
	// delete a node of a linked list given access to only that node. No access to the head of the list.
    public void deleteNode(ListNode node) {
        
        if(node == null) return;
        
        ListNode p = node;
        
        p.val = p.next.val;
        p.next = p.next.next;
    }
}