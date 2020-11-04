// { Driver Code Starts
    import java.util.*;

    class Node
    {
        int data;
        Node next;
        
        Node(int key)
        {
            data = key;
            next = null;
        }
    }
    
    class LinkedList
    {
        static Node head;
        
         public static void addToTheLast(Node node) 
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
        
         public static void main (String[] args) {
             Scanner sc = new Scanner(System.in);
             int t=sc.nextInt();
             
             while(t-- > 0)
             {
                 int n = sc.nextInt();
                 int a1 = sc.nextInt();
                 Node head = new Node(a1);
                 addToTheLast(head);
                 for(int i = 1; i < n; i++)
                 {
                     int a = sc.nextInt(); 
                     addToTheLast(new Node(a));
                 }
                 int k = sc.nextInt();
                GfG gfg = new GfG();
                System.out.println(gfg.nknode(head, k));
                 }
             }
    }// } Driver Code Ends
    
    
    /*
    class Node
    {
        int data;
        Node next;
        
        Node(int key)
        {
            data = key;
            next = null;
        }
    }
    */
    
    class GfG
    {
        public static int nknode(Node head, int k)
        {
            // take two pointers -> slow and fast
            // move slow one step ahead when fast travels k steps
            
            if(head == null || k == 0) return 0;
            
            Node slow = null, fast = head;
            int i = 0;
            
            while(fast != null) {
                // reached a multiple of k
                if(i%k == 0) {
                    if(slow == null)
                        slow = head;
                    else
                        slow = slow.next;
                }
                i++;
                fast = fast.next;
            }
            
            // when fast reaches the end, slow is at n/kth node
            // k x slow = fast
            // when fast = N, k x slow = n -> slow = n/k
            
            return slow.data;
        }
    }
    