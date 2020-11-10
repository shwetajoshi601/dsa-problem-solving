class MyQueue {
    
    Stack<Integer> st1;
    Stack<Integer> st2;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        st1 = new Stack<Integer>();
        st2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    // O(1)
    public void push(int x) {
        st1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    // O(N)
    public int pop() {
        copyElements();
        return st2.pop();
    }
    
    /** Get the front element. */
    // O(N)
    public int peek() {
        copyElements();
        return st2.peek();
    }
    
    void copyElements() {
        if(st2.isEmpty()) {
            while(!st1.isEmpty())
                st2.push(st1.pop());
        }
    }
    
    /** Returns whether the queue is empty. */
    // O(1)
    public boolean empty() {
        return (st1.isEmpty() && st2.isEmpty());
    }
}

// using a variable to store the front element
// improves the complexity of peek
class MyQueue2 {
    
    Stack<Integer> st1;
    Stack<Integer> st2;
    int front;
    
    /** Initialize your data structure here. */
    public MyQueue2() {
        st1 = new Stack<Integer>();
        st2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    // to improve the complexity of the pop and peek operations we can store the first element in a variable
    public void push(int x) {
        if(st1.isEmpty())
            front = x;
        st1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        copyElements();
        return st2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(!st2.isEmpty())
            return st2.peek();
        return front;
    }
    
    void copyElements() {
        if(st2.isEmpty()) {
            while(!st1.isEmpty())
                st2.push(st1.pop());
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (st1.isEmpty() && st2.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */