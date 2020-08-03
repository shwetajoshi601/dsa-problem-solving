class Day3StrValidPalindrome {
    public boolean isPalindrome(String s) {
        // valid palindrome for empty string and single character
        if(s.length() == 0 || s.length() == 1)
            return true;
        
        // to compare characters from the beginning and end
        int i=0, j=s.length()-1;
        
        // ignore the case
        s = s.toLowerCase();
        
        // compare characters till they reach a common point
        while(i<=j) {
            // character at position i is not alphanumeric
            if(!(Character.isLetterOrDigit(s.charAt(i)))) {
                // move ahead to skip the character
                i++;
            } else if(!(Character.isLetterOrDigit(s.charAt(j)))) {
                // character at position j is not alphanumeric
                // move ahead and skip
                j--;
            } else if(s.charAt(i) != s.charAt(j))
                // both characters at i and j are valid
                // not a valid palindrome if the characters are not equal
                return false;
            else {
                // if the characters at i and j are equal just move the pointers
                i++;
                j--;
            }
        }
        
        // valid palindrome
        return true;
    }
}