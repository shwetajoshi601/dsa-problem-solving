class ArrFindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if(nums.length == 0) return 0;
        // if there is only one duplicate element, a cycle can be formed from the elements
        
        // first element
        int slow = nums[0];
        int fast = nums[0];
        
        // move a slow pointer and fast pointer
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        
        // start one of them from the beginning
        slow = nums[0];
        
        // move both at the same speed
        while(slow != fast) {
            // the point where they meet is the duplicate element
            slow = nums[slow];
            fast = nums[fast];
        }
        
        // return the element
        return slow;
    }
}