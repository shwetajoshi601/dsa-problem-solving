class ArrFirstAndLastOccurrence {
    // Brute Force
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

    // Using Binary Search - O(log n)
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        
        if(nums.length == 0)
            return res;
        
        // find the first occurrence
        int first = findFirstOccurrence(nums, target);
        // if the first occurrence is not found
        // it means the element is not present in the array
        if(first == -1)
            return res;
        
        res[0] = first;
        
        // find the last occurrence
        int last = findLastOccurrence(nums, target);
        res[1] = last;
        
        return res;
    }
    
    int findFirstOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int res = -1;
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            // continue searching to the left
            if(nums[mid] == target) {
                res = mid;
                high = mid-1;
            } else if(nums[mid] < target)
                low = mid+1;
            else
                high = mid-1;
        }
        
        return res;
    }
    
    int findLastOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int res = -1;
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            // continue searching to the right
            if(nums[mid] == target) {
                res = mid;
                low = mid+1;
            } else if(nums[mid] < target)
                low = mid+1;
            else
                high = mid-1;
        }
        
        return res;
    }

    // Binary Search - better way of doing it
    
    // the two methods for findFirst and findLast can be combined into a single method and be passed a boolean variable
    int findFirstLastOccurrence(int[] nums, int target, boolean first) {
        int low = 0, high = nums.length-1;
        int res = -1;
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            // continue searching to the left or right based on which occurrence is to be found
            if(nums[mid] == target) {
                res = mid;
                // if finding first occurrence, change high
                if(first)
                    high = mid-1;
                else
                // last occurrence
                    low = mid+1;
            } else if(nums[mid] < target)
                low = mid+1;
            else
                high = mid-1;
        }
        
        return res;
    }
}