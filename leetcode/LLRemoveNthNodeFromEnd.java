public class LLRemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // nth node from the end means, (m-n)th node from the beginning. 
        ListNode slow=head, fast=head;
        
        int count=0;
        
        // Move the fast pointer to the nth node from the start
        while(count < n && fast != null) {
            count++;
            fast=fast.next;
        }
        
        // n = length of the list (n = m)
        if(fast == null)
            return head.next;
        
        // Move both the pointers till the fast pointer reaches the end (to only find the node, condition is if fast != null)
        while(fast.next != null) {
            slow=slow.next;
            fast=fast.next;
        }
        // slow reaches the node before the nth node from the last
        // delete the nth node by updating the next pointer
        slow.next = slow.next.next;
        
        return head;
    }
}