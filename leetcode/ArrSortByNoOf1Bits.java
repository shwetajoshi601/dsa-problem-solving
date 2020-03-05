import java.util.*;

class ArrSortByNoOf1Bits {
    public int[] sortByBits(int[] arr) {

        Integer[] nums = new Integer[arr.length];
        
        // convert to array of objects
        for(int i=0; i<arr.length;i++) {
            nums[i] = arr[i];
        }
        
        // sort the array
        Arrays.sort(nums, new Comparator<Integer>() {
           public int compare(Integer num1, Integer num2) {
               
               // if bit counts are equal
               if(Integer.bitCount(num1) == Integer.bitCount(num2))
               {
                   // compare the numbers
                   if(Integer.valueOf(num1) < Integer.valueOf(num2))
                       return -1;
                   else if(Integer.valueOf(num1) > Integer.valueOf(num2))
                       return 1;
                   else
                       return 0;
               }
               
               // if bit counts are unequal
               // compare bitcounts
               return (Integer.bitCount(num1) - Integer.bitCount(num2));
               // return 0;
           }
        });
        
        // convert back to array of primitives
        for(int i=0; i<nums.length;i++)
            arr[i] = Integer.valueOf(nums[i]);
        
        return arr;
    }
}