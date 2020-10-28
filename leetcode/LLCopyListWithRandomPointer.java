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
}