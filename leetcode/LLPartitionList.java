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
class LLPartitionList {
    public ListNode partition(ListNode head, int x) {
        // create dummy nodes to mark the start of two new linked lists
        // first -> elements < x
        // second -> elements >= x
        ListNode dummyFirst = new ListNode(-1);
        ListNode first = dummyFirst;
        ListNode dummySecond = new ListNode(-1);
        ListNode second = dummySecond;
        
        ListNode curr = head;
        
        // traverse the linked list
        while(curr != null) {
            // if value is less than x, add to the first list
            if(curr.val < x) {
                // note that we dont create a new node, we simply point to the node
                first.next = curr;
                first = first.next;
            } else {
                // if value is greater than x, add to the second list 
                second.next = curr;
                second = second.next;
            }
            
            // move forward
            curr = curr.next;
        }
        
        // join the smaller list followed by larger list
        // dummySecond is the dummy start, .next is the actual head
        first.next = dummySecond.next;
        // last node should point to null
        second.next = null;
        
        // return the head of the joined list
        return dummyFirst.next;
    }
}