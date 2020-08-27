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
class LLReverseNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head, prev = null, next = null;
        
        // pairwise reverse
        // consider it as solving sub problems or linked list reverse
        // reversing two nodes
        int k=2, count = 0;
        
        while(count < k && curr != null) {
            // reverse the number of nodes specified (2 in this case)
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        
        // next group
        if(next != null)
            // the head is not changed and still points to the original head
            // after reversal, this is the tail node of the group
            // hence, pairwise reverse the remaining list and append it after the head
            head.next = swapPairs(next);
        
        return prev;
    }
}