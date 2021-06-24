import java.util.*;


class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

public class LLMedianOfASortedList {
    static float findMedian(Node head) {
        Node slow = head, fast = head;
        Node prev = null;
        
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return fast != null ? slow.data : ((float)prev.data + slow.data)/2; 
    }
  
    public static void main(String args[]) {
        Node myList = new Node(1);
        myList.next = new Node(2);
        myList.next.next = new Node(3);
        myList.next.next.next = new Node(4);
        // myList.next.next.next.next = new Node(5);
        
        System.out.println(findMedian(myList));
    }
}