import java.util.*;
import java.lang.*;
import java.io.*;

class StrLongestPalindrome
 {
    static String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        
        char[] sArr = s.toCharArray();
        // keep track of the max length of palindrome
        int max = 0;
        // note the start and end index of the max palindrome
        int start=0, end=0;
        
        // iterate over the array
        for(int i=0; i<sArr.length; i++) {
            for(int j=i; j<sArr.length; j++) {
                // for each (i, j) check if the string s[i] -> a[j] is a palindrome
                if(isPalindrome(sArr, i, j)) {
                    // check if the length is greater than max so far
                    // add 1 since it is 0 based indexing
                    if((j-i+1) > max) {
                        // store the max, start and end
                        max = j-i+1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        // System.out.println("max: " + max + "\nstart: " + start + "\nend: " + end);
        
        // create a copy of the sub array and convert to string
        return String.valueOf(Arrays.copyOfRange(sArr, start, end+1));
    }
    
    // function to check if the subarray is a palindrome
    static boolean isPalindrome(char[] s, int i, int j) {
        while(i<=j) {
            if(s[i] != s[j]) return false;
            i++;
            j--;
        }
        
        return true;
    }
    
	public static void main (String[] args)
	 {
	 //code
	 Scanner sc = new Scanner(System.in);
	 int t = sc.nextInt();
	 sc.nextLine();
	 
	 while(t-- > 0) {
	    String s = sc.nextLine().trim();
         // function call here
         System.out.println(longestPalindrome(s));
	 	}
	 }
}