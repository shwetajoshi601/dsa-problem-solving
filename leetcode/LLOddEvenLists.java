/**
 * Definition for singly-linked list.
 */

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class LLOddEvenLists {
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return head;
        
        int c=0;
        
        ListNode p=head,q=head,j=head;
        // start of the odd list
        ListNode r=head.next;
        
        while(p.next != null) {
            // counter
            c++;
            // move ahead
            q=p.next;
            // 1->3, 2->4, even odd nodes are alternate nodes
            p.next=p.next.next;
            // to maintain the reference of previous node
            j=p;
            p=q;
        }
        
        // if the list is odd numbered c ends at last node of odd list
        if(p.next==null && c%2==0)
            // connect last node of odd list to start of even list
            p.next=r;
        else
            // list is even numbered, c ends ends at last node of even list
            // previous node will be last node of odd list, connect to the start of even list
            j.next=r;
        
        // return the altered list
        return head;
    }
}