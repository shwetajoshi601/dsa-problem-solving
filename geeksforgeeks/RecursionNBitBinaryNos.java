// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class RecursionNBitBinaryNos {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<String> NBitBinary(int N) {
        ArrayList<String> numbers = new ArrayList<String>();
        String output = "";
        
        getBinaryNos(N, 0, 0, output, numbers);
        
        return numbers;
    }
    
    void getBinaryNos(int N, int ones, int zeroes, String output, ArrayList<String> numbers) {
        // if all places in N bit string have been filled
        if(N == 0) {
            numbers.add(output);
            return;
        }
        
        // we always have a choice of adding 1 to the output
        String out1 = output;
        out1+="1";
        getBinaryNos(N-1, ones+1, zeroes, out1, numbers);
        
        // we can only add a zero if we have used more ones than zeroes
        if(ones > zeroes) {
            String out2 = output;
            out2+="0";
            getBinaryNos(N-1, ones, zeroes+1, out2, numbers);
        }
    }
}