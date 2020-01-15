class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        if(nums.length ==0 || nums.length==1)
            return true;
        
        // the current greater element and smaller element
        int greater=nums[0], smaller=nums[nums.length-1];
        int greaterCnt=0, smallerCnt=0;
        int i=0, j=nums.length-1;
        
        // start i from beg, j from the end
        // as i goes ahead, each element must be > than the prev
        // as j decreases, each element must be < than the prev
        
        while(i<nums.length && j>=0) {
            
            // if current element is larger than th prev greater
            if(nums[i] >= greater)
                //set greater to this current elem
                greater=nums[i];
            else
                // if not, the elements arent in ascending order
                greaterCnt++;
            
            // if current element is smaller than the prev elem
            if(nums[j] <= smaller)
                // set current element as smaller
                smaller=nums[j];
            else
                smallerCnt++;
            
            i++;
            j--;
        }
        
        // max count is the minimum of swap counts
        return Math.min(greaterCnt, smallerCnt) <= 1;
    }
} 