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
class PriorityQueueMergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        
        if(lists.length == 1)
            return lists[0];
        
        // add the nodes into a priority queue
        // sort based on values
        Queue<ListNode> pq = new PriorityQueue<ListNode>(1, (a, b)-> {
            if(a.val < b.val)
                return -1;
            else if(a.val > b.val)
                return 1;
            return 0;
        });
        
        // iterate through the lists and add the nodes to a priority queue
        for(int i = 0; i<lists.length; i++) {
            ListNode head = lists[i];
            while(head != null) {
                pq.add(head);
                head = head.next;
            }
        }
        
        // now collect all the nodes from the priority queue and join them into a single list
        ListNode dummy = new ListNode(-1);
        ListNode newHead = dummy;
        while(!pq.isEmpty()) {
            dummy.next = pq.poll();
            dummy = dummy.next;
        }
        
        dummy.next = null;
        
        return newHead.next;
    }

    public ListNode mergeKListsBetter(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        
        if(lists.length == 1)
            return lists[0];
        
        // add the nodes into a priority queue
        // sort based on values
        // comparator can also return a.val - b.val;
        Queue<ListNode> pq = new PriorityQueue<ListNode>(1, (a, b)-> {
            if(a.val < b.val)
                return -1;
            else if(a.val > b.val)
                return 1;
            return 0;
        });
        
        // iterate through the lists and add the nodes to a priority queue
        for(int i = 0; i<lists.length; i++) {
            // just add the first nodes of each list, no need to traverse now
            ListNode head = lists[i];
            if(head != null)
                pq.add(head);
            // while(head != null) {
            //     pq.add(head);
            //     head = head.next;
            // }
        }
        
        // now collect all the nodes from the priority queue and join them into a single list
        ListNode dummy = new ListNode(-1);
        ListNode newHead = dummy;
        
        while(!pq.isEmpty()) {
            // pop and join the nodes
            ListNode curr = pq.poll();
            dummy.next = curr;
            dummy = dummy.next;
            
            // if the popped node has a next node, add it into the pq so that it can be traversed
            if(curr.next != null)
                pq.add(curr.next);
        }
        
        dummy.next = null;
        
        return newHead.next;
    }
}