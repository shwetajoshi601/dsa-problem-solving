// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        int K = pat.length();
        // count to store the distinct no. of characters
        int i = 0, count = 0, ans = 0;
        // map to store the characters in the pattern and their frequency
        // we store the frequencies of characters in the pattern first
        // then, as we traverse the string, we decrement the counts if the characters
        // are present
        // if the count becomes zero, it means an anagram was found
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c: pat.toCharArray()) {
            // add each char in the map
            map.put(c, map.getOrDefault(c, 0) + 1);
            // if its a new character, increment the count
            if(map.get(c) == 1)
                count++;
        }
        
        // traverse the string
        for(int j=0; j < txt.length(); j++) {
            int currLen = j - i + 1;
            char currChar = txt.charAt(j);
            
            // if the current char is present in the map
            // decrement its frequency
            if(map.containsKey(currChar)) {
                map.put(currChar, map.get(currChar)-1);
                // if the frequency becomes 0, the no. of distinct chars reduces
                if(map.get(currChar) == 0)
                    count--;
            }
            
            if(currLen == K) {
                // window size hit
                // if the count is zero, the window contains all characters
                // in the same number and frequency as the pattern
                // hence, an anagram is found
                if(count == 0)
                    ans++;
                    
                // slide the window
                // when we covered the first char, we did addition
                // now when we slide, we exclude the char at i
                // we need to undo the operations for i
                if(map.containsKey(txt.charAt(i))) {
                    // increment the frequency
                    map.put(txt.charAt(i), map.get(txt.charAt(i))+1);
                    // if it gets added as new char, then also increment the count
                    if(map.get(txt.charAt(i)) == 1)
                        count++;
                }
                // move ahead
                i++;
            }
        }
        
        return ans;
    }
}