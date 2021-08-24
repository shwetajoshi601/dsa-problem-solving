import java.util.*;

class Pair {
    int value;
    int count;
    
    Pair(int val, int i) {
        value = val;
        count = i;
    }
}

class MyStack {
    Queue<Pair> pq;
    // serial number for each element, determines its priority
    int count;
    
    MyStack(int capacity) {
        pq = new PriorityQueue<Pair>(capacity, (a,b)-> {
           // sort in descending order of count
           // stack is last in first out
           if(a.count > b.count)
                return -1;
            else if(a.count < b.count)
                return 1;
                
            return 0;
        });
        
        count = 0;
    }
    
    void push(int val) {
        count++;
        pq.add(new Pair(val, count));
    }
    
    int pop() {
        if(pq.isEmpty())
            return -1;
            
        Pair popped = pq.poll();
        count--;
        return popped.value;
    }
    
    int peek() {
        if(pq.isEmpty())
            return -1;
            
        return pq.peek().value;
    }
    
    boolean isEmpty() {
        return pq.isEmpty();
    }
}

public class PriorityQueueImplementStackUsingPQ {
    
    public static void main(String args[]) {
        MyStack st = new MyStack(100);
        st.push(5);
        st.push(10);
        st.push(3);
        st.push(20);
        st.push(7);
        
        System.out.println("Top: " + st.peek());
        
        st.pop();
        st.pop();
        System.out.println("Top after popping: " + st.peek());
        
        st.pop();
        st.pop();
        st.pop();
        System.out.println("isEmpty: " + st.isEmpty());
        
        st.push(33);
        System.out.println("Top: " + st.peek());
    }
}
