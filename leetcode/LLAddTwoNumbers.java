/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LLAddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode head = null, prev = null;
        
        // iterate over the two linked lists
        while (l1 != null || l2 != null) {
            int sum = 0;
            
            // if the first LL is shorter
            if (l1 == null && l2 != null)
                sum = l2.val + carry;
            
            // if the second LL is shorter
            else if (l1 != null && l2 == null)
                sum = l1.val + carry;
            
            // if both the elements exist
            else
                sum = l1.val + l2.val + carry;

            // calculate carry
            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            } else
                carry = 0;

            // add node to the linked list
            if (head == null) {
                head = new ListNode(sum);
                prev = head;
            } else {
                prev.next = new ListNode(sum);
                prev = prev.next;
            }

            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        
        prev.next = carry > 0 ? new ListNode(carry) : null;
        return head;
    }
}