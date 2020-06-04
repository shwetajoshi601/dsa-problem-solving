import java.util.*;

public class ArrMinSubsequenceNonIncreasing {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        
        if(nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
 
        int totSum=0;
        int curSum=0;
        
        // find the sum of all the elements in array
        for(int n: nums)
            totSum+=n;
        
        int tot=totSum;
        System.out.println(totSum);
        // sort the array
        Arrays.sort(nums);
        
        // iterate in reverse -> from the maximum element
        for(int i=nums.length-1; i>=0; i--) {
            // add the current element to the result
            res.add(nums[i]);
            
            // sum of elements iterated so far - part of subsequence
            curSum+=nums[i];
            System.out.println(curSum);
            // sum of all other elements - not part of the sequence
            tot = totSum-curSum;
            System.out.println(tot);
            // totSum will contain sum of remaining elements
            // currSum -> sum of elements in subsequence
            if(curSum > tot)
                break;
        }
        
        return res;
    }
}