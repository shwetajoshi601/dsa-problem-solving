class NextPermutation {
    public void nextPermutation(int[] nums) {
        // Intuition: to find a number next greater than the number given
        // you need to replace its small digit on the left (large places like 1000s, 100s) with the largest number from the right (units, 10s), its a permutation, this re-arrangement would give the next largest number
        
        if(nums.length ==0 || nums.length ==1)
            return;
        
        // 1. From the end, find a number such that it is lesser than the number after it
        int i=nums.length-2;
        // move backwards till a number smaller than next number is found
        while(i>=0 && nums[i]>=nums[i+1])
            i--;
        
        // 2. From the end, find a number that is greater than the number found in step 1
        int j=nums.length-1;
        // This condition is necessary if the sequence only increases or decreases - 12345, in this case swap is not necessary
        if(i>=0) {
            // move backwards till a number greater than nums[i] is found
            while(nums[j]<=nums[i])
                j--;
            // swap the numbers at i and j
            swap(nums, i, j);
        }
        // 3. Now reverse the numbers from i+1 till the end
        reverse(nums, i+1, nums.length-1);
    }
    
    // function to swap two numbers in the array
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    // function to reverse elements from a given start and end index
    void reverse(int[] nums, int i, int j) {
        while(i<=j) swap(nums, i++, j--);
    }
}