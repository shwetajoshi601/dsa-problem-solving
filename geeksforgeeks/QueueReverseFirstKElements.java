// { Driver Code Starts
//Initial Template for Java

import java.util.*;
class QueueReverseFirstKElements {
    public static void main(String[] args){
        
        //Taking input using class Scanner
        Scanner sc=new Scanner(System.in);
        
        //Taking total number of testcases
        int t=sc.nextInt();
        
        while(t-->0){
            //Taking count of total number of elements
            int n=sc.nextInt();
            
            //Taking count of total elements
            //that need to be reversed
            int k=sc.nextInt();
            
            //Creating a Queue
            Queue<Integer> q=new LinkedList<>();
            
            //adding all the elements to the Queue
            while(n-->0){
                q.add((int)sc.nextInt());
            }
            
            //Creating an object of class GfG
            GfG g=new GfG();
            
            //calling modifyQueue of class GfG
            //and passing Queue and k as arguments
            //and storing the reuslt in a new Queue
            Queue<Integer> ans=g.modifyQueue(q,k);
            
            //Printing all the elements from the
            //new Queue and polling them out
            while(!ans.isEmpty()){
                int a=ans.peek();
                ans.poll();
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class GfG
{
    //Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k)
    {
      int n = q.size();
      if(n == 0 || n == 1)
        return q;
        
      Stack<Integer> st = new Stack<Integer>();
      
      int i=0;
      
      // put the first k elements into a stack
      for(; i<k; i++)
        st.push(q.poll());
        
      // pop the elements from the stack (we get reversed k elements here)
      // push them back into the queue
      while(!st.isEmpty())
        q.add(st.pop());
    
     // now k elements are at the back of the queue, bring them forward
     // remove n-k elements from the queue and push them back
      for(i=0; i<n-k; i++)
        q.add(q.poll());
        
      return q;
    }
}
