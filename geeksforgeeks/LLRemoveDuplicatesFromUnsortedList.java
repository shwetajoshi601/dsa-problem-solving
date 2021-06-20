// { Driver Code Starts
/* package whatever; // don't place package name! */
import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}

class LLRemoveDuplicatesFromUnsortedList
{
    Node head;  
    Node temp;
	public void addToTheLast(Node node) 
	{

	  if (head == null) 
	  {
	    head = node;
	    temp = node;
	  }
	  else{
	      temp.next = node;
	      temp = node;
	  }
	}

      void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
	/* Drier program to test above functions */
	public static void main(String args[])
    {
       
        
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		  
		 while(t>0)
         {
			int n = sc.nextInt();
			LLRemoveDuplicatesFromUnsortedList llist = new LLRemoveDuplicatesFromUnsortedList();
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
		//llist.printList();	
        GfG g = new GfG();
		llist.head = g.removeDuplicates(llist.head);
		llist.printList();
		
        t--;		
        }
    }
}
// } Driver Code Ends


/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}
*/

class GfG
{
    // Function to remove duplicates from the given linked list
    public Node removeDuplicates(Node head) 
    {
         Node p = head, q = head;
         Set<Integer> set = new HashSet<Integer>();
         
         while(p != null) {
            if(set.contains(p.data)) {
                // duplicate found
                // can also write q.next = p.next and take p.next out of if else since its common
                p = p.next;
                q.next = p;
            } else {
                set.add(p.data);
                q = p;
                p = p.next;
            }    
         }
         
         return head;
    }

    public Node removeDuplicatesWithoutExtraSpace(Node head) 
    {
         // Without using extra space
         if(head == null || (head != null && head.next == null))
            return head;
            
         Node curr = head;
         
         while(curr != null) {
             Node runner = curr;
             
             while(runner != null && runner.next != null) {
                 if(curr.data == runner.next.data)
                    runner.next = runner.next.next;
                 else
                    runner = runner.next;
             }
             
             curr = curr.next;
         }
         
         return head;
    }
}
