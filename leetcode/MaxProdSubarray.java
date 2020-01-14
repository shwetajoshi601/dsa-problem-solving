class MaxProdSubarray {
    public int maxProduct(int[] nums) {
        // for arr len 0 and 1
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int max=Integer.MIN_VALUE;
        // left border of the window
        for(int i=0; i< nums.length; i++) {
            int prod=nums[i];
            // if the element itself is large
            max = Math.max(prod, max);
            //right of the window
            for(int j=i+1; j<nums.length;j++) {
                // multiply adjacent elements
                prod*=nums[j];
                max = Math.max(nums[j], Math.max(prod, max));
            }
        }
        return max;
    }
}