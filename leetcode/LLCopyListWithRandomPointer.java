/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class LLCopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        
        // map of original node -> new node
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node curr = head;
        
        // iterate the list
        while(curr != null) {
            // create a copy of each node
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        // reiterate and assign the next and random pointers
        curr = head;
        
        while(curr != null) {
            // assign the next of the copy node to the copy node of the next of original node
            map.get(curr).next = map.get(curr.next);
            // same for random
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        
        // return the copy of head
        return map.get(head);
    }

    // O(N) solution, O(1) extra space
    public Node copyRandomListWithoutExtraSpace(Node head) {
        if(head == null) return head;
        Node curr = head;
        
        // Step 1: Create new nodes after each node with a copy of the data, 1->1->2->2
        while(curr != null) {
            // store the next node to traverse
            Node next = curr.next;
            curr.next = new Node(curr.val);
            // point the copy node to the next node in the LL
            curr.next.next = next;
            // move to the next original node
            curr = next;
        }
        
        // Step 2: Update the random pointers of the copy nodes
        curr = head;
        while(curr != null && curr.next != null) {
            // curr.next -> copy node, curr.arb -> random node of original node
            // curr.next.arb -> random of copy, curr.arb.next -> copy of random
            curr.next.random = curr.random != null ? curr.random.next : curr.random;
            // updating only copy nodes, hence skip one node (next.next)
            curr = curr.next.next;
        }
        
        // Step 3: Separate the original and copy list
        curr = head;
        Node currCopyHead = head.next;
        Node currCopy = head.next;
        
        while(curr != null && currCopy != null) {
            // every other node starting at head is original node
            curr.next = curr.next != null ? curr.next.next : curr.next;
            // every other node starting at head.next is copy node
            currCopy.next = currCopy.next != null ? currCopy.next.next : currCopy.next;
            
            // since the next is updated, move ahead
            curr = curr.next;
            currCopy = currCopy.next;
        }
        
        // return head of the copy LL
        return currCopyHead;
    }
}