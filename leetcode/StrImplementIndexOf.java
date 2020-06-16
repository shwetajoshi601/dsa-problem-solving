public class StrImplementIndexOf {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        
        int m=haystack.length();
        int n=needle.length();
        
        // if needle is larger than haystack it cannot be contained in haystack
        if(m < n) return -1;
        
        // haystack
        // start index of needle in haystack would at the most be m-n
        // e.g. llo would always begin at 3 positions before the end of hello
        for(int i=0; i<m-n; i++) {
            // needle
            int j;
            // match each character from needle when a matching character is found
            for(j=0; j<n; j++) {
                // i+j gives the next character in haystack
                // index of l-> 2, index of l in needle -> 0 i+j=2
                if(haystack.charAt(i+j) != needle.charAt(j))
                    break;
            }
            
            // if the inner loop breaks after processing the entire needle string
            // j is at index equal to the length of needle
            if(j==n)
                return i;
        }
        
        // no match found
        return -1;
    }
}