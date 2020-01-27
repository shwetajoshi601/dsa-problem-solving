import java.util.*;

public class SingleNumberInArrayInPlace {
    public int singleNumber(int[] nums) {
        // sort the array
       Arrays.sort(nums);
        int singleNum = 0;
        for(int i=0; i< nums.length; i++) {
            
            // if its the last element
            // its the only one occuring once
            if(i == nums.length-1)
                return nums[i];
            
            // compare elements in pairs
            int curr = nums[i];
            int next = nums[i+1];
            
            // skip the second element of the first pair
            // move to the next pair
            if(curr == next)
                i++;
            else {
                // if any pair is not equal
                singleNum = nums[i];
                break;
            }
        }
        return singleNum;
    }
}