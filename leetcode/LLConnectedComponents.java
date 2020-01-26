/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LLConnectedComponents {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>(Arrays.stream(G).boxed().collect(Collectors.toList()));
        
        int count = 0;

        while(head != null) {
            // if current value is present in the set
            if(set.contains(head.val)) {
                count++;
                
                // check if consecutive elements occur in the set
                // they form only 1 connected component
                while(head != null && head.next != null && set.contains(head.next.val))
                    head=head.next;
            }
            // move to the next new node
            head=head.next;
        }
        
        return count;
    }
} 