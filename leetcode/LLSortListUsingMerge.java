/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LLSortListUsingMerge {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode sortedList = mergeSort(head);
        
        return sortedList;
    }
    
    ListNode mergeSort(ListNode head) {
        // base condition
        if(head == null || head.next == null) return head;
        
        // find the middle node
        ListNode mid = findMiddleNode(head);
        
        // start of the next half
        ListNode nextHalf = mid.next;
        // terminate the first half
        mid.next = null;
        
        // recursively sort the first and second halves
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(nextHalf);
        
        // merge the two sorted lists
        ListNode sortedList = merge(left, right);
        return sortedList;
    }
    
    // function to find the middle node of a linked list
    ListNode findMiddleNode(ListNode head) {
        // slow fast pointers
        ListNode slow = head, fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    // function to merge two sorted lists
    ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        // to create a new sorted list
        ListNode dummy = new ListNode(-1);
        // note the head
        ListNode head = dummy;
        
        while(l1 != null && l2 != null) {
            // add the smaller element
            if(l1.val <= l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            
            dummy = dummy.next;
        }
        
        // add remaining elements
        if(l1 != null)
            dummy.next = l1;
        
        if(l2 != null)
            dummy.next = l2;
        
        // do not return the dummy node
        return head.next;
    }
}