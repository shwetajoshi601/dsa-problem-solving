class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {
        int uniqueCount = 0;
        int j = 0;
        
        // for each element
        for(int i=0; i<nums.length-1 && j<nums.length-1; i++) {
            
            // current element
            int num = nums[i];

            // move ahead till the next different element
            while(j < nums.length-1 && num==nums[j])
                j++;
            
            // if the element is different
            if(nums[j] != num && j<nums.length) {
                
                // add it next to the current element
                nums[i+1] = nums[j];
                uniqueCount++;
            }
        }
        
        // add 1 since the iteration does not add the first element count
        // it adds the next unique element
        return uniqueCount+1;
    }

    // a simpler solution - O(n), O(1) space
    public int removeDuplicates(int[] nums) {
        // marks the current pos
        int i=0;
        
        // loop through to skip over the duplicates
        for(int j=1; j<nums.length; j++) {
            // when a new number is found
            if(nums[i] != nums[j]) {
                // i is at the previous number, so move one step ahead
                i++;
                // add the new unique number at the pos given by i
                nums[i] = nums[j];
            }
        }
        
        // return length
        return i+1;
    }
}