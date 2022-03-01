// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class RecursionGenerateBalancedParentheses{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        List<String> parentheses = new ArrayList<String>();
        
        String output = "";
        getParentheses(n, n, output, parentheses);
        
        return parentheses;
    }
    
    void getParentheses(int open, int close, String output, List<String> result) {
        // open = close = n initially
        // we need these two variables to keep a track of 
        // the open and close brackets remaining
        
        if(open == 0 && close == 0) {
            // when all the brackets are used
            // the output string contains a balanced parenthesis
            result.add(output);
            return;
        }
        
        // for filling each position in the string
        // we have two possible choices -> either use an open bracket
        // or use a close bracket
        // but we need to make sure we are forming balanced parenthesis
        // if an open bracket is available, we do have this choice
        if(open != 0) {
            // append the open bracket
            String output1 = output;
            output1+="(";
            getParentheses(open-1, close, output1, result);
        }
        
        // when close > open, we can use a close bracket
        // e.g. n=3, output = (() -> balance open=1, close=2
        if(close > open) {
            String output2 = output;
            output2+=")";
            getParentheses(open, close-1, output2, result);
        }
    }
}