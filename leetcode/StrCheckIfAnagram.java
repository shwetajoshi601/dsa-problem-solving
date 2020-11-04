class StrCheckIfAnagram {
    // O(nlogn) time, O(n) space
    public boolean isAnagram(String s, String t) {
        // sort the two strings
        // compare the sorted strings
        
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        
        return Arrays.equals(sArr, tArr);
    }

    // O(n) solution, O(n) space
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        // count the characters in the two strings
        int[] charCounts = new int[26];
        
        // increment the count for the character in s, decrement for t
        for(int i=0; i<s.length(); i++) {
            charCounts[s.charAt(i)-'a']++;
            charCounts[t.charAt(i)-'a']--;
        }
        
        // at the end, all the entries in the charCount array should be 0
        for(int i: charCounts) {
            if(i!=0) return false;
        }
        
        return true;
    }

    // Note: the above solution works only for ascii characters, to adapt to unicode characters
    // use hashmap instead of array. At the end iterate over map.valueSet() to search for non-zero entries.
}