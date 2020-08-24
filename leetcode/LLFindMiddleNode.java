/**
 * Definition for singly-linked list.
 */
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

public class LLFindMiddleNode {
    
    // function to find the length of the linked list
    int length(ListNode head) {
        ListNode p = head;
        int c=0;
        
        while(p!=null) {
            c++;
            p=p.next;
        }
        
        return c;
    }
    
    public ListNode middleNode(ListNode head) {
        // find the length
        int len = length(head);
        if(len==1) return head;
        
        // check if the length is even or odd
        int mid = len%2 == 0 ? len/2 : (len-1)/2;
        
        System.out.println(mid);
        
        // traverse the linked list upto the middle node
        ListNode p = head;
        int c=0;
        while(c!=mid) {
            c++;
            p=p.next;
        }

        // return middle node
        return p;
    }

    // Optimal solution
    public ListNode middleNode(ListNode head) {
        // use the hare and tortoise technique
        ListNode slow=head, fast=head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // slow will have travelled half the distance as fast
        return slow;
    }
}