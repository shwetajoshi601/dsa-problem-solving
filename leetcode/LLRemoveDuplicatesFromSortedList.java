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
class LLRemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        
        ListNode temp = new ListNode(Integer.MIN_VALUE);
        ListNode prev = temp, curr = head;
        
        while(curr != null) {
            while(curr != null && curr.val == prev.val)
                curr = curr.next;
            
            prev.next = curr;
            
            if(curr != null) {
                prev = curr;
                curr = curr.next;
            }
        }
        
        return temp.next;
    }
}