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
class LLPalindromeLinkedList {
    
    // function to reverse a list
    ListNode reverse(ListNode head) {
        ListNode prev=null, curr=head, next=head;
        
        while(curr != null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
       ListNode slow=head, fast=head;
        // using Floyd's alogrithm, move slow till half
        while(fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        // slow will be at the start of the next half
        // reverse the next half
        ListNode head2=reverse(slow);
        
        // now compare the two halves node by node
        while(head!=null && head2 != null) {
            if(head.val != head2.val)
                // unequal value
                return false;
            head=head.next;
            head2=head2.next;
        }
        
        return true;
    }
}