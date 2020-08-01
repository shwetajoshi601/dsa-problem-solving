/*
class Node
{
    int data;
    Node next;
}
*/

class LLDetectAndRemoveLoop {
    public static void removeLoop(Node head) {
        // code here
        // remove the loop without losing any nodes
        Node slow = head, fast = head;
        boolean loopExists = false;

        // detect loop using Floyd's cycle detection
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                loopExists = true;
                break;
            }
        }

        if (loopExists) {

            // if the loop begins at head node
            if (slow == head && fast == head) {
                // do while important to begin the loop
                do {
                    // move fast until its next is equal to slow (head)
                    fast = fast.next;
                } while (fast.next != slow);
            } else {
                // loop does not begin at head
                slow = head;

                // mopve both slow and fast till their next nodes are the same
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }

            // remove loop by setting next of fast to null
            fast.next = null;
        }
    }
}