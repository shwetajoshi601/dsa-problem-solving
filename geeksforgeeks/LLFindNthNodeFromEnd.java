// { Driver Code Starts
    import java.util.*;
    class Node
    {
        int data;
        Node next;
        Node(int d) 
        {
            data = d; 
            next = null;
        }
    }
        
    
        
    public class LLFindNthNodeFromEnd
    {
        Node head;  
        Node tail;
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
                tail = node;
            } else 
            {
                tail.next = node;
                tail = node;
            }
        }
          
         /* Drier program to test above functions */
        public static void main(String args[])
        {
             Scanner sc = new Scanner(System.in);
             int t=sc.nextInt();
             
             while(t>0)
             {
                int n = sc.nextInt();
                int k = sc.nextInt();
                LinkedList_Element_From_Last llist = new LinkedList_Element_From_Last();
                //int n=Integer.parseInt(br.readLine());
                int a1=sc.nextInt();
                Node head= new Node(a1);
                llist.addToTheLast(head);
                for (int i = 1; i < n; i++) 
                {
                    int a = sc.nextInt(); 
                    llist.addToTheLast(new Node(a));
                }
              
            //System.out.println(llist.head.data);
            GfG g = new GfG(); 
            //System.out.println(k);
            System.out.println(g.getNthFromLast(llist.head,k));
            
                t--;
            }
        }
    }
    
    
        
        // } Driver Code Ends
    
    
    /* Structure of node
    
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
    
    class GfG
    {
        int getCount(Node head) {
            Node p = head;
            int count = 0;
            
            while(p!= null) {
                count++;
                p = p.next;
            }
            
            return count;
        }
        
        //Function to find the data of nth node from the end of a linked list.
        int getNthFromLast(Node head, int n)
        {
            // get the number of nodes
            int count = getCount(head);
            
            // k cannot be greater than count, it would go beyond the list
            if(n > count) return -1;
            if(count == n) return head.data;
            
            // find the pos of the node from the start
            int posFromStart = count - n;
            Node p = head;
            
            // traverse to the pos
            while(--posFromStart > 0 && p != null)
                p=p.next;
                
            // now p is at the node before the kth node from end
            // hence return data of the next node (this is the kth node)
            return p.next != null ? p.next.data : p.data;
        }

        // a better and optimal solution - O(N) / O(1)
        int getNthFromLastUsingTwoPointer(Node head, int n)
        {
            // maintain two pointers
            // move fast k nodes. slow and fast are n nodes apart
            // now when fast hits the end, slow is at the nth node from the end.
            Node slow = head, fast = head;
            
            for(int i=0; i<n; i++) {
                // out of bounds, the node does not exist
                if(fast == null) return -1;
                fast = fast.next;
            }
            
            while(fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            
            return slow.data;
        }
    }
    