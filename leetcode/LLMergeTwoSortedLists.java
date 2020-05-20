/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LLMergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;

        // use a dummy node to form a new sorted list
        ListNode dummy=new ListNode(-1);
        // assign the head of the list
        ListNode head = dummy;
        
        // iterate over both the lists
        while(l1 != null && l2 != null) {
            // if the value of l1's node is less
            if(l1.val <= l2.val) {
                // add it to the dummy list
                dummy.next = l1;
                l1=l1.next;
            } else {
                dummy.next = l2;
                l2=l2.next;
            }
            dummy = dummy.next;
        }
        
        // elements in l1 remaining
        if(l1 != null)
            dummy.next = l1;
        // remaining l2 elements
        if(l2 != null)
            dummy.next = l2;
        
        // actual nodes start from second node
        // initial node is -1
        return head.next;
    }
}