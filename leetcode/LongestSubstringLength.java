class LongestSubstringLength {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int max_len = 0, left=0, right=0; // to maintain substring window
        
        while(right < s.length()) {
            // if the character is not present in the set
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                // increment right boundary
                right++;
                // right -left = length of the window
                max_len = Math.max(right - left, max_len);
            } else {
                // remove to begin another substring
                if(s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                } else {
                    left++;
                    right++;
                }
            }
        }
        
        return max_len;
    }
}