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
class LLReverseSinglyLinkedList {
    public ListNode reverseList(ListNode head) {
        // curr start at head
        ListNode prev=null, next=null, curr=head;
        
        while(curr != null) {
            // save the next node
            next = curr.next;
            // reverse
            curr.next = prev;
            // move ahead
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}