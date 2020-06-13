public class Day11ArrSortColors {
    public void sortColorsNaive(int[] nums) {
        int red_count=0, white_count=0, blue_count=0;
        
        // count the number of red, white and blue colors
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==0) red_count++;
            else if(nums[i] == 1) white_count++;
            else blue_count++;
        }
        
        int j=0;
        
        // over write the array according to the counts
        while(red_count-- > 0) {
            nums[j] = 0;
            j++;
        }
        
        while(white_count-- > 0) {
            nums[j] = 1;
            j++;
        }
        
        while(blue_count-- > 0) {
            nums[j] = 2;
            j++;
        }
    }

    // function to swap numbers
    void swap(int[] nums, int index1, int index2) {
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }
    
    public void sortColorsQuickSort(int[] nums) {
        int start=0, end=nums.length-1, curr=0;
        
        while(curr <= end) {
            // check the value
            // value 0
            if(nums[curr] == 0) {
                // swap values at left and current
                swap(nums, curr, start);
                // move right
                curr++;
                start++;
            }
            // value 2
            else if(nums[curr]==2) {
                // swap values at end and current
                swap(nums, curr, end);
                // move left
                end--;
                // do not move curr ahead since after swapping with end, a new number appears at that position which needs to be processed
            } else 
                // do nothing
                curr++;
        }
    }
}