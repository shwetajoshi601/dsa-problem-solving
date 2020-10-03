class StackMinStackWithExtraSpace {

    /** initialize your data structure here. */
    // maintain two stacks - for the actual elements, and minimum values
    // the idea is to store the min values upto the current number
    // this is necessary since when an element is removed, and that is the current min
    // the min gets updated too
    Stack<Integer> st;
    Stack<Integer> mins;
    
    public MinStack() {
        st = new Stack<Integer>();
        mins = new Stack<Integer>();
    }
    
    public void push(int x) {
        // push the value
        st.push(x);
        
        // if the mins stack is empty or the current value is less than the previous min value
        if(mins.isEmpty() || x<=mins.peek())
            // push the new min value
            mins.push(x);
    }
    
    public void pop() {
        if(st.isEmpty())
            return;
        
        // pop the element
        int curr = st.pop();
        System.out.println("popped: " + curr);
        // if the popped element is the min
        // we need to update the min to the previous min value
        if(curr == mins.peek())
            // remove this value from mins too
            mins.pop();
    }
    
    public int top() {
        if(!st.isEmpty())
            // return the top element
            return st.peek();
        // empty stack
        else return -1;
    }
    
    public int getMin() {
        // the top element in mins is the current min value
        if(!mins.isEmpty())
            return mins.peek();
        
        // empty stacks
        else return -1;
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