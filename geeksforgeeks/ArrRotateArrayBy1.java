import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static void rotateArray(int[] nums) {
        if(nums.length == 1) return;
        
        int first = nums[0];
        int i=0;
        for(i=nums.length-1; i>0; i--) {
            int index = (i+1) % nums.length;
            nums[index] = nums[i];
        }
        
        nums[++i] = first; 
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
         // function call here
         rotateArray(nums);
         for(int i: nums)
            System.out.print(i + " ");
            
         System.out.println();
	 	}
	 }
}