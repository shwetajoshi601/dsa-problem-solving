import java.util.*;
import java.lang.*;
import java.io.*;

class ArrChocolateDistribution
 {
    static int distributeChocolates(int[] nums, int n, int m) {
        // sort the array
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        
        // check each subarray of size m
        // if difference between last and first element of the subarray
        // is less than min, update the min
        for(int i = 0; i+m-1 < n; i++) {
            if((nums[i+m-1]-nums[i]) < minDiff)
                minDiff = nums[i+m-1] - nums[i];
        }
        
        return minDiff;
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
	      
	     int m = sc.nextInt();
	     System.out.println(distributeChocolates(nums, n, m));
         // function call here
	 	}
	 }
}