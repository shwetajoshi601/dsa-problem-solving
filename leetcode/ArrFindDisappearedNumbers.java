import java.util.*;

public class ArrFindDisappearedNumbers {
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
}