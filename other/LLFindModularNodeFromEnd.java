import java.util.*;


class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

public class LLModularNodeFromEnd {
    static int findModularNode(Node head, int k) {
        Node slow = head, fast = head;
        // as good as finding kth node from end
        for(int i=0;i<k && fast != null;i++)
            fast = fast.next;
        
        if(fast == null)
            return -1;
            
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow.data;
    }
  
    public static void main(String args[]) {
        Node myList = new Node(1);
        myList.next = new Node(2);
        myList.next.next = new Node(3);
        myList.next.next.next = new Node(4);
        myList.next.next.next.next = new Node(5);
        
        System.out.println(findModularNode(myList, 2));
    }
}