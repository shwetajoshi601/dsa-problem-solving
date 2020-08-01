/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LLDetectCycleReturnNode {
    public ListNode detectCycle(ListNode head) {
        
        ListNode slow = head, fast = head;
        boolean loopExists = false;
        
        // detect a cycle in the loop
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) {
                // cycle detected
                loopExists = true;
                break;
            }
        }
        
        // if a cycle exists
        if(loopExists) {
            System.out.println(loopExists);
            
            // start slow from the beginning
            slow = head;
        
            // move both slow an fast at the same speed
            while(slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
        
            // the point at which they meet again is the beginning of the loop
            return fast;
        }
        
        // no loop
        return null;
    }
}