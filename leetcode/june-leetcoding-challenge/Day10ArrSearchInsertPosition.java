class Day10ArrSearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // if the array is empty
        // if the target value is less than the start range of the numbers
        if(nums.length==0 || target < nums[0]) return 0;
        
        // if the target is beyond the max element in the array
        if(target > nums[nums.length-1]) return nums.length;
        
        int low=0, high=nums.length-1;
        
        // binary search
        while(low < high) {
            int mid = (low+high)/2;
            // target found
            if(nums[mid] == target)
                return mid;
            // target greater than the mid element
            else if(target > nums[mid])
                // search right sub-array
                low=mid+1;
            else
                // search left sub-array
                high=mid;
        }
        
        // target not found
        return low;
    }
}