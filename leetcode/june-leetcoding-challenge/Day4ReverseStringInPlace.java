public class Day4ReverseStringInPlace {
    public void reverseString(char[] s) {
        if(s.length==0 || s.length == 1) return;
        
        // start
        int i=0;
        // end
        int j=s.length-1;
        
        // swap characters from the start and end
        // till the mid is reached
        while(i<=j) {
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            
            i++;
            j--;
        }
    }
}