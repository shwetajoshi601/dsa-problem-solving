class PriorityQueueFindKthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        // Create a min heap
        Queue<Integer> pq = new PriorityQueue<Integer>(k, (a, b) -> {
            return a-b;
        });
        
        // iterate through the array and add to the heap
        for(int num: nums) {
            pq.add(num);
            
            // if heap size exceeds k remove an element
            // heap always contains k largest elements, the kth largest is at the root
            if(pq.size() > k)
                pq.poll();
        }
        
        // return the first element
        return pq.peek();
    }
}