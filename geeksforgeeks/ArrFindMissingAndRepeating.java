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
    
    // Using Swap Sort
    static void findMissingRepeatingSwapSort(int[] nums) {
        // check if the element at current index is at its right position
        // if not, swap it with the element at its right position
        // e.g. if arr[i] = 2, then 2's right pos is 1. so swap it with arr[1]
        int i=0;
        
        while(i < nums.length) {
            if(nums[i] != nums[nums[i]-1])
                swap(nums, i, nums[i]-1);
            else
                i++;
        }
        
        // at the end, all elements will  be at their correct positions
        // except for the repeating element
        // check if every element equals i+1. if not, the repeating elem is nums[i]
        // the missing number is i+1
        for(i=0; i<nums.length; i++) {
            if(nums[i] != i+1) {
                System.out.println(nums[i] + " " + Integer.valueOf(i+1));
            }
        }
    }
    
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
         findMissingRepeatingSwapSort(nums);
	 	}
	 }
}