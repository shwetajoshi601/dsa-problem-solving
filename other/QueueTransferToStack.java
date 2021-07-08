import java.util.*;

public class QueueTransferToStack {
  
    public static void main(String args[]) {
         Queue<Integer> q = new LinkedList<Integer>();
         q.add(5);
         q.add(1);
         q.add(2);
         q.add(4);
         q.add(6);
         
         Stack<Integer> st = new Stack<Integer>();
         transfer(q, st);
         
         while(!st.isEmpty())
            System.out.print(st.pop() + " ");
    }
    
    static void transfer(Queue<Integer> q, Stack<Integer> st) {
        if(q.isEmpty())
            return;

        int frontElem = q.poll();
        transfer(q, st);
        st.push(frontElem);
    }
}