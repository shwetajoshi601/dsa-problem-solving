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
class LLSplitLinkedListInKParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        // k = number of parts to divide into
        
        ListNode curr = root;
        int n = 0;
        while(curr != null) {
            n++;
            curr = curr.next;
        }
        
        int n_nodes = n / k;
        int rem_nodes = n % k;
        
        // an array to hold the k parts
        ListNode[] ans = new ListNode[k];
        
        // creating k parts
        curr = root;
        for(int i=0; i< k; i++) {
            // start of the part LL
            ListNode partCurr = new ListNode(-1);
            ListNode head = partCurr;
            
            // add nodes to the part,
            // each part has n/k nodes and an additional 1 node if the part number is less than the remaining nodes number
            // e.g. n=10, k=3; current part-> 0. is 0 < 1? yes-> hence part 0 will have n_nodes+1 extra node.
            for(int j=0; j < n_nodes + (i < rem_nodes ? 1 : 0); j++) {
                ListNode node = new ListNode(curr.val);
                partCurr.next = node;
                partCurr = node;
                
                if(curr != null) curr = curr.next;
            }
            ans[i] = head.next;
        }
        
        return ans;
    }
}