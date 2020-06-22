public class StrValidPalindrome2 {
    boolean isPalindrome(String s, int l,  int r) {
        // check if the string is a palindrome
        while(l++ < r--)
            if(s.charAt(l) != s.charAt(r)) return false;
        
        return true;
    }
    
    public boolean validPalindrome(String s) {
        // note this
        int l=-1, r=s.length();
        
        while(l++ < r--) {
            // if a character is a mismatch
            // ignore that character and check if the string is a palindrome
            // either the left character could be wrong -> change to l-1
            // or the right character could be wrong -> change to r+1
            if(s.charAt(l) != s.charAt(r)) return isPalindrome(s, l, r+1) || isPalindrome(s, l-1, r);
            }
        
        return true;
    }
}