// { Driver Code Starts
    import java.util.*;
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    } 
    
    class LLRotateCounterClockwise {
        public static void main(String[] args) {
            
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            
            while (t-- > 0) {
                int n = sc.nextInt();
                
                int a = sc.nextInt();
                Node head = new Node(a);
                Node tail = head;
                
                for (int i=0; i<n-1; i++)
                {
                    a = sc.nextInt();
                    tail.next = new Node(a);
                    tail = tail.next;
                }
                
                int k = sc.nextInt();
                
                Rotate g = new Rotate();
                head = g.rotate(head,k);
                printList(head);
            }
        }
        
        public static void printList(Node n) {
            while (n != null) {
                System.out.print(n.data + " ");
                n = n.next;
            }
            System.out.println();
        }
    }
    // } Driver Code Ends
    
    
    
    /* node of linked list:
    
    class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
    
    */
    
    class Rotate{
        // This function should rotate list counter-
        // clockwise by k and return head node
        
        public Node rotate(Node head, int k) {
            if(head == null) return head;
            
            Node curr = head;
            
            // move to the kth node
            for(int i=0; i<k-1; i++) {
                // happens if k > length of the linked list
                if(curr == null) return head;
                curr = curr.next;
            }
            
            // if k = length of linked list, curr.next is null
            if(curr.next == null) {
                // when list is rotated its length times, we get the original linked list
                return head;
            }
            
            // k < length
            // the new head
            Node newHead = curr.next;
            // curr is at the kth node, this sub part will be appended at the end
            curr.next = null;
            
            // move to the last node of the remaining list
            curr = newHead;
            while(curr.next != null) {
                curr = curr.next;
            }
            // append the first k nodes
            curr.next = head;
            
            // return the rotated list
            return newHead;
        }

        // Approach-2: Make the list circular and update the head
        public Node rotate(Node head, int k) { 
            if(head == null) return head;
            
            Node curr = head;
            
            //travserse till the end
            while(curr.next != null)
                curr = curr.next;
            
            // make the list circular    
            curr.next = head;
            
            // now traverse till the kth node
            int i=0;
            while(i++ < k && curr!=null)
                curr=curr.next;
            
            // set the new head as k+1th node
            Node newHead = curr.next;
            // terminate
            curr.next = null;
            
            // since the list is circular the last node already points to the head making the list complete
            return newHead;
        }
    }
    