class MaxSumSubarray {
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
}