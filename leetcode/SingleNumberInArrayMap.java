import java.util.*;

class SingleNumberInArrayMap {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int val=0;
        for(int i=0; i<nums.length; i++) {
            if(!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else
                map.put(nums[i], map.get(nums[i])+1);
        }
        
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            if(e.getValue() == 1) {
                val = e.getKey(); 
                break;
            }
        }
        return val;
    }
}