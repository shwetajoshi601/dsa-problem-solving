/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    // solution using Stack
    public Node flatten(Node head) {
        // the idea is to store the remaining parts of a list after the node that contains a child, add the child as the next pointer, and then add the remainig parts from a stack
        
        Node curr = head;
        // stack to maintain the remaing part of the list having a child node
        Stack<Node> st = new Stack<Node>();
        
        while(curr != null) {
            // the node contains a child
            if(curr.child != null) {
                // store its remaining part in the stack
                if(curr.next != null) st.push(curr.next);
                // set the next to the child list
                curr.next = curr.child;
                // doubly ll, so set the prev pointer
                curr.next.prev = curr;
                curr.child = null;
            // if it is the end of the list and the stack contains next parts
            } else if(curr.next == null && !st.isEmpty()) {
                // append them to the end
                curr.next = st.pop();
                curr.next.prev = curr;
            }
            
            // move ahead
            curr = curr.next;
        }
        
        // return the original head
        return head;
    }
}