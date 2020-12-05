// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class StrFindFirstNonRepeatingChar
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Repeatation().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Repeatation
{
    static char nonrepeatingCharacter(String S)
    {
        // create a linkedHashMap
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();

        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
            
        // iterate over the map and check for a character with frequency 1
        for(Map.Entry<Character, Integer> e: map.entrySet()) {
            if(e.getValue() == 1)
                return e.getKey();
        }
        
        return '$';
    }
}

