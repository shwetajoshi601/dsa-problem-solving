import java.util.*;
import java.lang.*;
import java.io.*;

class ArrFindMissingAndRepeating
{
    static void findMissingAndRepeating(int[] nums) {
        // for every ith index, check the value of abs(nums[i-1])
        // do i-1 to avoid index out of bounds, elements are 1 to n and array index begins from 0
        for(int i=0; i<nums.length; i++) {
            int val = Math.abs(nums[i]);
            // if positive, make it negative
            if(nums[val-1] > 0)
                nums[val-1] = -nums[val-1];
            else
            // if already negative, it is repeated
                System.out.print(val + " ");
        }
        
        // traverse the array again and find the positive number
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0)
            // the value i+1 will be missing
                System.out.print((i+1) + " ");
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
	     
	     for(int i=0; i<nums.length; i++) {
	         nums[i] = sc.nextInt();
	      }
         // function call here
         findMissingAndRepeating(nums);
	 	}
	 }
}