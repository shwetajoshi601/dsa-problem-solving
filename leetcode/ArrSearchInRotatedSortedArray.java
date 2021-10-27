class ArrSearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        // number of times an array is rotated = index of min element
        // find the minimum element in the array using binary search
        int minIndex = findMin(nums);
        
        // now, the subarray from 0 to minIndex-1 is sorted
        // and the subarray from minIndex to n is sorted
        // use binary search in the subarrays to find the target
        int first = binarySearch(nums, target, 0, minIndex-1);
        
        int second = -1;
        // if not found, search in the second subarray
        if(first == -1)
            second = binarySearch(nums, target, minIndex, nums.length-1);
        else
            return first;
        
        return second;
    }
    
    int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high=nums.length-1;
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            int nextIndex = (mid+1)%n;
            int prevIndex = (mid+n-1)%n;
            
            if(nums[mid] <= nums[prevIndex] && nums[mid] <= nums[nextIndex])
                return mid;
            else if(nums[mid] <= nums[n-1])
                high = mid-1;
            else if(nums[mid] >= nums[0])
                low = mid+1;
        }
        
        return -1;
    }
    
    int binarySearch(int[] nums, int target, int low, int high) {
        while(low <= high) {
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                low = mid+1;
            else if(nums[mid] > target)
                high=mid-1;
        }
        
        return -1;
    }
}