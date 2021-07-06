class StackTrappingRainwater {

    // this is a solution without using stacks
    // TODO: using stacks

    // O(n), Space -> o(n)
    public int trap(int[] height) {
        int n = height.length;
        int totalWaterTrapped = 0;
        
        
        if(n == 0 || n ==1) return 0;
        
        // for each height, find the maximum height to the left and right
        int[] maxLeft = new int[n];
        // for the first element, the max height is itself
        maxLeft[0] = height[0];
        
        int[] maxRight = new int[n];
        maxRight[n-1] = height[n-1];
        
        // find the max height on the left for each given height
        // compare it to the max height of the previous
        // update if a greater value is found
        for(int i=1; i<n; i++)
            maxLeft[i] = Math.max(maxLeft[i-1], height[i]);


        // find the max height on the right for each given height
        // compare with the max height of the right heights
        for(int i=n-2; i>=0; i--)
            maxRight[i] = Math.max(maxRight[i+1], height[i]);

        // find the rainwater trapped above each height
        // the minimum level of the maxLeft and maxRight would give us the level of water
        // however, the actual volume of the trapped water would exclude the building height (height occupies that much volume)
        int[] waterTrapped = new int[n];
        
        for(int i=0; i<n; i++)
            waterTrapped[i] = Math.min(maxLeft[i], maxRight[i]) - height[i];
        
        // sum all the values to get the total trapped water
        for(int i=0; i<n; i++)
            totalWaterTrapped+=waterTrapped[i];
        
        return totalWaterTrapped;
    }
}