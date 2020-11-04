class Solution {
    public int removeElement(int[] nums, int val) {
        // keep two pointers, one to keep a track of the current position
        // the other one to loop over the elements
        int j=0;
        // traverse the elements
        for(int i=0; i<nums.length; i++) {
            // fill the current position when a number not equal to val is found
            if(nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
            // ignore the numbers equal to val and skip over
        }
        
        // return the current position
        return j;
    }
}