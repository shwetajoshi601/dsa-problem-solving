import java.util.*;


class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

public class LLJosephus {
    static int getSurvivor(int N, int M) {
        // create circular list
        Node p = new Node(-1);
        Node head = p;
        
        for(int i = 1; i<=N; i++) {
            p.next = new Node(i);
            p = p.next;
        }
        
        p.next = head.next;
        head = head.next;
        
        // remove every mth node
        for(int i=0; i<N-1; i++) {
            // reach the node before mth node
            for(int j = 0; j<M-2; j++)
                head = head.next;
            
            // delete it    
            head.next = head.next.next;
            // move to the next node
            head=head.next;
        }
        
        return head.data;
    }
  
    public static void main(String args[]) {
        System.out.println(getSurvivor(5, 2));
    }
}