class ArrMissingNumber {
    // time - O(n), space - O(n)
    public int missingNumber(int[] nums) {
        // the array nums contains n-1 elements
        // e.g: range [0, 5] -> expected nums 0,1,2,3,4,5 -> 6 nums
        // but the given array contains only 5 nums
        
        // note: swap sort cannot be used here, since the elements do not repeat
        
        // add the elements from the array to a set
        Set<Integer> set = new HashSet<Integer>();
        for(int i: nums) set.add(i);
        
        // for range 0->n, the array contains only n elements, where the expected elements are n+1
        int expectedNums = nums.length + 1;
        // for each number in the range, check if it is present in the set
        for(int i=0; i<expectedNums; i++) {
            if(!set.contains(i))
                // missing number
                return i;
        }
        
        return -1;
    }

    // time O(n), space - O(1)
    public int missingNumberWithoutExtraSpace(int[] nums) {
        // the array nums contains n-1 elements
        // e.g: range [0, 5] -> expected nums 0,1,2,3,4,5 -> 6 nums
        // but the given array contains only 5 nums
        
        // note: swap sort cannot be used here, since the elements do not repeat
        
        // use the formula for sum of first n numbers - n(n+1)/2
        int expectedSum = nums.length*(nums.length+1)/2;
        int sum = 0;
        
        for(int i=0; i<nums.length; i++) sum+=nums[i];
        
        return expectedSum-sum;
    }
}