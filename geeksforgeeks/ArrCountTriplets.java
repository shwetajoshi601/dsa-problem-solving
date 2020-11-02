// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class ArrCountTriplets {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            int n = Integer.parseInt(read.readLine());
            String input[] = read.readLine().split(" ");
            
            int arr[] = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(input[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.countTriplet(arr, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    // O(N^2) solution
    int countTriplet(int arr[], int n) {
        if(n < 3) return 0;
        
        Arrays.sort(arr);
        
        int count = 0;
        for(int i=2; i<n; i++) {
            // current number is the target
            int target = arr[i];
            
            // use two pointers one at 0, and the other at i-1
            // numbers to the left at target can sum to target since the array is sorted
            int left=0, right=i-1;
            
            // iterate throught the left sub part
            while(left < right) {
                int currSum = arr[left] + arr[right];
                // found sum=target
                if(currSum == target) {
                    count++;
                    left++;
                    right--;
                // sum less than target, move right to add greater numbers
                } else if(currSum < target)
                    left++;
                // sum greater than target, move left to add smaller numbers
                else if(currSum > target)
                    right--;
            }
        }
        
        return count;
    }
}