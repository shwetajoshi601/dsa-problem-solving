// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
class LLSegregateEvenOdd{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node ans = ob.divide(n, head);
            printList(ans); 
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java

/* 
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution{
    Node divide(int N, Node head){
        if(head == null || head.next == null)
            return head;
            
        Node evenList = new Node(-1);
        Node evenCurr = evenList;
        Node oddList = new Node(-1);
        Node oddCurr = oddList;
        
        Node curr = head;
        
        while(curr != null) {
            Node next = curr.next;
            curr.next = null;
            
            if(curr.data % 2 == 0) {
                evenCurr.next = curr;
                evenCurr = evenCurr.next;
            } else {
                oddCurr.next = curr;
                oddCurr = oddCurr.next;
            }
            
            curr = next;
        }
        
        evenCurr.next = oddList.next;
        oddList.next = null;
        
        return evenList.next;
    }
}