class BuddyStrings {
    
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()) return false;
        
        // if the two strings are equal
        if(A.equals(B)) {
            int[] count = new int[26];
            
            // find the count of each character
            for(int i=0; i<A.length(); i++)
                count[A.charAt(i) - 'a']++;
            
            for(int cnt: count) {
                if(cnt > 1)
                    return true;
            }
            
            // if any character count is not greater than 1
            return false;
        } else {
            // unequal strings
            int first=-1, second=-1;
            
            for(int i=0; i<A.length(); i++) {
                // unequal characters found
                if(A.charAt(i) != B.charAt(i)) {
                    if(first == -1)
                        // index of first mismatch
                        first=i;
                    // index of second mismatch
                    else if(second == -1)
                        second=i;
                    else
                        // if two mismatches already occur, a third mismatch is not allowed
                        return false;
                }
            }
            
            // the characters at first and second index must be equal so that strings become equal after swapping
            return (A.charAt(first) == B.charAt(second) && A.charAt(second)==B.charAt(first));
        }
    }
}