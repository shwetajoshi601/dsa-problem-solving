import java.util.*;

class StrRansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        // count the frequencies of each character in magazine
        for(int i=0; i< magazine.length(); i++)
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0)+1);
        
        // iterate over the ransomNote
        for(int j=0; j< ransomNote.length(); j++) {
            
            // if magazine contains the character
            if(map.containsKey(ransomNote.charAt(j))) {
                
                // check how many occurrences are available, if its zero, this character is not allowed
                if(map.get(ransomNote.charAt(j)) == 0)
                    return false;
                else
                    
                    // reduce the allowed occurrences of this character by 1
                    map.put(ransomNote.charAt(j), map.get(ransomNote.charAt(j)).intValue()-1);
            } else
                // if character is not present
                return false;
        }
        
        // sequence allowed
        return true;
    }
}