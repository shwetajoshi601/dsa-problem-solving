class ArrThreeSum {
    // O(N^2) time, O(1) space -> modifies the array
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // reduce the problem to a two sum problem.
        // sort the array
        Arrays.sort(nums);
        
        // since we check for 3 numbers, the last subarray should be of 3 numbers
        // which means i  should begin from the 3rd last number
        for(int i=0; i<nums.length-2; i++) {
            // if the curr number is equal to previous
            // move ahead
            // same number will not give a 0 sum
            if(i>0 && nums[i]==nums[i-1]) continue;
            
            // scan the array after i using two-pointer approach
            int l=i+1;
            int r = nums.length-1;
            
            while(l < r)  {
                // System.out.println("Inside while");
                // calculate sum (target=0) or if you consider two sum
                // target = -nums[i]
                int sum = nums[i] + nums[l] + nums[r];
                // found 0 sum
                if(sum == 0) {
                    Integer[] res = {nums[i], nums[l], nums[r]};
                    result.add(Arrays.asList(res));
                    // skip over the same numbers
                    while(l<r && nums[l]==nums[l+1]) l++;
                    while(l<r && nums[r]==nums[r-1]) r--;
                    l++;
                    r--;
                // sum less than target
                } else if(sum < 0)
                    // add a greater number (sorted array so greater nos on the right)
                    l++;
                else
                // sum greater than target
                // move left
                    r--;
            }
        }
        
        return result;
    }
}