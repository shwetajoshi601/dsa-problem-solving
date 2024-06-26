// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    class Node 
    {
        int data;
        Node next;
        
        Node(int a)
            {
                data = a;
                next = null;
            }
    }
    class LLIntersection
    {
        static Scanner sc = new Scanner(System.in);
        public static Node inputList(int size)
        {
            Node head, tail;
            int val;
            
            val = sc.nextInt();
            
            head = tail = new Node(val);
            
            size--;
            
            while(size-->0)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            return head;
        }
        
        public static void printList(Node n)
        {
            while(n!=null)
            {
                System.out.print(n.data + " ");
                n = n.next;
            }
        }
        
        public static void main(String args[])
            {
                
                int t = sc.nextInt();
                while(t-->0)
                    {
                        int n , m;
                        
                        n = sc.nextInt();
                        m = sc.nextInt();
                        
                        Node head1 = inputList(n);
                        Node head2 = inputList(m);
                        
                        Sol obj = new Sol();
                        
                        Node result = obj.findIntersection(head1, head2);
            
                        printList(result);
                        System.out.println();
                    }
            }
    }// } Driver Code Ends
    
    
    /* Node of a linked list
     class Node {
       int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }
    */
    
    class Sol
    {
       public static Node findIntersection(Node head1, Node head2)
        {
            Node l1 = head1, l2 = head2;
            
            Node joinHead = new Node(-1);
            Node join = joinHead;
            
            while(l1 != null && l2 != null) {
                if(l1.data == l2.data) {
                    join.next = new Node(l1.data);
                    join = join.next;
                    
                    l1 = l1.next;
                    l2 = l2.next;
                } else if(l1.data < l2.data)
                    l1 = l1.next;
                else
                    l2 = l2.next;
            }
            
            return joinHead.next;
        }
    }