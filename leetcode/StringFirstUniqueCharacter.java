import java.util.*;

public class StringFirstUniqueCharacter {
        public int firstUniqChar(String s) {
            Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
            Map<Character, Integer> indexMap = new HashMap<Character, Integer>();
            
            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0)+1);
                
                if(!indexMap.containsKey(c))
                    indexMap.put(c, i);
            }
            
            for(Map.Entry<Character, Integer> e: map.entrySet()) {
                if(e.getValue() == 1)
                    return indexMap.get(e.getKey()).intValue();
            }
            
            return -1;
        }
}
