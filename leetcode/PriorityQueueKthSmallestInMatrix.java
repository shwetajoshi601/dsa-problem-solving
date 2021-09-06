class PriorityQueueKthSmallestInMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        // max heap
        Queue<Integer> pq = new PriorityQueue<Integer>((a,b) -> {return b-a;});
        
        for(int i=0;i<matrix.length; i++) {
            for(int j=0; j<matrix.length; j++) {
                pq.add(matrix[i][j]);
                
                // when size exceeds k, remove element
                if(pq.size() > k)
                    pq.poll();
            }
        }
        
        // the first element is the kth smallest
        return pq.peek();
    }
}