/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LLDeleteNodeEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        
        for(int i=0; i<n; i++)
            slow = slow.next;
        
        if(slow == null) return head.next;
        
        while(slow != null && slow.next!= null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        fast.next = fast.next.next;
        return head;
    }
}