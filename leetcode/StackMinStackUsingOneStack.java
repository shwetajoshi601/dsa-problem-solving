class StackMinStackUsingOneStack {

    /** initialize your data structure here. */
    // maintain a single stack for elements, with each element store the corresponding min
    Stack<StackElement> st;
    
    public MinStack() {
        st = new Stack<StackElement>();
    }
    
    public void push(int x) {
        int min = x;
        if(!st.isEmpty())
            // store the current min
            min = Math.min(min, st.peek().min);
        st.push(new StackElement(x, min));
    
    }
    
    public void pop() {
        if(st.isEmpty())
            return;
        
        st.pop();
    }
    
    public int top() {
        if(st.isEmpty())
            return -1;
        
        return st.peek().value;
    }
    
    public int getMin() {
        if(st.isEmpty())
            return -1;
        
        return st.peek().min;
    }
}

public class StackElement {
    int value;
    int min;
    
    StackElement(int value, int min) {
        this.value = value;
        this.min = min;
    }
} 

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */