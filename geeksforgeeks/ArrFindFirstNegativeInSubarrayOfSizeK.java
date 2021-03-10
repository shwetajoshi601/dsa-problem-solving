import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
    public static void findFirstNegative(int[] arr, int n, int k) {
        // System.out.println("N: " + n);
        // System.out.println("K: " + k);
        // sliding window
        int i = 0;
        // queue to track the first negative number - the idea is to reuse the previously checked numbers
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int j=0; j<n; j++) {
            // add the number to the queue if its negative
            if(arr[j] < 0)
                q.add(arr[j]);
                
            int currLen = j-i+1;
            // hit window size
            if(currLen == k) {
                // print the first negative number if present
                if(q.size() > 0)
                    System.out.print(q.peek().intValue());
                else
                    System.out.print(0);
                System.out.print(" ");
                
                // slide the window
                // if the element being excluded from the window is present in the queue,
                // remove it from the queue too
                if(q.size() > 0 && arr[i] == q.peek())
                    q.remove();
                
                i++;
            }
        }
        System.out.println();
    }
     
     
	public static void main (String[] args)
	 {
	 //code
	 Scanner sc = new Scanner(System.in);
	 int t = sc.nextInt();
	 
	 while(t-- > 0) {
	     int n = sc.nextInt();
	     int[] nums = new int[n];

	     for(int i=0; i<nums.length;i++) {
	         nums[i] = sc.nextInt();
	      }
	      int k = sc.nextInt();
         // function call here
         findFirstNegative(nums, n, k);
	 	}
	 }
}