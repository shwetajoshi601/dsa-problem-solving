class StrLongestSubstringNonRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        
        // char -> index
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        // start index of the longest substring
        int start = 0, maxLen = 0;
        
        for(int i=0; i< s.length(); i++) {
            // if the character is already present
            if(map.containsKey(s.charAt(i))) {
                // and the index is after the start
                if(map.get(s.charAt(i)) >= start)
                    // update the new start
                    // e.g. abca, here when a at index 3 is found, we update start to point to index 1, exclude the previous a. (sliding window)
                    start = map.get(s.charAt(i)) + 1;
            }
            // if not found, put the element and its index
            map.put(s.charAt(i), i);
            // max length is the current index - start index of the substring + 1
            maxLen = Math.max(maxLen, i-start+1);
        }
        
        return maxLen;
    }

    // similar approach - Aditya Verma's video for sliding window
    public int lengthOfLongestSubstring(String s) {
        // if(s.length() == 0) return 0;
        // if(s.length() == 1) return 1;
        
        // char -> freq
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        // start index of the longest substring
        int i = 0, maxLen = 0;
        
        for(int j=0; j<s.length(); j++) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            
            if(map.size() == j-i+1) {
                // all unique -> number of distinct chars in map = length of substr
                maxLen = Math.max(maxLen, j-i+1);
            } else if(map.size() < j-i+1) {
                // reduce the window size
                while(map.size() < j-i+1) {
                    int startCount = map.get(s.charAt(i));
                    map.put(s.charAt(i), --startCount);

                    if(map.get(s.charAt(i)) == 0)
                        map.remove(s.charAt(i));

                    i++;
                }
            }
        }
        
        return maxLen;
    }
}