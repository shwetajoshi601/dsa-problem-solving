/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LLDeleteNodeEnd2 {
    int count(ListNode head) {
        ListNode p = head;
        int count = 0;
        while(p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int length = count(head);
        int pos = length - n;
        
        if(pos == 0) {
            head = head.next;
            return head;
        }

        while(--pos > 0)
            p=p.next;
        
        p.next = p.next.next;
        return head;
    }
}