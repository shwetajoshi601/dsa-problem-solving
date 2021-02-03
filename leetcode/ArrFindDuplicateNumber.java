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

    // Soln 2: Using Swap Sort - we know that in the range 1 to N, there is only 1 repeated number
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int findDuplicateSwapSort(int[] nums) {
        int i = 0;
        
        // element at pos 0 is 1, at pos 1 is 2, hence swap the elements if they are not in their right pos
        while(i<nums.length) {
            if(nums[i] != nums[nums[i]-1])
                swap(nums, i, nums[i]-1);
            else
                i++;
        }
        
        // now check if all elems are in their correct position
        // the one in incorrect position is the repeated number
        int rep = -1;
        for(i=0; i<nums.length; i++) {
            if(nums[i] != i+1) {
                rep = nums[i];
                break;
            }
        }
        
        return rep;
    }
}