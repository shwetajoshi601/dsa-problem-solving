import java.io.*;
import java.util.*;

class StackNextGreaterElementToLeft {
    
    static int[] nextLargerElementToLeft(int[] arr) {
        // same concept as next larger element to right, just that we iterate the array from the beginning
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i=0; i<arr.length; i++) {
            while(st.size() > 0 && st.peek() <= arr[i])
                st.pop();
                
            if(st.size() == 0)
                res[i] = -1;
            else
                res[i] = st.pop();
                
            st.push(arr[i]);
        }
        
        return res;
    }
    
	public static void main (String[] args) {
		int[] arr = {1, 3, 2, 4};
		int[] res = nextLargerElementToLeft(arr);
		
		for(int i: res)
		    System.out.print(i + " ");
	}
}