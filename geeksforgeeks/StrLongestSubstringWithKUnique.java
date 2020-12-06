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