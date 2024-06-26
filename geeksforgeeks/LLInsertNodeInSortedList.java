// { Driver Code Starts

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
    class LLInsertNodeInSortedList{
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
                
                int k = sc.nextInt();
                
                Solution g = new Solution();
                head = g.sortedInsert(head,k);
                
                printList(head); 
                t--;
            }
        } 
    } 
    // } Driver Code Ends
    
    
    
    /*class Node
        {
            int data;
            Node next;
            Node(int d) {data = d; next = null; }
        }*/
    
    // sortedInsert method should return the head of the modified linked list.
    class Solution {
        Node sortedInsert(Node head, int key) {
            // empty list
            if(head == null) {
                head = new Node(key);
                return head;
            }
            
            Node p = head, q = head;
            while(p != null) {
                if(key <= p.data) {
                    Node n = new Node(key);
                    if(p == head && q == head) {
                        // insert at head
                        n.next = p;
                        head = n;
                    } else {
                        // insert in between
                    q.next = n;
                    n.next = p;
                    }
                    break;
                }
                q = p;
                p = p.next;
            }
            
            if(p == null && q.next == null) {
                // insert at tail
                Node n = new Node(key);
                q.next = n;
            }
            
            return head;
        }

        Node sortedInsertWay2(Node head, int key) {
            Node newNode = new Node(key);
            
            // insert at head
            if(head == null || head.data >= key) {
                newNode.next = head;
                head = newNode;
                return head;
            }
                
            Node p = head, q = head;
            
            // keep a pointer at previous and move ahead until a value > key is found
            while(p != null && p.data < key) {
                q = p;
                p = p.next;
            }
            
            // found a node larger than the key
            // insert it before the larger number
            q.next = newNode;
            newNode.next = p;
            
            return head;
        }
    }