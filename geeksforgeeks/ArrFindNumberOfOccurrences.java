// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class ArrFindNumberOfOccurrences {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // find the first and last occurrence
        // lastIndex - firstIndex +1 returns the count
        if(n == 0)
            return 0;
            
        int first = findFirstLastOccurrence(arr, x, true);
        
        if(first == -1)
            return 0;
            
        int last = findFirstLastOccurrence(arr, x, false);
        
        return (last-first)+1;
    }
    
    // using binary search
    int findFirstLastOccurrence(int[] arr, int x, boolean isFirst) {
        int low = 0, high = arr.length-1;
        int res = -1;
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(arr[mid] == x) {
                res = mid;
                // continue search on the left for first occurrence
                if(isFirst)
                    high = mid-1;
                else
                    low = mid+1;
            } else if(arr[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return res;
    } 
}