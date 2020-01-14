{
import java.util.*;
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
		
public class LLFindUnion
{
    Node head;  
	
	/* Function to print linked list */
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
 
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) 
	{
		if (head == null) 
		{
			head = node;
		} else 
		{
		   Node temp = head;
		   while (temp.next != null)
		   temp = temp.next;
		   temp.next = node;
		}
    }
	  
     /* Drier program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t-->0)
         {
			int n = sc.nextInt();
            GFG2 llist1 = new GFG2(); 
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist1.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist1.addToTheLast(new Node(a));
			}
		    llist1.head= head;
		    n = sc.nextInt();
			a1=sc.nextInt();
		    GFG2 llist2=new GFG2();
			Node head2= new Node(a1);
            llist2.addToTheLast(head2);
		    llist2.head=head2;
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist2.addToTheLast(new Node(a));
			}
			GFG obj=new GFG();
			Node start=obj.findUnion(llist1.head,llist2.head);
		    llist1.printList(start);
		}
	}
}
	

}
/*This is a function problem.You only need to complete the function given below*/

/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/
class GFG
{
    TreeSet<Integer> addToSet(Node head, TreeSet<Integer> set) {
        Node p = head;
        while(p!=null) {
            set.add(p.data);
            p=p.next;
        }
        return set;
    }
    
	Node findUnion(Node head1,Node head2)
	{
	    TreeSet<Integer> set = new TreeSet<Integer>();
	    set = addToSet(head1, set);
	    set = addToSet(head2, set);
	    
	    Iterator<Integer> itr = set.iterator();
	    GFG2 list = new GFG2();
	    while(itr.hasNext()) {
	        Node node = new Node(itr.next().intValue());
	        list.addToTheLast(node);
	    }
	    return list.head;
    }
}