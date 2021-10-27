// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class ArrNumberOfTimesSortedArrayIsRotated {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int findKRotation(int arr[], int n) {
        // if we observe carefully
        // no. of rotations = index of min element in the array
        // hence we need to find the index of the min element
        
        int low = 0, high = n-1;
        // find the min element using binary search
        while(low <= high) {
            int mid = low + (high-low)/2;
            int nextIndex = (mid+1)%n; // avoid overflow
            int prevIndex = (mid+n-1)%n; // if mid=0, n=5, 0-1 is -ve. Hence 0+5-1 = 4 (last index)
            // an element is minimum if it is smaller than both its prev and next element
            if(arr[mid] <= arr[prevIndex] && arr[mid] <= arr[nextIndex])
                return mid;
            // if its not a min element
            // we need to search the space that might contain the min element
            // if you observe, the min element is always in the unsorted subarray
            // so change the index accordingly
            else if(arr[mid] >= arr[0])
            // this means the first half is sorted, so search in the next half
                low = mid+1;
            else if(arr[mid] <= arr[n-1])
            // second half sorted, search in the first half
                high = mid-1;
        }
        
        return 0;
    }
}