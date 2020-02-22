class FirstAndLastPositionOfElemArr {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        
        // start i from the beginning, j from the end of the array
        int i=0, j=nums.length-1;
        
        // empty array
        if(nums.length==0)
            return res;
        
        // increment i till target is found
        while(i<j && nums[i] != target)
            i++;
        
        // if i reached the end of the array and the last element is not the target
        // the target does not exist in the array
        if(i==j && nums[i]!=target)
            return res;
        
        // move backwards till the target is found
        while(nums[j]!=target)
            j--;
        
        // i-beginning of the target, j-end of the target range
        res[0]=i;
        res[1]=j;
        
        return res;
    }
}