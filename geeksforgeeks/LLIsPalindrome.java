import java.util.*;

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

class LLIsPalindrome
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
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		 
		while(t>0)
        {
			int n = sc.nextInt();
			//int k = sc.nextInt();
			LLIsPalindrome llist = new LLIsPalindrome();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			
			Palindrome g = new Palindrome();
			if(g.isPalindrome(llist.head) == true)
			System.out.println(1);
		else
			System.out.println(0);
			t--;
		}
		
	}
}

/*This is a function problem.You only need to complete the function given below*/
/* Structure of class Node is
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/
class Palindrome
{
    Node reverse(Node head) {
        if(head!=null) {
            Node cur=head, prev=null, next=null;
            while(cur!=null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            head = prev;
        }
        return head;
    }
    // Function to check if linked list is palindrome
    boolean isPalindrome(Node head) 
    {
        if(head == null) return false;
        // p=slow, q=fast
        Node q=head, p=head;
        while(q.next!= null && q.next.next!= null) {
            p=p.next;
            q=q.next.next;
        }

        Node rev = reverse(p.next);
        while(rev != null) {
            if(head.data != rev.data) return false;
            head=head.next;
            rev=rev.next;
        }
        return true;
    }
}
