import java.util.*;

public class ArrIntersectionOfTwoArrays {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
            Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
            
            ArrayList<Integer> res = new ArrayList<Integer>();
            
            // count the number of elements in both the arrays
            for(int n: nums1)
                map1.put(n, map1.getOrDefault(n, 0)+1);
            
            for(int n2: nums2)
                map2.put(n2, map2.getOrDefault(n2, 0)+1);
            
            // now check for common elements
            for(Map.Entry<Integer, Integer> e: map1.entrySet()) {
                if(map2.containsKey(e.getKey())) {
                    // common element found
                    // get the min frequency - intersection
                    int freq = Math.min(e.getValue(), map2.get(e.getKey()));
                    
                    // add the element freq times into the result
                    while(freq-- > 0) {
                        res.add(e.getKey());            
                    }
                }
            }
            
            // convert the arraylist to int
            int[] resp = new int[res.size()];
            
            for(int i=0; i<res.size(); i++)
                resp[i] = res.get(i);
            
            return resp;
        }
}
