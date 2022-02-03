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

public class LLRemoveListElemsWithGivenValue {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        
        ListNode newHead = head, curr = head, prev = null;
        
        while(curr != null) {
            // node value is = to val
            if(curr.val == val) {
                // if the node is the head node
                if(curr == newHead) {
                    // exclude the head from the list
                    // update the new head
                    curr = curr.next;
                    newHead = curr;
                } else {
                    //a middle node
                    // set the next of previous node to the curr's next
                    prev.next = curr.next;
                    curr = curr.next;
                }
            } else {
                // not a match
                // traverse ahead
                prev = curr;
                curr = curr.next;
            }
        }
        
        // return the new head
        return newHead;
    }
}
