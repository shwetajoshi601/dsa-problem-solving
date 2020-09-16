class ArrTwoSumII {
    // O(N) solution - same as original Two Sum, O(N) space
    public int[] twoSum(int[] numbers, int target) {
        int[] res = {-1,-1};
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        // same approach as normal two sum
        for(int i=0; i<numbers.length; i++) {
            if(map.containsKey(target-numbers[i])) {
                // since the array is sorted
                // check the values to return index of the smaller element first
                if(target - numbers[i] <= numbers[i]) {
                    res[0] = map.get(target-numbers[i]);
                    res[1] = i+1;
                } else {
                    res[0] = i+1;
                    res[1] = map.get(target-numbers[i]);
                }
                break;
            }
            
            map.put(numbers[i], i+1);
        }
        
        return res;
    }

    // O(N) time, O(1) space using two pointer approach
    public int[] twoSumTwoPointer(int[] numbers, int target) {
        int[] res = {-1,-1};
        // two pointer approach
        int l=0, r=numbers.length-1;
    
        while(l<=r) {
            // calculate the sum
            int sum = numbers[l] + numbers[r];
            // sum = target
            if(sum == target) {
                // return the indices
                res[0] = l+1;
                res[1] = r+1;
                break;
            } else if(sum < target)
                // sum less than target
                // means need to add bigger elements
                // array is sorted, so elements on the right are bigger
                // move right
                l++;
            else
                // sum greater than target
                // add smaller element
                // move left
                r--;
        }
        
        return res;
    }
}