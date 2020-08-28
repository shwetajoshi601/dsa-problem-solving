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
class LLReverseNodesInKGroups {
    // standard reverse algorithm
    ListNode reverse(ListNode head, ListNode end) {
        ListNode curr = head, prev = null, next = null;
        
         while(curr != end) {
            // reverse the number of nodes
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        
        // move to the kth node
        for(int i=0; i<k; i++) {
            if(node == null)
                return head;
            node = node.next;
        }
        // reverse the k nodes
        // save the head since the original head changes
        ListNode new_head = reverse(head, node);
        // when the k nodes are reversed, the head node becomes the last node
        // the next k nodes need to be appended after.
        head.next = reverseKGroup(node, k);
        
        return new_head;
    }
}