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
class LLAddTwoNumbersII {
    
    // function to reverse a linked list
    ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // reverse the two numbers so that the least significant digit is first
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        // now the problem is reduced to the previous add two nos problem
        // new list for result
        ListNode res = new ListNode(-1);
        ListNode head = res;
        
        int carry = 0;
        
        while(l1 != null || l2 != null) {
            int sum = 0;
            
            if(l1 == null) {
                sum = l2.val + carry;
                l2 = l2.next;
            }
            else if(l2 == null) {
                sum = l1.val + carry;
                l1 = l1.next;
            }
            else {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            
            // find carry
            if(sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            } else
                carry = 0;
            
            res.next = new ListNode(sum);
            res = res.next;
        }
        
        // at the end, if the carry exists
        if(carry > 0) res.next = new ListNode(carry);
        
        // the resulting number is also in reverse order, hence reverse it back
        return reverse(head.next);
    }
}