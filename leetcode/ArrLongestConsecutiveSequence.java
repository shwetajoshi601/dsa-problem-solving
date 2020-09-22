class ArrLongestConsecutiveSequence {
    // O(nlogn) - Using sorting, O(1) space
    public int longestConsecutive(int[] nums) {
        int maxLen=0, currLen=0;
        // sort the array
        Arrays.sort(nums);
        
        if(nums.length == 0 || nums.length==1) return nums.length;
        
        // iterate over the array from index 1
        for(int i=1; i<nums.length; i++) {
            // if the number is equal to the previous, just move ahead
            // e.g. [1,2,0, 1] -> sort -> [0,1,1,2] here, length of longest consecutive sequence is 3 
            // -> 0,1,2
            if(nums[i] == nums[i-1]) continue;
            // to chech consecutive the difference in previous and current number should be 1
            if(nums[i] == nums[i-1]+1) {
                // increment length
                currLen++;
                // set the max len so far
                maxLen = Math.max(maxLen, currLen);
            }
            else
                // if difference is not 1, the sequence breaks, set the length to 0
                currLen=0;
        }
        
        // since we check difference, the count is 1 less
        // so add 1 to return the correct count of elements
        return maxLen+1;
    }

    // O(n) solution using HashSet (O(n) space)
    public int longestConsecutiveUsingSet(int[] nums) {
        int maxLen=0;
        
        Set<Integer> set = new HashSet<Integer>();
        
        // create a set of all numbers
        for(int num: nums)
            set.add(num);
        
        for(int num: set) {
            // start from the smallest element in the sequence
            // e.g. 3214 -> num=3, but its a part of the sequence 1234, so skip it, it will be counted starting from 1
            if(!set.contains(num-1)) {
                // set the current number and length
                int currNum = num;
                int currLen = 1;
                
                // check if consecutive elements are present
                while(set.contains(currNum+1)) {
                    // if yes, increment
                    currNum++;
                    currLen++;
                }
                
                // once the sequence breaks, set the max length
                maxLen = Math.max(maxLen, currLen);
            }
        }
        
        return maxLen;
    }
}