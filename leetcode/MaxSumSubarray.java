class MaxSumSubarray {
    // very naive solution
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int max=Integer.MIN_VALUE;
        
        for(int i=0; i< nums.length; i++) {
            int sum=nums[i];
            if(sum > max) max = sum;
            for(int j=i+1; j<nums.length;j++) {
                if(nums[j] > max) max = nums[j];
                sum+=nums[j];
                if(sum > max)
                    max = sum;
            }
        }
        return max;
    }

    // normal brute force solution
    public int maxSubArrayBruteForce(int[] nums) {
        int max = Integer.MIN_VALUE;
        // check for all sub-arrays
        for(int i=0; i<nums.length; i++) {
            int sum = 0;
            for(int j=i; j<nums.length; j++) {
                // add to sum
                sum = sum+nums[j];
                // update max if sum > max
                max = Math.max(sum, max);
            }
        }
        
        return max;
    }

    // O(n) time optimal solution
    public int maxSubArrayKadanesAlgorithm(int[] nums) {
        int max = Integer.MIN_VALUE;
        // using Kadane's algorithm
        // Using this algo, we carry forward the sum only if it is positive
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            // add the value to sum
            sum+=nums[i];
            // update max if sum > max
            if(sum > max) max = sum;
            // if sum becomes negative, make it 0
            // this would mark the beginning of a new sub array
            if(sum < 0) sum = 0;
        }
        
        return max;
    }


}