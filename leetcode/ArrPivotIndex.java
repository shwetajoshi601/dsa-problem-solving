class ArrPivotIndex {
    // O(n) / O(1)
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        
        // calculate the total sum
        for(int i=0; i<nums.length; i++)
            totalSum+=nums[i];
        
        // iterate through the array and keep track of the left and right sum
        int leftSum = 0, rightSum = totalSum;
        
        for(int i=0; i<nums.length; i++) {
            // at each step, add an element to the left sum
            if(i != 0)
                leftSum = leftSum + nums[i-1];
            
            // remove the current element from the right sum
            rightSum = rightSum - nums[i];
            
            // check if both are equal
            if(leftSum == rightSum)
                return i;
        }
        
        // equal left and right sum not found
        return -1;
    }
}