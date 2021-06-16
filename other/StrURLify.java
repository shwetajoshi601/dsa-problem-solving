import java.util.*;

public class StrURLify {
    
    static int countSpaces(char[] str, int trueLength) {
        int count = 0;
        
        for(int i=trueLength-1; i>=0; i--) {
            if(Character.isWhitespace(str[i]))
                count++;
        }
        
        return count;
    }
    
    static String URLify(String s, int n) {
        char[] str = s.toCharArray();
        
        // if no whitespaces in the string, return as it is
        // this is possible when the true length and the length of the string is the same
        if(str.length == n || s.length() == 0) return s;
        
        // the idea is to construct the string from the end
        
        // space count is necessary if the string contains more extra buffer than required
        // we need to identify where exactly to start writing.
        // if there are 2 spaces, we need 4 extra spaces (total 6 positions)
        // hence, the position where we start writing would be the length + 2*no. of extra spaces
        int spaceCount = countSpaces(str, n);
        int endIndex = n + spaceCount*2;
        
        // end of the string with extra space
        int j = endIndex;
        // traverse the actual string from end
        for(int i=n-1; i>=0 && j>=0; i--) {
            // if a whitespace is found
            if(Character.isWhitespace(str[i])) {
                // fill 3 places with %20
                str[--j] = '0';
                str[--j] = '2';
                str[--j] = '%';
            } else
               // otherwise fill the character as it is
                str[--j] = str[i];
        }
        
        // convert char array to string
        return new String(str);
    }
    
    public static void main(String args[]) {
        // int[] arr1 = {2, 5, 6, 8, 10, 2, 2};
        // int[] arr2 = {2, 5, 5, 8, 10, 5, 6};
        
        String s = "Mr John Smith         ";
        int trueLength = 13;
        // String s = "Hello";
        // int trueLength = 5;
        System.out.println(URLify(s, trueLength));
    }
}