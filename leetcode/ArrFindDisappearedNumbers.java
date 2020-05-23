import java.util.*;

public class ArrFindDisappearedNumbers {
    // Approach-1: Using set
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();
        List<Integer> result=new ArrayList<Integer>();
        
        // add all elements from the array to a set
        for(int i=0; i<nums.length; i++)
            set.add(nums[i]);
        
        // for eahc number upto the length of the array
        for(int j=1; j<=nums.length; j++) {
            // check if it exists in the set
            if(!set.contains(j))
                // add to the result
                result.add(j);
        }
        
        return result;
    }

    // Approach-2: In place using negation as a marking mechanism for elements that are present
    public List<Integer> findDisappearedNumbersInPlace(int[] nums) {
        List<Integer> result=new ArrayList<Integer>();
        
        for(int i=0; i<nums.length; i++) {
            // check if the number at ith position is positive
            if(nums[Math.abs(nums[i])-1] > 0) {
                // negate the number
                // e.g.: if nums[0]=4, then change number at position 4 (index 3) to negative
                nums[Math.abs(nums[i])-1]= -nums[Math.abs(nums[i])-1];
            }
        }
        
        // at the end, collect the numbers that remain positive
        for(int j=0; j<nums.length;j++) {
            if(nums[j] > 0)
                result.add(j+1);
        }
        
        return result;
    }
}