import java.util.*;

public class StrOneAway {
    
    static boolean isOneAway(char[] s1, char[] s2) {
        // if lengths are unequal, edit distance is > 1
      if(Math.abs(s1.length - s2.length) > 1) return false;
      
      char[] l = null;
      char[] s = null;
      
      // find the larger and smaller string
      if(s1.length >= s2.length) {
          l = s1;
          s = s2;
      } else {
          l = s2;
          s = s1;
      }
      
      int editDistance = 0;
      int i = 0, j = 0;
      while(i<l.length && j<s.length) {
          // if unequal characters are found
        if(l[i] != s[j]) {
            // if lengths are equal then just move ahead -> pale, bale
            if(l.length == s.length) {
                i++;
                j++;
            } else
            // if lengths are unequal, then skip over that character in the larger string
            i++;
            // increment the edit distance
            editDistance++;
        } else {
            // equal characters
            // move ahead
            i++;
            j++;
        }
        
        // at any point if the edit distance is > 1, then return false
        if(editDistance > 1) return false;
      }
      
      // return based on edit distance
      return editDistance < 2;
    }
    
    public static void main(String args[]) {
        // String s1 = "pale", s2 = "ple";
        // String s1 = "pales", s2 = "pale";
        // String s1 = "pale", s2 = "bale";
        String s1 = "pale", s2 = "bake";
        
        System.out.println(isOneAway(s1.toCharArray(), s2.toCharArray()));
    }
}