class PriorityQueueLastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        if(n == 0)
            return 0;
        
        if(n == 1)
            return stones[0];
        
        Queue<Integer> pq = new PriorityQueue<Integer>(n, (a, b)-> {
            return b-a;
        });
        
        // create a max heap of all the stone weights
        // pq.addAll(Arrays.asList(stones)); -> does not work for array of primitives
        for(int stone: stones)
            pq.add(stone);
        
        // pull out two stones from the heap
        while(pq.size() >= 2) {
            // since its a max heap, these are the stones with the max weight
            int wt1 = pq.poll();
            int wt2 = pq.poll();
            
            // if the weights are equal, we do nothing, the stones are destroyed
            // if the weights are unequal, we add the difference back into the queue
            if(wt1 != wt2)
                pq.add(wt1 - wt2);
        }
        
        // return the stone weight remaining
        return pq.size() == 0 ? 0 : pq.poll();
    }
}