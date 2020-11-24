import java.util.*;
import java.lang.*;
import java.io.*;

class ArrFindUnion
 {
     // O(m+n) time, O(m+n) space
    static int findUnion(int[] nums1, int[] nums2, int n, int m) {
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i=0; i<n; i++) {
            set.add(nums1[i]);
        }
        
        for(int j=0; j<m; j++)
            set.add(nums2[j]);
            
        return set.size();
    }
    
    // only when both the arrays have distinct elements
    static int findUnionDistinct(int[] nums1, int[] nums2, int n, int m) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        // sort the two arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i=0, j=0;
        
        // check the smaller element, add it to the union, move ahead
        while(i < n && j < m) {
            // nums1 has a smaller element
            if(nums1[i] < nums2[j])
                res.add(nums1[i++]);
            else if(nums1[i] > nums2[j])
            // nums2 has a smaller element
                res.add(nums2[j++]);
            else {
                // when both are equal, move both i and j ahead
                res.add(nums1[i++]);
                j++;
            }
        }

        // remaining elements from the larger array
        while(i<n)
            res.add(nums1[i++]);
            
        while(j<m)
            res.add(nums2[j++]);
        
        return res.size();
    } 
    
	public static void main (String[] args)
	 {
	 //code
	 Scanner sc = new Scanner(System.in);
	 int t = sc.nextInt();
	 
	 while(t-- > 0) {
	     int n = sc.nextInt();
	     int m = sc.nextInt();
	     
	     int[] nums1 = new int[n];
	     int[] nums2 = new int[m];
	     
	     for(int i=0; i<n;i++) {
	         nums1[i] = sc.nextInt();
	      }
	      
	      for(int j=0; j<m; j++) {
	          nums2[j] = sc.nextInt();
	      }
         // function call here
         System.out.println(findUnion(nums1, nums2, n, m));
	 	}
	 }
}