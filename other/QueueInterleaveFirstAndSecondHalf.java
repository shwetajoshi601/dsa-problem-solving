import java.util.*;

public class QueueInterleaveFirstAndSecondHalf {
  
    public static void main(String args[]) {
         Queue<Integer> q = new LinkedList<Integer>();
        for(int i=11; i<=20; i++)
            q.add(i);
         
         interleaveHalves(q);
         
         while(!q.isEmpty())
            System.out.print(q.poll() + " ");
    }
    
    static void interleaveHalves(Queue<Integer> q) {
        if(q.isEmpty())
            return;
            
        // the idea is to get half the elements in the stack and half in the Queue
        // such that picking one element from each results in interleaved result
        // so we remove and put elements in a stack and the queue until we get this
       Stack<Integer> st = new Stack<Integer>();
       
       // get the size
       int n = q.size();
       
       // put the first half in a stack
       int currCount = 0;
       while(currCount++ < n/2)
            st.push(q.poll());
        
        // now pop and put the elements of the stack into the queue            
        while(!st.isEmpty())
            q.add(st.pop());
            
        
        currCount = 0;
        // de queue the first half and push back into the queue
        while(currCount++ < n/2)
            q.add(q.poll());
            
        currCount = 0;
        // put the first half into the stack again
        while(currCount++ < n/2)
            st.push(q.poll());
            
        // interleave the elements of the stack and queue
        while(!st.isEmpty()) {
            q.add(st.pop());
            q.add(q.poll());
        }
    }
}
