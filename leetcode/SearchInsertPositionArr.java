class SearchInsertPositionArr {
    public int searchInsert(int[] nums, int target) {
        int index=0;
        int i=0;
        for(; i<nums.length; i++) {
            if(nums[i] == target || nums[i] > target) {
                index=i;
                break;
            }
        }
        
        if(i == nums.length && target > nums[i-1])
            index = i;
        
        return index;
    }
}