class PriorityQueueKthLargestElement {
    int kNum;
    Queue<Integer> heap;

    public KthLargest(int k, int[] nums) {
        kNum = k;
        int n = nums.length;
        
        // create a min heap
        heap = new PriorityQueue<Integer>();
        
        for(int num: nums)
            heap.add(num);
        
        // remove all the smaller elements and keep only k elements
        // this means the first element in the heap is the kth largest
        // (among k elements it is the least, which means its kth largest)
        while(heap.size() > kNum)
            heap.poll();
    }
    
    public int add(int val) {
        // add the value to the heap
        heap.add(val);
        
        // remove excess elements
        if(heap.size() > kNum)
            heap.poll();
        
        // return the first element
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */