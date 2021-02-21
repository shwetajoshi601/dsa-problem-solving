class ArrFourSum {
    // O(n^3) time, O(1) space
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        // sort the array
        Arrays.sort(nums);
        
        // reduce the problem to two sum
        for(int i = 0; i< n-3; i++) {
            for(int j = i+1; j < n; j++) {
                // a+b = target-c-d, if a+b+c+d=target
                int twoSum = target - nums[i] - nums[j];
                // use two pointer technique
                int front = j+1;
                int back = n-1;
                while(front < back) {
                    int currSum = nums[front] + nums[back];
                    if(currSum == twoSum) {
                        // found quadruplet
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[front]);
                        quad.add(nums[back]);
                        result.add(quad);  
                        // handle duplicates in number 3
                        // loop can also be rewritten as while(front+1 < back && nums[front] == nums[front+1])
                        while(front < n && nums[front] == quad.get(2)) ++front;
                        // handle duplicates in number 4
                        while(back > j+1 && nums[back] == quad.get(3)) --back;
                    } else if(currSum < twoSum)
                        front++;
                    else
                        back--;
                }
                // handle duplicates in number 2
                while(j+1 < n && nums[j] == nums[j+1]) j++;
            }
            // handle duplicates in number 1
            while(i+1 < n && nums[i] == nums[i+1]) i++;
        }
        
        return result;
    }
}