import java.util.*;
import java.lang.*;
import java.io.*;
class StringReverseWords
 {
    static String reverse(String s) {
        String[] words = s.split("\\.");
        StringBuilder sb = new StringBuilder();

        for(int i=words.length-1; i>=0; i--) {
            sb.append(words[i]);
            if(i!=0)
                sb.append(".");
        }
        
        return sb.toString();
    }
     
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int t = Integer.parseInt(sc.nextLine());
	    
	    while(t-- >0) {
	        String s = sc.nextLine();
	        System.out.println(reverse(s));
	    }
	 }
}