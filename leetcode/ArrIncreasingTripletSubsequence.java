class ArrIncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {

        if(nums.length==0) return false;
        
        // triplet -> maintain to minimum values
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length; i++) {
            // get the current minimum
            min1 = Math.min(nums[i], min1);
            // if current number is greater than first min
            // it is min2
            if(nums[i] > min1)
                min2 = Math.min(nums[i], min2);
            // if current number is greater than min2
            // sequence completes
            if(nums[i] > min2)
                return true;
        }

        return false;
    }
}