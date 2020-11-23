class ArrRemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        // since two duplicates are allowed, we can start from index 2
        // it does not matter what the first two elements are
        int i = 2;

        for(int j=2; j<nums.length; j++) {
            if(nums[i-2] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
        }
        
        return i;
    }
}