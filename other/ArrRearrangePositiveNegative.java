import java.util.*;
import java.lang.*;
import java.io.*;

class ArrRearrangePositiveNegative
 {
    // O(N) time, O(1) space
    static void reArrangeElements(int[] arr) {
        if(arr.length == 0 || arr.length == 1) return;
        
        // two pointer
        int start = 0, end = arr.length - 1;
        
        while(start < end) {
            // positive element at the start
            if(arr[start] > 0) {
                // swap with the end element
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                // only decrement end since the new number at start after swap should be checked too
                end--;
            } else if(arr[start] < 0) {
                // num at start negative, move ahead
                start++;
            }
        }
    } 
    
	public static void main (String[] args) throws IOException
	 {
	   //int[] arr = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
	   //int[] arr = {1,2,3,4,5};
	   //int[] arr = {-1, -2, -3, -4, -5};
	   int[] arr = {1, -2, -3, -4, 5};
	     
	     reArrangeElements(arr);
	     System.out.println("Elements after rearranging elements: ");
	     for(int i: arr)
	        System.out.print(i + " ");
	 }
}