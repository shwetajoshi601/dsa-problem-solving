import java.util.*;

public class StackNextSmallerElementToLeft {
    static int[] nextSmaller(int[] arr, int n) {
        int[] res = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && st.peek() >= arr[i])
                st.pop();
                
            if(st.isEmpty())
                res[i] = -1;
            else {
                res[i] = st.peek();
            }
            
            st.push(arr[i]);
        }
        
        return res;
    }
  
    public static void main(String args[]) {
       int[] arr = {1,3,2,4};
       int[] res = nextSmaller(arr, arr.length);
       
       for(int i=0; i<res.length; i++)
            System.out.print(res[i] + " ");
    }
}