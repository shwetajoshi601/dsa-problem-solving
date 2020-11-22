import java.util.*;
import java.lang.*;
import java.io.*;

class ArrFindTwoRepeatingElements
 {
	// O(n) time, O(n) space
	public Pair twoRepeated(int arr[], int N){
		int[] map = new int[N];
		
        for(int i=0; i<arr.length;i++) {
            map[arr[i]-1]++;
        }
        
        int first = -1, second = -1;
        for(int i=0; i<map.length; i++) {
            if(map[i] > 1 && first == -1)
                first = i+1;
            else if(map[i] > 1 && first != -1)
                second = i+1;
        }
        
        Pair pair = new Pair();
        pair.first = first;
        pair.second = second;
        
        return pair;
    }

	// O(n) time, O(1) space
    static void findRepeatingNums(int[] nums) {
        // System.out.println(nums.length);
        
        // for each ith element check the sign of a[a[i]]
        for(int i=0; i<nums.length; i++) {
            // if it is positive, make it negative
            if(nums[Math.abs(nums[i])] >0)
                nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
            else
            // if it is already negative, it is a repeating number
                System.out.print(Math.abs(nums[i]) + " ");
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
	     int[] nums = new int[n+2];
	     
	     for(int i=0; i<nums.length;i++) {
	         nums[i] = sc.nextInt();
	     }
	     findRepeatingNums(nums);
	 }
	 
	 }
}