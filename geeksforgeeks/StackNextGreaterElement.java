// { Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class StackNextGreaterElement {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new solve().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}



// } Driver Code Ends


class solve{
    public static long[] nextLargerElement(long[] arr, int n) { 
        // result array
        long[] res = new long[arr.length];
        Stack<Long> st = new Stack<Long>();
        
        // iterate the array backwards
        // since we need to use a stack and the first element after the current element needs to be checked first
        // it should be pushed on the stack at last (LIFO)
        
        for(int i = arr.length-1; i>=0; i--) {
            // if stack size is 0, NGE is -1
            // if top of stack is smaller, pop until a larger one is found (pop would check the elements from left to right)
            while(st.size() > 0 && st.peek() <= arr[i])
                st.pop();
                
            // if the while loop stops due to empty stack
            if(st.size() == 0)
                res[i] = -1;
            else
                // stops when a larger element is found
                res[i] = st.peek();
                
            // push the current element onto the stack
            st.push(arr[i]);
        }
        
        return res;
    } 
}