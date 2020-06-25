public class Day25FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        // Approach: https://keithschwarz.com/interesting/code/?dir=find-duplicate
        int slow=0;
        int fast=0;
        
        while(true) {
            slow=nums[slow];
            fast=nums[nums[fast]];
        
            if(slow == fast)
                break;
        }
        
        int finder=0;
        while(true) {
            slow=nums[slow];
            finder=nums[finder];
            
            if(slow == finder)
                break;

        }

        return slow;
    }
}