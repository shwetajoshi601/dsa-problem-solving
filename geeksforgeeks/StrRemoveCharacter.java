// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String string1 = read.readLine();
            String string2 = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.removeChars(string1,string2) );
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static String removeChars(String string1, String string2){
        // code here
        Set<Character> set = new HashSet<Character>();
        
        for(int i=0; i<string2.length(); i++)
        {
            char c = string2.charAt(i);
            set.add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<string1.length();j++) {
            char ch = string1.charAt(j);
            if(!set.contains(ch)) 
                sb.append(ch);
        }
        
        return sb.toString();
    }
}