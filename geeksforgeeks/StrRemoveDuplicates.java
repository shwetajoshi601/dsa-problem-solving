// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class StrRemoveDuplicates {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            
            Solution ob = new Solution();
            String result = ob.removeDups(s);
            
            System.out.println(result);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    // O(n) time, O(n) space solution
    String removeDups(String S) {
        // maintain a set for characters encountered
        Set<Character> set = new HashSet<Character>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<S.length();i++) {
            // if the set does not contain the current char
            if(!set.contains(S.charAt(i))) {
                // add to set
                set.add(S.charAt(i));
                // append to the string
                sb.append(S.charAt(i));
            }
            // ignore duplicates
        }
        
        return sb.toString();
    }
}