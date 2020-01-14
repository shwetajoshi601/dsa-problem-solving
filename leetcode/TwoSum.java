class TwoSum {
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
}