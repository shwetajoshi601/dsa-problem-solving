// { Driver Code Starts
    import java.util.Scanner;
    import java.util.Stack;
    class StackMinStackWithoutExtraSpace {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                Stack < Integer > s = new Stack < > ();
                GfG g = new GfG();
                while (!g.isFull(s, n)) {
                    g.push(sc.nextInt(), s);
                }
                System.out.println(g.min(s));
            }
        }
    } // } Driver Code Ends
    
    
    /*Complete the function(s) below*/
    class GfG {
        int min = -1;
    
        public void push(int x, Stack < Integer > st) {
            if (st.isEmpty()) {
                // stack is empty
                st.push(x);
                min = x;
            } else {
                // stack is not empty
    
                // if the curr elem is greater than the min
                // min need not be updated, hence push the element
                if (x > min)
                    st.push(x);
                else {
                    // x < min
                    // push 2x-min into the stack (as a flag)
                    st.push(2 * x - min);
                    // update the min
                    min = x;
                }
            }
        }
        public int pop(Stack < Integer > st) {
            int res = -1;
            //add code here.
            if (st.isEmpty())
                return -1;
    
    
            // top element is greater than min
            // min need not be updated
            if (st.peek() >= min)
                res = st.pop().intValue();
            else {
                // top element is less than min
                // this can only happen when the top element is a flag
                // the actual value is in the min element
                res = st.pop();
                // update the min to the previous value
                min = 2 * min - res;
            }
    
            return res;
        }
        public int min(Stack < Integer > s) {
            if (s.isEmpty())
                return -1;
    
            return min;
        }
        public boolean isFull(Stack < Integer > s, int n) {
            return s.size() == n;
        }
        public boolean isEmpty(Stack < Integer > s) {
            return s.isEmpty();
        }
    }