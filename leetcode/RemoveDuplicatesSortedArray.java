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
}