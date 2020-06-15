import java.util.*;

class ArrTwoSum {
    public int[] twoSum(int[] nums, int target) {
        // map<value, index>
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = {0, 0};
        // create a hashmap of elements with their indices
        for(int i=0; i < nums.length; i++)
            map.put(nums[i], i);
        
        for(int i=0; i<nums.length;i++) {
            int elem = target - nums[i];
            // check if the second element that completes the sum exists in the map
            // since no element can be used twice
            // ensure their indices are different
            if(map.containsKey(elem) && map.get(elem)!= i) {
                // if such an element exists
                result[0] = i; // index of the first element
                result[1] = map.get(elem); // index of the second result element
                break;
            }
        }
        return result;
    }

    public int[] twoSumSingleLoop(int[] nums, int target) {
        int[] res={-1, -1};
        
        if(nums.length == 0) return res;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums.length; i++) {
            // a+b=target, a=target-b
            int num2=target-nums[i];
            // if the second element of the pair is present
            // also check if it is not the same element, e.g. [3,2,4], target=6 -> map.get would return index of 3 for element 3
            if(map.containsKey(num2) && map.get(num2) != i) {
                res[0] = i;
                res[1] = map.get(num2);
                break;
            }

            map.put(nums[i], i);
        }
        
        return res;
    }
}