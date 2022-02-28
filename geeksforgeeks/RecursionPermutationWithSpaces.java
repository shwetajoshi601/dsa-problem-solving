// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class RecursionPermutationWithSpaces
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine().trim();
            Solution ob = new Solution();
            ArrayList<String> ans = new ArrayList<String>();
            ans = ob.permutation(S);
            
            for(int i=0;i<ans.size();i++){
                System.out.print("("+ans.get(i)+")");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution{
    
    ArrayList<String> permutation(String S){
        ArrayList<String> permutations = new ArrayList<String>();
        
        if(S.length() == 0)
            return permutations;
        
        // we do not add space before the first character of the string
        // which means there is only one choice at this stage
        // so we do this in advance and then pass on to the recursive function
        String output = "";
        // add the first char as it is
        output+=S.charAt(0);
        // remove from the input - make input smaller
        String input = S.substring(1);
        
        getPermutations(input, output, permutations);
        
        return permutations;
    }
    
    void getPermutations(String input, String output, ArrayList<String> result) {
        if(input.length() == 0) {
            // no more input
            result.add(output);
            return;
        }
        
        // two possible outcomes
        String output1 = output;
        String output2 = output;
        
        // one with a space before it
        output1+=" ";
        output1+=input.charAt(0);
        // one without a space
        output2+=input.charAt(0);
        
        // remove the character from the input
        input = input.substring(1);
        
        // recursively call with the two outputs
        getPermutations(input, output1, result);
        getPermutations(input, output2, result);
    }
}