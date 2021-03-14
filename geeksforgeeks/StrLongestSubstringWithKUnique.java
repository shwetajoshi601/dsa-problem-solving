import java.util.*;
import java.lang.*;
import java.io.*;

class StrLongestSubstringWithKUnique {
    static int getLongestSubstringWithKUniqueLength(String s, int k) {

        if (k > s.length()) return -1;
        // array to store frequency counts of characters
        int charSetSize = 128;
        int[] freq = new int[charSetSize];

        // hash set to store the distinct characters
        Set < Character > set = new HashSet < Character > ();

        // maximum length of the substring
        int maxLen = Integer.MIN_VALUE;

        for (int low = 0, high = 0; high < s.length(); high++) {
            // add the current character into the set
            set.add(s.charAt(high));
            // increment the character's frequency count
            freq[s.charAt(high)]++;

            // if the size of the set becomes greater than k
            // remove elements from the beginning
            if (set.size() > k) {
                // decrement the frequency of the character in the freq count array
                // after decrementing if it becomes 0
                // completely remove the character from the set
                if (--freq[s.charAt(low)] == 0)
                    set.remove(s.charAt(low));

                low++;
            }

            // check the maxLen and update if current max length is greater
            if (high - low > maxLen)
                maxLen = (high - low);
        }

        // add 1 - zero based indexing
        return maxLen + 1;
    }

    // O(n) - sliding window variable length, according to Aditya Verma
    public int longestkSubstr(String s, int k) {
        // map to store chars -> frequency counts
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = -1;
        
        int i=0;
        
        for(int j=0; j<s.length(); j++) {
            // add the character to the map
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
            
            // size of the map gives us the number of unique characters
            // check if it equals k
            if(map.size() == k) {
                // potential candidate
                // update the max length if its > than current length
                max = Math.max(max, j-i+1);
            } else if(map.size() > k) {
                // exceeds the required number
                // remove elements
                // move the window, hence move elements at pos i
                while(i <= j && map.size() > k) {
                    if(map.containsKey(s.charAt(i))) {
                        int freq = map.get(s.charAt(i));
                        // pre-increment is important here
                        map.put(s.charAt(i), --freq);
            
                        // now if the count becomes 0
                        // remove the element from the map
                        if(map.get(s.charAt(i)) == 0)
                            map.remove(s.charAt(i));
                    }
                    i++;
                    
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            int k = Integer.parseInt(br.readLine());

            int result = getLongestSubstringWithKUniqueLength(s, k);
            System.out.println(result);
        }
    }
}