class FindEvenDigits {
    public int findNumbers(int[] nums) {
        
        if(nums.length == 0) return 0;
        
        // for numbers with even no of digits
        int tot=0;

        for(int i=0; i<nums.length; i++) {
            int digit_count=0;
            int num = nums[i];
            
            // divide the number to find no of digits
            while(num!=0) {
                digit_count++;
                num=num/10;
            }
            
            // if even no of digits
            if(digit_count%2 == 0)
                tot++;
        }
        
        return tot;
    }
}