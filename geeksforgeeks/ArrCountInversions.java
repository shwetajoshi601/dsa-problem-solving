import java.util.*;
import java.lang.*;
import java.io.*;

class ArrCountInversions
 {
    // TODO: Giving one less than the desired output - to debug
    static int merge(int[] arr, int l, int m, int r) {
        int count=0;
        // for left and right subarrays
        // m=5, l=0, m-l=5, 0 to 5 is 6 elements -> m-l+1=6
        int len1 = m-l+1;
        int len2 = r-m;
        
        int[] left = new int[len1];
        int[] right = new int[len2];
        
        // put elements in left subarray from l to m
        for(int i=0; i<len1; i++)
            left[i] = arr[l+i];
            
        // put elements in right subarray from m+1 to r
        for(int j=0;j<len2;j++)
            right[j] = arr[m+1+j];

            
        int i=0, j=0, k=l;
        // iterate both left and right arrays
        while(i<len1 && j<len2) {
            if(left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                // inversion
                arr[k++] = right[j++];
                // if a[i] > a[j],  then all elements after ith element will also be greater than a[j]
                // This is because the left and right subarrays are themself sorted
                // Hence we get m-i inversions
                // eg: i=2, m=5, and a[i] > a[j], then there will be 5-2, 3 inversions
                count+= (m-i);
            }
        }
        
        // remaining elements of left subarray
        while(i<len1)
            arr[k++] = left[i++];
            
        // remaining elements of right subarray
        while(j<len2)
            arr[k++] = right[j++];
            
        return count;
    }
     
    static int mergeSort(int[] arr, int l, int r) {
        int count=0;
        
        if(l<r) {
            int mid = (l+r)/2;
            count+=mergeSort(arr, l, mid);
            count+=mergeSort(arr, mid+1, r);
            
            count+=merge(arr, l, mid, r);
        }
        
        return count;
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
         System.out.println(mergeSort(nums, 0, nums.length-1));
	 	}
	 }
}