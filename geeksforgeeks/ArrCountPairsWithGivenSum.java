// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class ArrCountPairsWithGivenSum {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().getPairsCount(arr, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        // map of frequencies
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int num: arr)
            map.put(num, map.getOrDefault(num, 0)+1);
        
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            int diff = k-arr[i];
            
            // elements with given sum exist
            if(map.containsKey(diff))
                // increment count by the frequency
                count+=map.get(diff);
                
            // this would also count elements which when added to themself will equal k
            // exclude such cases
            if(diff == arr[i])
                count--;
        }
        
        // for each pair, i,j we increment the counter when both i and j are found
        // this counts each pair twice, so divide by 2 to count them once
        return count/2;
    }
}
