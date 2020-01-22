class MoveZeroes {
    public void moveZeroes(int[] nums) {
        
        // maintain the next index of non zero element
        int order = 0;
        
        for(int i=0;i<nums.length;i++) {
            
            // for non zero elements
            if(nums[i] != 0) {
                int curr = nums[i];
                // change the value at that position to 0
                nums[i] = 0;
                // put the element at the next non zero position
                nums[order] = curr;
                // increment the index
                order++;
            }
        }
        // all non zero elements will be at the beginning
        // followed by zero elements
    }
}