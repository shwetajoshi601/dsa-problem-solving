class ArrMajorityElement {
    // Using HashMap - O(N) time, O(N) space
    public int majorityElement(int[] nums) {
        int n = nums.length;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        // create a map of elements - frequency
        for(int i=0; i<nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        
        // iterate over the map
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            // check if the frequency is > n/2
            if(e.getValue() > n/2)
                // return the value
                return e.getKey().intValue();
        }
        
        return -1;
    }

    // Optimal - O(N) time, O(1) space
    public int majorityElementMooresVoting(int[] nums) {
        // Using Moore's Voting Algorithm
        // maintain a count and candidate for majority element
        int count=0, candidate=0;
        
        // the intuition is that - whenever the count is 0, the majority element gets cancelled by the minority element
        // in the last sub section of the array, the majority element remains as it does not get cancelled
        // [2,2,1,1,1,2,2] -> here the count becomes 0 at index 3 ([2,2,1,1]) and then at index 5 ([1,2])
        // observe: 2 occurs twice and 1 occurs twice too, so canceled.
        // Now in the last section -> [2,2] -> only 2 remains as there is nothing to cancel it with
        // iterate over each number
        for(int n: nums) {
            // set the new candidate if count is 0
            if(count == 0)
                candidate=n;
            // if number is equal to the candidate increment count
            if(candidate == n)
                count+=1;
            // decrement otherwise
            else
                count-=1;
        }
        
        return candidate;
    }
}