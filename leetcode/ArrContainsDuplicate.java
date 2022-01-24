import java.util.*;

class ArrContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            if(e.getValue() > 1)
                return true;
        }
        
        return false;
    }


    // same complexity, but faster
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        
        for(int n: nums) {
            if(set.contains(n))
                return true;
            
            set.add(n);
        }
        
        return false;
    }
}