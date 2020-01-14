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
	
 class LLFindIntersection
{
    Node head = null;  
	Node tail = null;
public void addToTheLast(Node node) 
{
  if (head == null) {
   head = node;
   tail = head;
  } else {
   //Node temp = head;
   //while (temp.next != null)
    //temp = temp.next;
   //temp.next = node;
   tail.next=node;
   tail = node;
  }
}
  /* Function to print linked list */
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
	
	 
 
     /* Driver program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();
			LLFindIntersection llist1 = new LLFindIntersection();
		    LLFindIntersection llist2 = new LLFindIntersection();
			LLFindIntersection llist3 = new LLFindIntersection();
			
				int a1=sc.nextInt();
				Node head1= new Node(a1);
				Node tail1= head1;
				llist1.addToTheLast(head1);
				for (int i = 1; i < n1; i++) 
				{
					int a = sc.nextInt(); 
					llist1.addToTheLast(new Node(a));
				}
			
			
				int b1=sc.nextInt();
				Node head2 = new Node(b1);
				Node tail2 = head2;
				llist2.addToTheLast(head2);
				for (int i = 1; i < n2; i++) 
				{
					int b = sc.nextInt(); 
					llist2.addToTheLast(new Node(b));
				}
				
				int c1=sc.nextInt();
				Node head3= new Node(c1);
				Node tail3=head3;
				llist3.addToTheLast(head3);
				for (int i = 1; i < n3; i++) 
				{
					int c = sc.nextInt(); 
					llist3.addToTheLast(new Node(c));
				}
				
				if (tail1 != null)
				tail1.next = head3;
				if (tail2 != null)
				tail2.next = head3;
				
				Intersect obj = new Intersect();
				System.out.println(obj.intersectPoint(llist1.head, llist2.head));
			t--;			
         }
    }
}

/*This is a function problem.You only need to complete the function given below*/
/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}
This is method only submission.  You only need to complete the method. */
class Intersect
{
    int getCount(Node head) {
        Node p = head;
        int count = 0;
        while(p!=null) {
            count++;
            p=p.next;
        }
        return count;
    }

	int intersectPoint(Node headA, Node headB)
	{
         if(headA==null || headB==null) return -1;

         int size1 = getCount(headA);
         int size2 = getCount(headB);
         System.out.println("sz 1:"+ size1);
         System.out.println("sz 2:"+ size2);
         int diff = size1 - size2;
         Node larger = null, smaller = null;
         if(size1 >= size2) {
             larger = headA;
             smaller = headB;
         } else {
             larger = headB;
             smaller = headA;
         }
         
         diff = Math.abs(size1 - size2);
         for(int i=0; i<diff; i++) {
             larger = larger.next;
         }
         System.out.println("larger ptr:" + larger.data);
         while(larger != null && smaller != null) {
             if(larger.data == smaller.data) return larger.data;
         }
         return -1;
	}
}