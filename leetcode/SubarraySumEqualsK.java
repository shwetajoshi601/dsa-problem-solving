import java.util.*;

class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {

        // maintain frequency of sum
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int sum=0, count=0;
        map.put(0, 1);
        
        for(int i=0; i<nums.length; i++) {
            // cumulative sum
            sum+=nums[i];
 
            // if the cumulative sum upto two indices, say ii and jj is at a difference of kk i.e. if sum[i] - sum[j] = ksum[i]−sum[j]=k, the sum of elements lying between indices ii and jj is kk.
            if(map.containsKey(sum-k))
                count+=map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}