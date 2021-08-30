class ArrMaxProductOfTwoElements {
    // Using sorting
    // O(n log n) / O(1)
    public int maxProduct(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        Arrays.sort(nums);
        return (nums[nums.length-1]-1) * (nums[nums.length-2]-1);
    }

    // Using Heap
    // O(n log n) / O(n)
    public int maxProductHeap(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        Queue<Integer> pq = new PriorityQueue<Integer>(nums.length, (a,b) -> {return b-a;});
        
        for(int i = 0; i < nums.length; i++) {
            pq.add(nums[i]-1);
        }
        
        int num1 = pq.poll();
        int num2 = pq.poll();
        
        return num1 * num2;
    }

    // Linear scan
    // O(n) / O(1)
    public int maxProductLinear(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int max1 = -1, max2 = -1;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > max1) {
                // store the previous max in max2, as this is probably the second maximal element
                max2 = max1;
                max1 = nums[i];
            } else if(nums[i] > max2)
                max2 = nums[i];
        }
        
        return (max1-1)*(max2-1);
    }
}