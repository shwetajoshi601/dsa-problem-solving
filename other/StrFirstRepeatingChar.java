import java.util.*;

public class StrFindFirstRepeatingChar {
    
    static char findFirstRepeating(String s) {
       Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
       
       for(int i=0; i<s.length(); i++) {
           char c = s.charAt(i);
           
        //   map.put(c, map.getOrDefault(c, 0)+1);
        if(map.containsKey(c)) {
            int freq = map.get(c) + 1;
            if(freq > 1)
                return c;
        } else
            map.put(c, 1);
       }
       
       return '$';
    } 
    
    public static void main(String args[]) {
        String s = "hello geek!";
        System.out.println(findFirstRepeating(s));
    }
}